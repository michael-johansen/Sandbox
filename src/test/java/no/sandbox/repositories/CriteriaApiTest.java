package no.sandbox.repositories;

import no.sandbox.config.PersistenceConfig;

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
public class CriteriaApiTest {
	@Autowired
	private CustomerRepository customerRepository;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testName() throws Exception {
		
	}

//	@Test
//	public void test() {
//		List<Customer> result = customerRepository.findAll(specification);
//		System.out.println(result);
//	}
//
//	Specification<Customer> specification = new Specification<Customer>() {
//		@Override
//		public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//			Predicate firstname = cb.like(cb.lower(root.get(Customer_.firstName)), "%en%".toLowerCase());
//			Predicate lastname = cb.like(cb.lower(root.get(Customer_.lastName)), "%s%".toLowerCase());
//			return cb.and(firstname, lastname);
//		}
//	};

}
