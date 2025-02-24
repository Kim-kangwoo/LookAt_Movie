package com.lookat.vo;

import java.io.Serializable;

public class TheaterVO implements Serializable{
	
	private int theaterId;
	private String theaterRegion;
	private String theaterName;
	
	public TheaterVO() {
		super();
	}
	
	public TheaterVO(int theaterId, String theaterRegion, String theaterName) {
		super();
		this.theaterId = theaterId;
		this.theaterRegion = theaterRegion;
		this.theaterName = theaterName;
	}
	
	
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	
	public String getTheaterRegion() {
		return theaterRegion;
	}
	public void setTheaterRegion(String theaterRegion) {
		this.theaterRegion = theaterRegion;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	@Override
	public String toString() {
		return "TheaterVO [theaterId=" + theaterId + ", theaterRegion=" + theaterRegion
				+ ", theaterName=" + theaterName + "]";
	}
	
	
	
}
