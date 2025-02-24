package com.lookat.dto;

public class PreferDTO {
	
	private String memberSex;
	private int movieId;
	private String movieName;
	private int totSale;
	private double percentage;
	public PreferDTO() {
		super();
	}
	public PreferDTO(String memberSex, int movieId, String movieName, int totSale, double percentage) {
		super();
		this.memberSex = memberSex;
		this.movieId = movieId;
		this.movieName = movieName;
		this.totSale = totSale;
		this.percentage = percentage;
	}
	public String getMemberSex() {
		return memberSex;
	}
	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getTotSale() {
		return totSale;
	}
	public void setTotSale(int totSale) {
		this.totSale = totSale;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "PreferDTO [memberSex=" + memberSex + ", movieId=" + movieId + ", movieName=" + movieName + ", totSale="
				+ totSale + ", percentage=" + percentage + "]";
	}
	
	
	

}
