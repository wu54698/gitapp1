package iSpancar.dforum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import iSpancar.dforum.service.QueryHelper;

@Controller
public class categoriescontroller {

	@Autowired
	private QueryHelper query;
	
	@GetMapping("/categories.controller")
	@ResponseBody
	public String processCategoriesAction() {
		try {
			return query.getCategories();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
