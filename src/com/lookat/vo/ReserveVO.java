package com.lookat.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ReserveVO implements Serializable {
	
	private int reserveNum;
	private int runtimeId;
	private String seatId;
	private String payDate;
	private int theaterId;
	private int memberId;
	
	public ReserveVO() {
		super();
	}

	public ReserveVO(int reserveNum, int runtimeId, String seatId, String payDate,
			int memberId, int theaterId) {
		super();
		this.reserveNum = reserveNum;
		this.runtimeId = runtimeId;
		this.seatId = seatId;
		this.payDate = payDate;
		this.memberId = memberId;
		this.theaterId = theaterId;
	}

	


	public int getReserveNum() {
		return reserveNum;
	}

	public void setReserveNum(int reserveNum) {
		this.reserveNum = reserveNum;
	}

	public int getRuntimeId() {
		return runtimeId;
	}

	public void setRuntimeId(int runtimeId) {
		this.runtimeId = runtimeId;
	}


	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
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
	
	

	public int getTheaterId() {
		return theaterId;
	}



	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}



	@Override
	public String toString() {
		return "Reserve [reserveNum=" + reserveNum + ", runtimeId=" + runtimeId
				+ ", seatId=" + seatId + ", payDate=" + payDate + ", memberId=" + memberId
				+ ", theaterId=" + theaterId + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payDate == null) ? 0 : payDate.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReserveVO other = (ReserveVO) obj;
		if (payDate == null) {
			if (other.payDate != null)
				return false;
		} else if (!payDate.equals(other.payDate))
			return false;
		return true;
	}




	



	
}
