package no.sandbox.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parent {
	@Id
	@GeneratedValue
	Long id;
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	Set<ParentChildLink> childLinks = new HashSet<>();
}
