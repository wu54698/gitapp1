package iSpancar.dforum.controller;

import iSpancar.dforum.model.Category;
import iSpancar.dforum.model.ForumMember;
import iSpancar.dforum.model.Post;
import iSpancar.dforum.model.Thread;
import iSpancar.dforum.repository.CategoryRepository;
import iSpancar.dforum.repository.PostRepository;
import iSpancar.dforum.repository.ThreadRepository;
import iSpancar.dforum.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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

    @GetMapping
    @ResponseBody
    protected ResponseEntity get(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(threadRepository.findById(id));
    }

    @GetMapping("/threadsView")
    public String threadsView(Model view, @RequestParam(required = false) Integer categoryId, @RequestParam(required = false) String title) {
        List<Post> threadsList = threadService.findList(categoryId, title);
        view.addAttribute("postList", threadsList);
        view.addAttribute("categoryId", categoryId);
        view.addAttribute("title", title);
        return "dforum/threadsList";
    }

    @GetMapping("/thread/{postId}")
    public String threadsView(@PathVariable Integer postId, @RequestParam(required = false, defaultValue = "false") Boolean edit, Model model) {
        Post post = threadService.findOneById(postId);
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
    protected void save(
            HttpServletResponse rsp,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam("memberId") Integer memberId,
            @RequestParam("body") String body,
            @RequestParam("title") String title,
            @RequestParam("category") Integer category
    ) {

        Thread saveThread = categoryService.findById(category).map((cat) -> {
            Thread thread = new Thread();
            thread.setCategory(cat);
            thread.setTime(new Date());
            threadRepository.save(thread);
            return thread;
        }).orElse(null);
        Post post = new Post();
        post.setOP(true);
        post.setId(id);
        ForumMember member = new ForumMember();
        member.setId(memberId);
        post.setMember(member);
        post.setTime(new Date());
        post.setBody(body);
        post.setTitle(title);
        post.setThread(saveThread);
        postService.save(post);
        try {
            rsp.sendRedirect("threadsView");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/thread/all")
    public ResponseEntity<List<Post>> processThreadsAction() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> q = criteria.createQuery(Post.class);
        Root<Post> root = q.from(Post.class);
        root.join("member", JoinType.LEFT);
        Join<Post, Thread> c = root.join("thread", JoinType.INNER);
        Join<Thread, Category> d = c.join("category", JoinType.LEFT);
        q.where(criteria.equal(root.get("isOP"), 1));
        return ResponseEntity.ok(entityManager.createQuery(q).getResultList());

    }


}
