package com.javasampleapproach.springrest.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product { 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private long id;

	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;

	@Column(name = "nrooms")
	private int nRooms;
	
	@Column(name = "nbaths")
	private int nBaths;
	
	@Column(name = "nhours")
	private int nHours;
	
	@Column(name = "unit_price")
	private Double unitPrice;
	
	@Column(name = "discount")
	private int discount;
	
	@Column(name = "total")
	private Double total;

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getnRooms() {
		return nRooms;
	}

	public void setnRooms(int nRooms) {
		this.nRooms = nRooms;
	}

	public int getnBaths() {
		return nBaths;
	}

	public void setnBaths(int nBaths) {
		this.nBaths = nBaths;
	}

	public int getnHours() {
		return nHours;
	}

	public void setnHours(int nHours) {
		this.nHours = nHours;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
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

	public long getId() {
		return id;
	}

	public Product(){}
	
	public Product(String name, String code, int discount, int nBaths
			, int nRooms, int nHours, Double total, Double unitPrice) {
		this.name = name;
		this.code = code;
		this.discount = discount;
		this.nBaths = nBaths;
		this.nRooms = nRooms;
		this.nHours = nHours;
		this.total = total;
		this.unitPrice = unitPrice;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}
}
