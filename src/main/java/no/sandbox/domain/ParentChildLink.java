package no.sandbox.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

@Entity
public class ParentChildLink {
	@Id
	@GeneratedValue
	Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	Parent parent;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "child_id")
	Child child;
	@OrderBy
	Integer position;

}
