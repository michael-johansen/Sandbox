package no.sandbox.repositories;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


import no.sandbox.config.RepositoriesConfig;
import no.sandbox.domain.Customer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RepositoriesConfig.class })
@Transactional
public class RepositoriesConfigTest {

	@Autowired
	private CustomerRepository repository;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void canSaveCustomer() {
		assertThat(repository.count(), is(0l));		
		repository.save(new Customer());		
		assertThat(repository.count(), is(1l));
	}

}
