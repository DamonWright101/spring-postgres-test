package com.fitchtree.postgresdemo.utils;

import org.springframework.stereotype.Component;

@Component
public class ApiWrapper {

    private String message;
    private Object data;   
    
    
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}