package com.lookat.vo;

import java.io.Serializable;

public class MovieVO implements Serializable {
	
	private int movieId;
	private String movieName;
	private String movieType;
	private String movieDirector;
	private String movieStudio;
	private String movieActor;
	
	// 추가된 컬럼
	private String movieStory;
	private String movieImgPath;
	private double movieStar;
	
	public MovieVO() {
		super();
	}
	public MovieVO(int movieId, String movieName, String movieType, String movieDirector, String movieStudio,
			String movieActor, String movieStory, double movieStar, String movieImgPath) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieDirector = movieDirector;
		this.movieStudio = movieStudio;
		this.movieActor = movieActor;
		// 추가된 칼럼
		this.movieStory = movieStory;
		this.movieStar = movieStar;
		this.movieImgPath = movieImgPath; 
	}
	
	public String getMovieStory() {
		return movieStory;
	}
	public void setMovieStory(String movieStory) {
		this.movieStory = movieStory;
	}
	public double getMovieStar() {
		return movieStar;
	}
	public void setMovieStar(double movieStar) {
		this.movieStar = movieStar;
	}
	public String getMovieImgPath() {
		return movieImgPath;
	}
	public void setMovieImgPath(String movieImgPath) {
		this.movieImgPath = movieImgPath;
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
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public String getMovieStudio() {
		return movieStudio;
	}
	public void setMovieStudio(String movieStudio) {
		this.movieStudio = movieStudio;
	}
	public String getMovieActor() {
		return movieActor;
	}
	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}
	@Override
	public String toString() {
		return "MovieVO [movieId=" + movieId + ", movieName=" + movieName + ", movieType=" + movieType
				+ ", movieDirector=" + movieDirector + ", movieStudio=" + movieStudio + ", movieActor=" + movieActor
				+ "]";
	}
	
	
	
}
