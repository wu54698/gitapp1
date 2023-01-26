package iSpancar.dforum.controller;

import iSpancar.dforum.model.PostMessage;
import iSpancar.dforum.repository.PostMessageRepository;
import iSpancar.dforum.service.PostService;
import iSpancar.dforum.service.WebContextService;
import iSpancar.member.model.MemberBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostMessageRepository postMessageRepository;

	@Autowired
	private WebContextService webContextService;

	@Autowired
	private PostService postService;

	/**
	 * add post message
	 *
	 * @param postMessage
	 */
	@PostMapping("/message")
	public ResponseEntity<String> message(@RequestBody PostMessage postMessage) {
		postMessage.setTime(new Date());
		MemberBean loginUser = webContextService.getCurrUser();
		if (loginUser == null) {
			return ResponseEntity.ok("no login");
		}
		postMessage.setMember(loginUser);
		postMessageRepository.save(postMessage);
		return ResponseEntity.ok("留言成功！");
	}

	/**
	 * list all
	 *
	 * @return
	 */
	@GetMapping("/message/{postId}")
	public ResponseEntity<List<PostMessage>> messageAll(@PathVariable Integer postId) {
		return ResponseEntity.ok(postService.getPostMessageList(postId));
	}

}
