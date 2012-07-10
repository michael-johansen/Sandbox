package no.sandbox.web.converter;

import java.io.IOException;

import no.sandbox.domain.Document;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;

public class MultipartFileToStringConverter implements Converter<MultipartFile, Document> {

	@Override
	public Document convert(MultipartFile source) {
		try {
			Document document = new Document();
			document.setContent(source.getBytes());
			document.setContentType(source.getContentType());
			document.setFileName(source.getOriginalFilename());
			return document;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
