package com.lookat.vo;

import java.io.Serializable;

public class AmountpaidVO implements Serializable {
	
	private int amountpaidId;
	private int payprice;
	private String payDate;
	private int memberId;
	private String discountContents;
	
	
	public AmountpaidVO() {
		super();
	}


	public AmountpaidVO(int amountpaidId, int payprice, String payDate, int memberId, String discountContents) {
		super();
		this.amountpaidId = amountpaidId;
		this.payprice = payprice;
		this.payDate = payDate;
		this.memberId = memberId;
		this.discountContents = discountContents;
	}


	public int getAmountpaidId() {
		return amountpaidId;
	}


	public void setAmountpaidId(int amountpaidId) {
		this.amountpaidId = amountpaidId;
	}


	public int getPayprice() {
		return payprice;
	}


	public void setPayprice(int payprice) {
		this.payprice = payprice;
	}


	public String getPayDate() {
		return payDate;
	}


	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public String getDiscountContents() {
		return discountContents;
	}


	public void setDiscountContents(String discountContents) {
		this.discountContents = discountContents;
	}


	@Override
	public String toString() {
		return "AmountpaidVO [amountpaidId=" + amountpaidId + ", payprice=" + payprice + ", payDate=" + payDate
				+ ", memberId=" + memberId + ", discountContents=" + discountContents + "]";
	}
	
	
	
}
