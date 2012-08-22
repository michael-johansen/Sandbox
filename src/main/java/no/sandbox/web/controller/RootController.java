package no.sandbox.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {
	@RequestMapping(value = { "" })
	public ModelAndView fileUpload(Map<String, Object> model) {
		return new ModelAndView("index");
	}
}
