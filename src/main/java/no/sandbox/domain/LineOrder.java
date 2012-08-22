package no.sandbox.domain;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LineOrder {
	@Id
	private Long id;
	@ManyToOne
	private Customer customer;
	private Date orderedDate;
	@OneToMany
	private Set<LineOrderItem> orderItems;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Long getId() {
		return id;
	}

	public Set<LineOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<LineOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
