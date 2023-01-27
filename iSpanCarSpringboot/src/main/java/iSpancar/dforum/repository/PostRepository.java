package iSpancar.dforum.repository;

import iSpancar.dforum.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
