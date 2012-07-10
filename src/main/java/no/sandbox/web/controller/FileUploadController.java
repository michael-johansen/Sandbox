package no.sandbox.web.controller;

import java.util.HashMap;
import java.util.Map;

import no.sandbox.domain.Document;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	@RequestMapping(value = { "file-upload" })
	public ModelAndView fileUpload(Map<String, Object> model) {
		Document document = new Document();
		document.setFileName("hello");
		
		Map<String, Object> documents = new HashMap<>();
		documents.put("one", document);
		
		return new ModelAndView("file-upload", "documenst", documents);
	}
}
