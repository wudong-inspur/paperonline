package com.sp.questionnaire.utils;

import java.io.Serializable;

public class PageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	final int defaultPageCount = 10;

	private int currentPage = 1;
	
    private int pageSize = 10;
    
    private String sortColumn;
    
    private String sortType = "acsc";
    
    public PageBean() {
    	
    }
    
    public PageBean(int currentPage, int pageSize, String sortColumn, String sortType) {
    	this.pageSize = pageSize;
    	this.currentPage= currentPage;
    	this.sortColumn = sortColumn;
    	this.sortType= sortType;
    }
    
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSortColumn() {
		return sortColumn;
	}
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
}
