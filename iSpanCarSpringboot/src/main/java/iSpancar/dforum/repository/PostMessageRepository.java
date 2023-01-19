package iSpancar.dforum.repository;

import iSpancar.dforum.model.PostMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMessageRepository extends JpaRepository<PostMessage, Integer> {
}
