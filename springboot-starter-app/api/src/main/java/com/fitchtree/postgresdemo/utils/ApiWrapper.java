package com.fitchtree.postgresdemo.utils;

import java.util.ArrayList;
import java.util.List;

import com.fitchtree.postgresdemo.bean.Customer;

import org.springframework.stereotype.Component;

@Component
public class ApiWrapper {

    private String message;
    private int page = 1;
    private int pages;    
    private List<Object> data;   
    
    // getters and setters
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(List<?> data) {
        this.data = (List<Object>) data;
    }
    
	public int getPage() {
		return page;
    }
    
	public void setPage(int page) {
        this.page = page;
    }
    
	public int getPages() {
		return pages;
    }
    
	public void setPages(int pages) {
		this.pages = pages;
    }
    
    public void filterData(String field, String regex) {
        List<Object> temp = new ArrayList<Object>();
        List<Customer> customers = (List<Customer>)(Object)data;
        for (Customer customer: customers) {
            if (customer.regexMatch(field, regex)) temp.add(customer);
        }
        setData(temp);
        pageinateData();
    }

    private void pageinateData() {
        List<Object> temp = data;
        setPages((int) Math.ceil((double) temp.size()/20));
        if (getPage() < getPages() && getPage() > 0) {
            this.data = temp.subList((getPage()-1)*20, (getPage()-1)*20+19);
        } else if (getPage() == getPages()) {
            this.data = temp.subList((getPage()-1)*20,temp.size());
        } else {
            this.data = null;
        }
    }
}