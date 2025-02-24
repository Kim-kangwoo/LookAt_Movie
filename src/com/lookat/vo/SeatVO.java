package com.lookat.vo;

import java.io.Serializable;

public class SeatVO implements Serializable{
	
	private String seatId;
	private int seatPrice;
	private String seatType;
	
	public SeatVO(String seatId, int seatPrice, String seatType) {
		super();
		this.seatId = seatId;
		this.seatPrice = seatPrice;
		this.seatType = seatType;
	}
	
	public SeatVO() {
		super();
	}
	
	
	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public int getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(int seatPrice) {
		this.seatPrice = seatPrice;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	@Override
	public String toString() {
		return "SeatVO [seatId=" + seatId + ", seatPrice=" + seatPrice + ", seatType=" + seatType + "]";
	}
	
	
	
	
	
	
	
}
