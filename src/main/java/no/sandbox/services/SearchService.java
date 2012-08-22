package no.sandbox.services;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SearchService {
	@Autowired
	private ApplicationContext context;

	public <T> List<T> search(Class<T> clazz, Map<String, String[]> parameterMap) {
		return findExecutorByClass(clazz).findAll(and(this.<T> converToSpecifications(parameterMap)));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <T> JpaSpecificationExecutor<T> findExecutorByClass(Class<T> clazz) {
		Map<String, JpaSpecificationExecutor> executors = context.getBeansOfType(JpaSpecificationExecutor.class);
		for (String key : executors.keySet())
			if (key.equals(StringUtils.uncapitalize(clazz.getSimpleName()) + "Repository"))
				return executors.get(key);
		throw new NoSuchBeanDefinitionException(clazz, "no JpaSpecificationExecutor for Entity. Entity: "
				+ clazz.getName() + ". Executors found: " + executors);
	}

	private <T> List<Specification<T>> converToSpecifications(Map<String, String[]> parameterMap) {
		List<Specification<T>> specifications = new ArrayList<>();
		for (String key : parameterMap.keySet())
			specifications.add(this.<T, String> stringSpecification(key, asList(parameterMap.get(key))));
		return specifications;
	}

	private <T, S> Specification<T> stringSpecification(final String propertyName, final List<S> propertyValues) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return root.<S> get(propertyName).in(propertyValues);
			}
		};
	}

	private <T> Specification<T> initSpecification() {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.conjunction();
			}
		};
	}

	private <T> Specification<T> and(final List<Specification<T>> specifications) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Specifications<T> where = (Specifications<T>) Specifications.where(SearchService.this
						.<T> initSpecification());
				for (Specification<T> specification : specifications)
					where = where.and(specification);
				return where.toPredicate(root, query, cb);
			}
		};
	}
}
