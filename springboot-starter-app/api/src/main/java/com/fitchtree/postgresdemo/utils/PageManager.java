package com.fitchtree.postgresdemo.utils;

import org.springframework.stereotype.Component;

@Component
class PageManager {

    private boolean paginated;
    private int page_num;
    private int pages;    
    
    public boolean isPaginated() {
		return paginated;
    }
    
	public void setPaginated(boolean paginated) {
		this.paginated = paginated;
    }
    
	public int getPage_num() {
		return page_num;
    }
    
	public void setPage_num(int page_num) {
		this.page_num = page_num;
    }
    
	public int getPages() {
		return pages;
    }
    
	public void setPages(int pages) {
		this.pages = pages;
	}
}