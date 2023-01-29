package iSpancar.dforum.repository;

import iSpancar.dforum.model.PostMain;
import iSpancar.dforum.model.PostMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMessageRepository extends JpaRepository<PostMessage, Integer> {

	void deleteByPost(PostMain postMain);

	List<PostMessage> findPostMessageByPost(PostMain postMain);

}
