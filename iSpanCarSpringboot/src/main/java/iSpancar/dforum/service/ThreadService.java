package iSpancar.dforum.service;

import iSpancar.dforum.model.Category;
import iSpancar.dforum.model.Post;
import iSpancar.dforum.model.Thread;
import iSpancar.dforum.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

@Service
public class ThreadService {

    @Resource
    private ThreadRepository threadRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Post> findList(Integer categoryId, String title) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> q = criteria.createQuery(Post.class);
        Root<Post> root = q.from(Post.class);
        root.join("member", JoinType.LEFT);
        Join<Post, Thread> c = root.join("thread", JoinType.INNER);
        Join<Thread, Category> d = c.join("category", JoinType.LEFT);

        q.where(
                criteria.equal(root.get("isOP"), 1)
        );

        if (categoryId != null) {
            q.where(
                    criteria.equal(d.get("id"), categoryId)
            );
        }

        if (StringUtils.hasText(title)) {
            q.where(
                    criteria.like(root.get("title"), title)
            );
        }

        List<Post> resultList = entityManager.createQuery(q).getResultList();
        return resultList;
    }

    public Post findOneById(Integer postId) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> q = criteria.createQuery(Post.class);
        Root<Post> root = q.from(Post.class);
        root.join("member", JoinType.LEFT);
        Join<Post, Thread> c = root.join("thread", JoinType.INNER);
        Join<Thread, Category> d = c.join("category", JoinType.LEFT);
        q.where(
                criteria.equal(root.get("isOP"), 1)
        );

        if (postId != null) {
            q.where(
                    criteria.equal(root.get("id"), postId)
            );
        }
        List<Post> resultList = entityManager.createQuery(q).getResultList();
        return resultList.get(0);
    }
}
