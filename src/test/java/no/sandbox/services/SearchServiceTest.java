package no.sandbox.services;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.sandbox.config.PersistenceConfig;
import no.sandbox.config.ServicesConfig;
import no.sandbox.domain.Customer;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, ServicesConfig.class })
public class SearchServiceTest {

	@Autowired
	private SearchService searchService;

	@Test
	public void testSearch() {
		Map<String, String[]> parameterMap = new HashMap<>();
		parameterMap.put("firstName",new String[]{"Felix"});
		assertThat(searchService.search(Customer.class, parameterMap).size(), is(1));
	}

	@Test
	public void testSearchNoHits() {
		Map<String, String[]> parameterMap = new HashMap<>();
		parameterMap.put("firstName",new String[]{"Albert"});
		List<Customer> searchResult = searchService.search(Customer.class, parameterMap);
		assertThat(searchResult.size(), is(0));
	}

	@Test
	public void testSearchNoParamtersFindsAll() {
		assertThat(searchService.search(Customer.class, new HashMap<String, String[]>()).size(), is(100));
	}

	@Test(expected=NoSuchBeanDefinitionException.class)
	public void testSearchWhenTheresNoRepository() {
		searchService.search(Integer.class, new HashMap<String, String[]>());
	}
}
