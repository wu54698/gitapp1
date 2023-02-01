package iSpancar.dforum.service;

import iSpancar.dforum.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService extends JpaRepository<Category, Integer> {
}
