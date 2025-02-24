package com.lookat.dto;

public class TheaterDTO {
	
	
	private String theaterName;
	private int theaterSale;
	
	//mapper getTheaterMovieSaleList 이거 하려고 만든 애들
	private int theaterId;
	private int movieId;
	private String movieName;
	private int movieSale;
	
	public TheaterDTO() {
		super();
	}
	public TheaterDTO(String theaterName, int theaterSale) {
		super();
		this.theaterName = theaterName;
		this.theaterSale = theaterSale;
	}
	
	public TheaterDTO(String theaterName, String movieName, int movieSale) {
		super();
		this.theaterName = theaterName;
		this.movieName = movieName;
		this.movieSale = movieSale;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public TheaterDTO(String theaterName, int movieId, String movieName, int movieSale) {
		super();
		this.theaterName = theaterName;
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieSale = movieSale;
	}
	public TheaterDTO(String theaterName, int theaterSale, int theaterId) {
		super();
		this.theaterName = theaterName;
		this.theaterSale = theaterSale;
		this.theaterId = theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public int getTheaterSale() {
		return theaterSale;
	}
	public void setTheaterSale(int theaterSale) {
		this.theaterSale = theaterSale;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getMovieSale() {
		return movieSale;
	}
	public void setMovieSale(int movieSale) {
		this.movieSale = movieSale;
	}
	
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	
	
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	@Override
	public String toString() {
		return "TheaterDTO [theaterName=" + theaterName + ", theaterSale=" + theaterSale + ", theaterId=" + theaterId
				+ ", movieName=" + movieName + ", movieSale=" + movieSale + "]";
	}
	
	
	
	
	

}
