package com.lookat.vo;

import java.io.Serializable;

public class SaleVO implements Serializable {
	
	private int theaterId;
	private int total_sale;
	
	
	public SaleVO() {
		super();
	}
	public SaleVO(int theaterId, int total_sale) {
		super();
		this.theaterId = theaterId;
		this.total_sale = total_sale;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public int getTotal_sale() {
		return total_sale;
	}
	public void setTotal_sale(int total_sale) {
		this.total_sale = total_sale;
	}
	
	@Override
	public String toString() {
		return "SaleVO [theaterId=" + theaterId + ", total_sale=" + total_sale + "]";
	}
	
	
	
}
