package iSpancar.dforum.controller;

import iSpancar.dforum.model.Category;
import iSpancar.dforum.model.ForumMember;
import iSpancar.dforum.model.Post;
import iSpancar.dforum.model.Thread;
import iSpancar.dforum.service.CategoryService;
import iSpancar.dforum.service.PostService;
import iSpancar.dforum.service.TheadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private TheadService theadService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @Autowired
    private EntityManager entityManager;

    @GetMapping
    @ResponseBody
    protected ResponseEntity processdoGetAction(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(theadService.findById(id));
    }
    
	@RequestMapping("/threadsView")
	public  String threadsView () {
		return "dforum/threads";
	}
	
	@RequestMapping("/threadView")
	public  String threadView () {
		return "dforum/thread";
	}
	
	@RequestMapping("/thread/newthread")
	public  String newThread () {
		return "dforum/newthread";
	}
  
    @PostMapping("/thread")
    @Transactional(rollbackFor = Exception.class)
    protected void processdoPostAction(
            HttpServletResponse rsp,
            @RequestParam("memberId") Integer memberId,
            @RequestParam("time") String time,
            @RequestParam("body") String body,
            @RequestParam("title") String title,
            @RequestParam("category") Integer category
    ) {

        Thread saveThread = categoryService.findById(category).map((cat) -> {
            Thread thread = new Thread();
            thread.setCategory(cat);
            thread.setTime(new Timestamp(Long.parseLong(time)));
            theadService.save(thread);
            return thread;
        }).orElse(null);
        Post post = new Post();
        post.setOP(true);
        ForumMember member = new ForumMember();
        member.setId(memberId);
        post.setMember(member);
        post.setTime(new Timestamp(Long.parseLong(time)));
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
    
    // 你的項目編譯問題

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
