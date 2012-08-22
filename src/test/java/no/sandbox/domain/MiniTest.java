package no.sandbox.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.sandbox.config.PersistenceConfig;
import no.sandbox.domain.Child;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class })
@Transactional
public class MiniTest {
	@PersistenceContext
	private EntityManager entityManager;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testName() throws Exception {
		ParentChildLink e = new ParentChildLink();
		e.child = new Child();
		
		Parent parent = new Parent();
		parent.childLinks.add(e);
		
		
		
		entityManager.persist(parent);		
		entityManager.flush();
	}


}
