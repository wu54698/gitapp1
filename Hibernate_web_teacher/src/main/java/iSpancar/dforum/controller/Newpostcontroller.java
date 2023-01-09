package iSpancar.dforum.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iSpancar.dforum.model.ForumMember;
import iSpancar.dforum.model.Post;
import iSpancar.dforum.model.Thread;
import iSpancar.dforum.service.QueryHelper;

@Controller
public class Newpostcontroller {
	
	@Autowired
	private QueryHelper query;
	
	@PostMapping("/Newpost.controller")
	public String processNewpostAction(@RequestParam("memberId") String memberId,@RequestParam("time")String time,
			@RequestParam("body")String body,@RequestParam("title")String title,@RequestParam("threadId")String threadId) {
	
		Post post = new Post();
		post.setOP(false);
		ForumMember member = new ForumMember();
		member.setId(Integer.parseInt(memberId));
		post.setMember(member);
		post.setTime(new Timestamp(Long.parseLong(time)));
		post.setBody(body);
		post.setTitle(title) ;
		Thread thread = new Thread();
		thread.setId(Integer.parseInt(threadId));
		post.setThread(thread);
		query.newPost(post);
		return "thread?id="+ threadId;
		

	}
	@DeleteMapping("/doDlete.controller")
	protected void processdoDeleteAction(@RequestParam("Id")String Id) throws ServletException, IOException {
		query.deletePost(Integer.parseInt(Id));
		//response.getWriter().append("deleted "+updateCount+" data");

}
}
