package dforum.service;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import dforum.model.Category;
import dforum.model.ForumMember;
import dforum.model.Post;
import dforum.model.Thread;
import util.HibernateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class QueryHelper {

	public String getThreads() throws JsonProcessingException {

		// 建立 Session
		Session session = HibernateUtil.getSessionFactory().openSession();

		// 建立 CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Post> criteria = builder.createQuery(Post.class);

		Root<Post> root = criteria.from(Post.class);
		criteria.where(builder.equal(root.get("isOP"), 1));
		root.join("member", JoinType.LEFT);
		Join<Post, Thread> threadJoin = root.join("thread", JoinType.INNER);
		threadJoin.join("category", JoinType.LEFT);

		// 執行查詢
		List<Post> posts = session.createQuery(criteria).getResultList();

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(posts);
		session.close();
		return json;

	}

	public String getThread(int threadId) throws JsonProcessingException {
		// 建立 Session
		Session session = HibernateUtil.getSessionFactory().openSession();

		// 建立 CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Post> criteria = builder.createQuery(Post.class);

		Root<Post> root = criteria.from(Post.class);
		criteria.where(builder.equal(root.get("thread"), threadId));
		root.join("member", JoinType.LEFT);
		Join<Post, Thread> threadJoin = root.join("thread", JoinType.INNER);
		threadJoin.join("category", JoinType.LEFT);

		// 執行查詢
		List<Post> posts = session.createQuery(criteria).getResultList();

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(posts);
		session.close();
		return json;
		
	}

	public String getCategories() throws JsonProcessingException {

		Session session = HibernateUtil.getSessionFactory().openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Category> criteria = builder.createQuery(Category.class);

		Root<Category> root = criteria.from(Category.class);

		List<Category> list = session.createQuery(criteria).getResultList();

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(list);
		session.close();
		return json;
	}

	public Thread newThread(int categoryId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		dforum.model.Thread thread = new dforum.model.Thread();
		Category cate = session.get(Category.class, categoryId);
		thread.setCategory(cate);
		thread.setTime(new java.sql.Timestamp(new Date().getTime()));
		session.save(thread);

		transaction.commit();

		return thread;
	}

	public void newPost(Post post) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		// 使用 save() 新增資料
		session.save(post);

		// 關閉 Session
		session.close();
	}

	public void deletePost(int postId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Post post = session.get(Post.class, postId);
		session.delete(post);
		transaction.commit();
		session.close();
	}

}
