package no.sandbox.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	@RequestMapping(value = { "file-upload" })
	public ModelAndView fileUpload(Map<String, Object> model) {
		throw new IllegalStateException();
//			throw new RuntimeException();
	}
}
