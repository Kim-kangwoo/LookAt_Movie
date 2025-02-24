package com.lookat.vo;

import java.io.Serializable;

public class RuntimeVO implements Serializable {
	
	private int runtimeId;
	private int movieId;
	private int theaterId;
	private String runDate;
	private String startTime;
	private String endTime;
	private int leftSeatCount;
	
	public RuntimeVO() {
		super();
	}

	public RuntimeVO(int runtimeId, int movieId, int theaterId, String runDate, String startTime, String endTime, int leftSeatCount) {
		super();
		this.runtimeId = runtimeId;
		this.movieId = movieId;
		this.theaterId = theaterId;
		this.runDate = runDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.leftSeatCount = leftSeatCount;
	}

	public int getRuntimeId() {
		return runtimeId;
	}

	public void setRuntimeId(int runtimeId) {
		this.runtimeId = runtimeId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getRunDate() {
		return runDate;
	}

	public void setRunDate(String runDate) {
		this.runDate = runDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	
	public int getLeftSeatCount() {
		return leftSeatCount;
	}

	public void setLeftSeatCount(int leftSeatCount) {
		this.leftSeatCount = leftSeatCount;
	}

	@Override
	public String toString() {
		return "RuntimeVO [runtimeId=" + runtimeId + ", movieId=" + movieId + ", theaterId=" + theaterId + ", runDate="
				+ runDate + ", startTime=" + startTime + ", endTime=" + endTime + ", leftSeatCount=" + leftSeatCount + "]";
	}

	
	
}
