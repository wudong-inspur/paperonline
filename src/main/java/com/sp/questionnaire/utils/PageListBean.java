package com.sp.questionnaire.utils;


import java.io.Serializable;
import java.util.List;

public class PageListBean<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int total;
	private int pageSize;
	private int currentPage = -1;
	private int totalPages;
	private List<T> data;

    public PageListBean(int total, int pageSize, int currentPage, List<T> data) {
	   this.total = total;
	   this.pageSize = pageSize;
	   if(this.pageSize > 0) {
		   this.currentPage = currentPage;
		   this.totalPages = (int) Math.ceil(total / (double)pageSize);
	   } else {
		   this.currentPage = 1;
		   this.totalPages = 1;
	   }
	   this.data = data;
    }
    
    public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public PageListBean(int total, PageBean page, List<T> data) {
 	   this.total = total;
 	   this.pageSize = page.getPageSize();
 	   if(this.pageSize > 0) {
 		   this.currentPage = page.getCurrentPage();
 		   this.totalPages = (int) Math.ceil(total / (double)pageSize);
 	   } else {
 		   this.currentPage = 1;
		   this.totalPages = 1;
 	   }
 	   this.data = data;
     }

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}