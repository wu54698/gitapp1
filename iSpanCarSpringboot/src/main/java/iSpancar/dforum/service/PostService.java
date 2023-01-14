package iSpancar.dforum.service;

import iSpancar.dforum.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PostService extends JpaRepository<Post, Integer> {
}
