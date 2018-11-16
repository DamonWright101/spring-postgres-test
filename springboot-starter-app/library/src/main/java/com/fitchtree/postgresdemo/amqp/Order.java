package com.fitchtree.postgresdemo.amqp;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Order implements Serializable {

    private String orderNumber;
    private String productId;
    private double amount;
    private String message;

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMessage()
	{
		return this.message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

}