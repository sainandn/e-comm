package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Quantity")
public class Quantity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer quantityId;

	@OneToOne
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", unique = true)
	private Product product;

	@Column(name = "Quantity", nullable = false)
	private Integer quantity;

	// Getters and Setters
	public Integer getQuantityId() {
		return quantityId;
	}

	public void setQuantityId(Integer quantityId) {
		this.quantityId = quantityId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
