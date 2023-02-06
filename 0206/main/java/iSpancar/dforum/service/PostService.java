package iSpancar.dforum.service;

import iSpancar.dforum.model.PostMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class PostService {

	@Autowired
	private EntityManager entityManager;

	public List<PostMessage> getPostMessageList(Integer postId) {
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<PostMessage> q = criteria.createQuery(PostMessage.class);
		Root<PostMessage> root = q.from(PostMessage.class);
		Join<Object, Object> post = root.join("post", JoinType.LEFT);
		q.where(criteria.equal(post.get("id"), postId));
		q.orderBy(criteria.desc(root.get("id")));
		List<PostMessage> resultList = entityManager.createQuery(q).getResultList();
		return resultList;
	}
}
