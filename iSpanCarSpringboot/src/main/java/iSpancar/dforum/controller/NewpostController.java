package iSpancar.dforum.controller;

import iSpancar.dforum.model.ForumMember;
import iSpancar.dforum.model.Post;
import iSpancar.dforum.model.Thread;
import iSpancar.dforum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("/post")
public class NewpostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public void processNewpostAction(
            HttpServletResponse rsp,
            @RequestParam("memberId") String memberId,
            @RequestParam("time") String time,
            @RequestParam("body") String body,
            @RequestParam("title") String title,
            @RequestParam("threadId") String threadId
    ) {

        Post post = new Post();
        post.setOP(false);
        ForumMember member = new ForumMember();
        member.setId(Integer.parseInt(memberId));
        post.setMember(member);
        post.setTime(new Timestamp(Long.parseLong(time)));
        post.setBody(body);
        post.setTitle(title);
        Thread thread = new Thread();
        thread.setId(Integer.parseInt(threadId));
        post.setThread(thread);
        // 保存
        postService.save(post);
        try {
            rsp.sendRedirect("thread/threadsView");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //no save ......

    @DeleteMapping
	@ResponseBody
    protected ResponseEntity processdoDeleteAction(@RequestParam("Id") Integer id) {
        postService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
