package com.cxg.utils;

import java.util.List;

/**
 * 分页工具类
	 * @author xuweidong
	 * @Title: PageData
	 * @Description:
	 * @date 2017年2月27日
 */
public class PageData<T> {
	/**
	 * 结果集
	 */
	private List<T> result = null;
	/**
	 * 总行数
	 */
	private long total; 
	/**
	 * 当前页,即第几页
	 */
	private int page; 
	/**
	 * 每页大小,即每页的行数
	 */
	private int rows ; 
	/**
	 * 总页数
	 */
	private long pageCount = 0;
	
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		if (rows != 0) {
			pageCount = total / rows;
			if (total % rows != 0) {
				pageCount++;
			}
		}
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
}
