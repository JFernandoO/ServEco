package com.javasampleapproach.springrest.mysql.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order { 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private long id;

	@Column(name = "address1")
	private String address1;
	
	@Column(name = "apto_unit")
	private String aptounit;
	
	@Column(name = "suburb")
	private String suburb;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	
	@Column(name = "order_date")
	private String dateOrder;
	
	@Column(name = "order_time")
	private String timeOrder;
	
	@Column(name = "order_create")
	private String createOrder;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number1")
	private String phoneNumber1;
	
	@Column(name = "phone_number2")
	private String phoneNumber2;
	
	@Column(name = "observations")
	private String observations;
	
		
	 //@OneToMany(mappedBy="associatedOrder", cascade=CascadeType.PERSIST)
	 @OneToMany(mappedBy = "order",cascade = {CascadeType.ALL}, orphanRemoval = true)
	    private Set<OrderDetail> orderDetails;

	 
	public String getDateOrder() {
		return dateOrder;
	}
	
	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

	public String getTimeOrder() {
		return timeOrder;
	}

	public void setTimeOrder(String timeOrder) {
		this.timeOrder = timeOrder;
	}




	public String getCreateOrder() {
		return createOrder;
	}




	public void setCreateOrder(String createOrder) {
		this.createOrder = createOrder;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getAddress1() {
		return address1;
	}




	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
		
	public String getAptounit() {
		return aptounit;
	}

	public void setAptounit(String aptounit) {
		this.aptounit = aptounit;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Order() {
	}

	public Order(String address1, String aptounit, String suburb, String city, 
			String state, String zipCode,
			String createOrder, String dateOrder, String timeOrder,
			String observations, String phoneNumber1,  String phoneNumber2,
			String email, String userId
			 ) {
		
		this.address1 = address1;
		this.aptounit = aptounit;
		this.suburb = suburb;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.createOrder = createOrder;
		this.dateOrder = dateOrder;
		this.timeOrder = timeOrder;
		this.observations = observations;
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.email = email;
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	
	@Override
	public String toString() {
		return "Order [id=" + id + ", state=" + state + "]";
	}
}
