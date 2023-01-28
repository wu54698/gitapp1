package iSpancar.dforum.controller;

import iSpancar.dforum.model.Category;
import iSpancar.dforum.model.PostMain;
import iSpancar.dforum.model.PostMainSaveParam;
import iSpancar.dforum.model.Thread;
import iSpancar.dforum.repository.CategoryRepository;
import iSpancar.dforum.repository.PostRepository;
import iSpancar.dforum.repository.ThreadRepository;
import iSpancar.dforum.service.ThreadService;
import iSpancar.dforum.service.WebContextService;
import iSpancar.member.model.MemberBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ThreadController {

	@Autowired
	private ThreadRepository threadRepository;

	@Autowired
	private ThreadService threadService;

	@Autowired
	private CategoryRepository categoryService;

	@Autowired
	private PostRepository postService;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private WebContextService webContextService;

	@GetMapping
	@ResponseBody
	protected ResponseEntity get(@RequestParam("id") Integer id) {
		return ResponseEntity.ok(threadRepository.findById(id));
	}

	@GetMapping("/threadsView")
	public String threadsView(Model view, @RequestParam(required = false) Integer categoryId, @RequestParam(required = false) String title) {
		List<PostMain> threadsList = threadService.findList(categoryId, title);
		view.addAttribute("postList", threadsList);
		view.addAttribute("categoryId", categoryId);
		view.addAttribute("title", title);
		return "dforum/threadsList";
	}

	@GetMapping("/thread/{postId}")
	public String threadsView(@PathVariable Integer postId, @RequestParam(required = false, defaultValue = "false") Boolean edit, Model model) {
		PostMain post = threadService.findOneById(postId);
		model.addAttribute("post", post);
		return edit ? "dforum/threadsEdit" : "dforum/threadsView";
	}

	@RequestMapping("/thread/newthread")
	public String newThread() {
		return "dforum/threadsAdd";
	}

	@PostMapping("/thread")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	protected ResponseEntity<String> save(@RequestBody PostMainSaveParam postMainSaveParam) {

		Thread saveThread = categoryService.findById(postMainSaveParam.getCategory()).map((cat) -> {
			Thread thread = new Thread();
			thread.setCategory(cat);
			thread.setTime(new Date());
			threadRepository.save(thread);
			return thread;
		}).orElse(null);
		PostMain post = new PostMain();
		post.setOP(true);
		post.setId(postMainSaveParam.getId());
		if (postMainSaveParam.getId() == null) {
			String uuid = UUID.randomUUID().toString();
			post.setUuid(uuid);
		}
		MemberBean currUser = webContextService.getCurrUser();
		if (currUser == null) {
			return ResponseEntity.ok("no login");
		}
		post.setMember(currUser);
		post.setTime(new Date());
		String body = postMainSaveParam.getBody();
		post.setBody(body);
		// body not blank set image
		if (StringUtils.hasText(post.getBody())) {
			Document parse = Jsoup.parse(post.getBody());
			Elements imgs = parse.select("img");
			if (imgs != null && !imgs.isEmpty()) {
				post.setImage(imgs.get(0).toString());
			}
			String text = parse.text();
			post.setBodySimple(text.substring(0, text.length() > 500 ? 500 : text.length()));
		}
		post.setTitle(postMainSaveParam.getTitle());
		post.setThread(saveThread);
		post.setBest(postMainSaveParam.getBest());
		post.setFloorCount(1);
		post.setLikeCount(0);
		post.setDisLikeCount(0);
		post.setInteractiveCount(1);
		post.setPopularityCount(1);
		post.setCategoryId(postMainSaveParam.getCategory());
		postService.save(post);

		return ResponseEntity.ok("操作成功!");
	}

	@GetMapping("/thread/all")
	public ResponseEntity<List<PostMain>> processThreadsAction() {
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<PostMain> q = criteria.createQuery(PostMain.class);
		Root<PostMain> root = q.from(PostMain.class);
		root.join("member", JoinType.LEFT);
		Join<PostMain, Thread> c = root.join("thread", JoinType.INNER);
		Join<Thread, Category> d = c.join("category", JoinType.LEFT);
		q.where(criteria.equal(root.get("isOP"), 1));
		return ResponseEntity.ok(entityManager.createQuery(q).getResultList());

	}

	@DeleteMapping("/thread/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		try {
			postService.deleteById(id);
		}catch (Exception e){
			return ResponseEntity.ok("刪除失敗，已有留言！");
		}
		return ResponseEntity.ok("操作成功！");

	}


}
