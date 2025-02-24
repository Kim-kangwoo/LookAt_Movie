package com.lookat.vo;

public class CinemaVO {
	
	private int cinemaId;
	private int movieId;
	private int theaterId;
	
	public CinemaVO() {
		super();
	}

	public CinemaVO(int movieId, int theaterId, int cinemaId) {
		super();
		this.movieId = movieId;
		this.theaterId = theaterId;
		this.cinemaId = cinemaId;
	}

	
	
	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
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

	

	@Override
	public String toString() {
		return "CinemaVO [movieId=" + movieId + ", theaterId=" + theaterId + "]";
	}
	
	
	
}
