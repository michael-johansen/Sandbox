package no.sandbox.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ParentChildLinkId implements Serializable {
	private static final long serialVersionUID = 2671785816826914056L;
	@ManyToOne
	@JoinColumn(name = "parent_id", referencedColumnName = "id")
	Parent parent;
	@ManyToOne
	@JoinColumn(name = "child_id", referencedColumnName = "id")
	Child child;
}