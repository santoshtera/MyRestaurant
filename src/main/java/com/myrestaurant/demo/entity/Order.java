package com.myrestaurant.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_orders", uniqueConstraints = { @UniqueConstraint(columnNames = "order_number") })
public class Order {

	@Id
    @Column(name = "order_number", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int orderNum;
 
    @Column(name = "amount", nullable = false)
    private double amount;
 
    @Column(name = "customer_name", length = 255, nullable = false)
    private String customerName;
 
    @Column(name = "customer_address", length = 255, nullable = false)
    private String customerAddress;
 
    @Column(name = "customer_phone", length = 128, nullable = false)
    private String customerPhone;

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
 
	
	
}
