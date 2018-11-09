package com.javasampleapproach.springrest.mysql.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ordersdetails")
public class OrderDetail { 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idorderdetails")
	private long id;
	
	@Column(name = "product_id")
	private String idProduct;

	@Column(name = "unit_price")
	private Double unitPrice;
	
	@Column(name = "quantity")
	private Double quantity;
	
	@Column(name = "discount")
	private int discount;
	
	@Column(name = "total")
	private Double total;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST)
	    @JoinColumn(name="order_id", referencedColumnName="order_id")
	    private Order order;
	 	
	public OrderDetail() {}

	public OrderDetail(String idProduct, Double quantity, Double unitPrice, int discount, Double total, Order order) {
		
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.total = total;
		this.order = order;
	}	


	public long getId() {
		return id;
	}

	
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", product id=" + idProduct + "]";
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
