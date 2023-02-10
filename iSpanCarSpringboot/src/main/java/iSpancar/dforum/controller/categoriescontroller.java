package iSpancar.dforum.controller;

import iSpancar.dforum.model.Category;
import iSpancar.dforum.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/backstage/category")
public class CategoriesController {

	@Autowired
	private CategoryRepository categoryService;

	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<List<Category>> processCategoriesAction() {
		List<Category> categories = categoryService.findAll();

		return ResponseEntity.ok(categories);
	}
}
