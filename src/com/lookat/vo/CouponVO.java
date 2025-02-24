package com.lookat.vo;

import java.io.Serializable;

public class CouponVO implements Serializable {
	
	private int couponId;
	private String couponType;
	
	public CouponVO() {
		super();
	}

	public CouponVO(int couponId, String couponType) {
		super();
		this.couponId = couponId;
		this.couponType = couponType;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	@Override
	public String toString() {
		return "CouponVO [couponId=" + couponId + ", couponType=" + couponType + "]";
	}
	
	
	
}
