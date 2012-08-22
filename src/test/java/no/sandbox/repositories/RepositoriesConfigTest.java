package no.sandbox.repositories;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.GregorianCalendar;

import javax.validation.ConstraintViolationException;

import no.sandbox.config.PersistenceConfig;
import no.sandbox.domain.Customer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class })
@Transactional
public class RepositoriesConfigTest {
	@Autowired
	private CustomerRepository repository;
	private Customer customer;

	@Before
	public void setUp() throws Exception {
		customer = new Customer();
		customer.setFirstName("Ola");
		customer.setLastName("Nordmann");
		customer.setCity("Oslo");
		customer.setCounty("Oslo");
		customer.setPhoneNumber("+4712345678");
		customer.setEmail("ola.nordmann@online.no");
		customer.setPostal("0123");
		customer.setAddress("Trondheimsveien 131");
		customer.setBirthday(new GregorianCalendar(1983, 11, 11).getTime());
		customer.setCreated(new GregorianCalendar(2012, 5, 20).getTime());
	}

	@Test
	public void canSaveCustomer() {
		long initCount = repository.count();
		repository.saveAndFlush(customer);
		assertThat(repository.count(), is(initCount + 1));
	}

	@Test(expected = ConstraintViolationException.class)
	public void firstNameIsRequired() {
		customer.setFirstName(null);
		repository.saveAndFlush(customer);
	}

	@Test(expected = ConstraintViolationException.class)
	public void lastNameIsRequired() {
		customer.setLastName(null);
		repository.saveAndFlush(customer);
	}

	@Test(expected = ConstraintViolationException.class)
	public void phonenumberWithLettersIsInvalid() throws Exception {
		customer.setPhoneNumber("invalid");
		repository.saveAndFlush(customer);
	}

	@Test
	public void phonenumberLeadingPlussIsValid() throws Exception {
		customer.setPhoneNumber("+4712345678");
		repository.saveAndFlush(customer);
	}

	@Test(expected = ConstraintViolationException.class)
	public void phonenumberNonLeadingPlussIsInvalid() throws Exception {
		customer.setPhoneNumber("4+4712345678");
		repository.saveAndFlush(customer);
	}

	@Test
	public void phonenumberContainingDashIsValid() throws Exception {
		customer.setPhoneNumber("1234-5678");
		repository.saveAndFlush(customer);
	}
}
