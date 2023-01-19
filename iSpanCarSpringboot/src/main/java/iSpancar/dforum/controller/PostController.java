package iSpancar.dforum.controller;

import iSpancar.dforum.model.PostMessage;
import iSpancar.dforum.repository.PostMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostMessageRepository postMessageRepository;

    /**
     * add post message
     *
     * @param postMessage
     */
    @PostMapping("/message")
    public ResponseEntity<String> message(@RequestBody PostMessage postMessage) {
        postMessage.setTime(new Date());
        postMessageRepository.save(postMessage);
        return ResponseEntity.ok("留言成功！");
    }

    /**
     * list all
     *
     * @return
     */
    @GetMapping("/message")
    public ResponseEntity<List<PostMessage>> messageAll() {
        List<PostMessage> postMessages = postMessageRepository.findAll(Sort.sort(PostMessage.class).by(PostMessage::getId).descending());
        return ResponseEntity.ok(postMessages);
    }

}
