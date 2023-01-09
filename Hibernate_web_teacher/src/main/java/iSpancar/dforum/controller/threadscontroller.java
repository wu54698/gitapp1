package iSpancar.dforum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import iSpancar.dforum.service.QueryHelper;

public class threadscontroller {
	@Autowired
	private QueryHelper query;
	@GetMapping("/threads.controller")
	@ResponseBody
	public String processThreadsAction() {
		try {
			return query.getThreads();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
