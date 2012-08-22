package no.sandbox.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LineOrderItem {
	@Id
	private Long id;
	@ManyToOne
	private LineOrder order;
	private Double quantity;
	@ManyToOne
	private Item item;

	public LineOrder getOrder() {
		return order;
	}

	public void setOrder(LineOrder order) {
		this.order = order;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
