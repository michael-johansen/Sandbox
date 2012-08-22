package no.sandbox.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Child {
	@Id
	@GeneratedValue
	Long id;
	@OneToMany(mappedBy = "child", cascade = CascadeType.ALL)
	Set<ParentChildLink> childLinks = new HashSet<>();
	String name;
}
