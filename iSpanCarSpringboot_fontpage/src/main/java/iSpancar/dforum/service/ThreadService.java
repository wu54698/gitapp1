package iSpancar.dforum.service;

import iSpancar.dforum.model.Category;
import iSpancar.dforum.model.PostMain;
import iSpancar.dforum.model.Thread;
import iSpancar.dforum.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class ThreadService {

    @Resource
    private ThreadRepository threadRepository;

    @Autowired
    private EntityManager entityManager;

    public List<PostMain> findList(Integer categoryId, String title) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<PostMain> q = criteria.createQuery(PostMain.class);
        Root<PostMain> root = q.from(PostMain.class);
        root.join("member", JoinType.LEFT);
        Join<PostMain, Thread> c = root.join("thread", JoinType.INNER);
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

        List<PostMain> resultList = entityManager.createQuery(q).getResultList();
        return resultList;
    }

    public PostMain findOneById(Integer postId) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<PostMain> q = criteria.createQuery(PostMain.class);
        Root<PostMain> root = q.from(PostMain.class);
        root.join("member", JoinType.LEFT);
        Join<PostMain, Thread> c = root.join("thread", JoinType.INNER);
        Join<Thread, Category> d = c.join("category", JoinType.LEFT);
        q.where(
                criteria.equal(root.get("isOP"), 1)
        );

        if (postId != null) {
            q.where(
                    criteria.equal(root.get("id"), postId)
            );
        }
        List<PostMain> resultList = entityManager.createQuery(q).getResultList();
        return resultList.get(0);
    }
}
