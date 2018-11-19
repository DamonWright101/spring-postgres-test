package com.fitchtree.postgresdemo.utils;

import java.util.List;

import com.fitchtree.postgresdemo.bean.Customer;

import org.springframework.stereotype.Component;

@Component
public class ApiWrapper {

    private String message;
    private int page = 1;
    private int pages;    
    private Object data;   
    
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

	public void setData(Object data) {
        if (data instanceof List<?>) {
            List<Object> temp = (List<Object>) data;
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
}