package com.lookat.vo;

public class ReserveSeatVO {
	
	private int reserveSeatId;
	private int reserveNum;
	private int seatId;
	public ReserveSeatVO() {
		super();
	}
	public ReserveSeatVO(int reserveSeatId, int reserveNum, int seatId) {
		super();
		this.reserveSeatId = reserveSeatId;
		this.reserveNum = reserveNum;
		this.seatId = seatId;
	}
	public int getReserveSeatId() {
		return reserveSeatId;
	}
	public void setReserveSeatId(int reserveSeatId) {
		this.reserveSeatId = reserveSeatId;
	}
	public int getReserveNum() {
		return reserveNum;
	}
	public void setReserveNum(int reserveNum) {
		this.reserveNum = reserveNum;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	@Override
	public String toString() {
		return "ReserveSeatVO [reserveSeatId=" + reserveSeatId + ", reserveNum=" + reserveNum + ", seatId=" + seatId
				+ "]";
	}
	
	
	
}
