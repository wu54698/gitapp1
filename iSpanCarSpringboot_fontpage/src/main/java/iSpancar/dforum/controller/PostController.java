package iSpancar.dforum.controller;

import iSpancar.dforum.model.PostMessage;
import iSpancar.dforum.query.PostMessageParam;
import iSpancar.dforum.repository.PostMessageRepository;
import iSpancar.dforum.service.PostService;
import iSpancar.dforum.service.WebContextService;
import iSpancar.member.model.MemberBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/backstage/post")
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
    public ResponseEntity<String> message(@RequestBody PostMessageParam postMessage) {
        postMessage.setTime(new Date());
        MemberBean loginUser = webContextService.getCurrUser();
        if (loginUser == null) {
            return ResponseEntity.ok("no login");
        }
        postMessage.setMember(loginUser);
        PostMessage createPostMessage = new PostMessage();
        BeanUtils.copyProperties(postMessage, createPostMessage);
        postMessageRepository.save(createPostMessage);
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
