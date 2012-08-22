package no.sandbox.web.controller;

import no.sandbox.domain.Customer;
import no.sandbox.repositories.CustomerRepository;
import no.sandbox.services.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("customers")
public class CustomerController {
	private static final boolean CONTEXT_RELATIVE = true;
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private SearchService searchService;

	@RequestMapping("new")
	public ModelAndView create() {
		return new ModelAndView("customer/edit", "customer", new Customer());
	}

	@RequestMapping(value = "{id}", method = { RequestMethod.GET })
	public ModelAndView fetch(@PathVariable("id") Customer customer) {
		return new ModelAndView("customer/edit", "customer", customer);
	}

	@RequestMapping(value = "{id}", method = { RequestMethod.DELETE })
	public RedirectView clear(@PathVariable("id") Customer customer) {
		repository.delete(customer);
		return new RedirectView("customers/", CONTEXT_RELATIVE);
	}

	@RequestMapping(value = "", method = { RequestMethod.POST, RequestMethod.PUT })
	public RedirectView save(Customer customer) {
		return new RedirectView("customers/" + repository.save(customer).getId(), CONTEXT_RELATIVE);
	}

	@RequestMapping(value = "", method = { RequestMethod.GET })
	public ModelAndView list() {
		return new ModelAndView("customer/list", "customers", repository.findAll());
	}

	@RequestMapping(value = "search", method = { RequestMethod.GET })
	public ModelAndView search(WebRequest request) {
		return new ModelAndView("customer/list", "customers", searchService.search(Customer.class,
				request.getParameterMap()));
	}
}
