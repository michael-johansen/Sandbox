package no.sandbox.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplicationInitializerImp implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(MvcConfig.class);

		servletContext.addListener(new ContextLoaderListener(rootContext));

		MultipartConfigElement multipartConfig = new MultipartConfigElement("/", 1000000l, 1000000l, 10000);
		DispatcherServlet servlet = new DispatcherServlet(rootContext);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", servlet);
		dispatcher.setMultipartConfig(multipartConfig);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
