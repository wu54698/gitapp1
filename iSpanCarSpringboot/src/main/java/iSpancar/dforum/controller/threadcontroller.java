package iSpancar.dforum.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import iSpancar.dforum.model.ForumMember;
import iSpancar.dforum.model.Post;
import iSpancar.dforum.model.Thread;
import iSpancar.dforum.service.QueryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class threadcontroller {
	@Autowired
	private QueryHelper query;
	
	@GetMapping("/thread.controller")
	@ResponseBody
	protected String processdoGetAction(@RequestParam("id") String id)
			throws ServletException, IOException {
		return(query.getThread(Integer.parseInt(id)));
	}
	
	@PostMapping("/thread.controller")
	protected String processdoPostAction(@RequestParam("memberId") String memberId,@RequestParam("time")String time,
			@RequestParam("body")String body,@RequestParam("title")String title,@RequestParam("category")String category)
			throws ServletException, IOException {

		Thread thread = query.newThread(Integer.parseInt(category));

		Post post = new Post();
		post.setOP(true);
		ForumMember member = new ForumMember();
		member.setId(Integer.parseInt(memberId));
		post.setMember(member);
		post.setTime(new Timestamp(Long.parseLong(time)));
		post.setBody(body);
		post.setTitle(title) ;
		post.setThread(thread);
		query.newPost(post);

		return "dforum/threads";

		//response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
		//response.setHeader("Location", "threads.jsp");
		

}

	

}
