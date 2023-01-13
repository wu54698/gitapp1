package iSpancar.dforum.model;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
@Transactional
public class CategoryDao {
	@Autowired
	private SessionFactory factory;
	
	public String getCategories() throws JsonProcessingException {

		Session session = factory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Category> criteria = builder.createQuery(Category.class);

		Root<Category> root = criteria.from(Category.class);

		List<Category> list = session.createQuery(criteria).getResultList();

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(list);
		session.close();
		return json;
	}
	
}
