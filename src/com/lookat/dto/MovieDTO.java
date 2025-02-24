package com.lookat.dto;

public class MovieDTO {
	
	private int movieId;
	private String movieName; 
	private String movieType;
	private String movieDirector;
	private String movieStudio;
	private String movieActor; 
	private String movieStory;
	private String movieImgPath;
	private double movieStar;
	
	//alias사용(영화별 예매 건수)
	private int reserveCount;
	
	
	
	public MovieDTO() {
		super();
	}






	public MovieDTO(String movieName, String movieType, String movieDirector, String movieStudio, String movieActor,
			String movieStory) {
		super();
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieDirector = movieDirector;
		this.movieStudio = movieStudio;
		this.movieActor = movieActor;
		this.movieStory = movieStory;
	}
	
	
	
	
	

	public MovieDTO(int movieId, String movieName, String movieType, String movieDirector, String movieStudio,
			String movieActor, String movieStory) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieDirector = movieDirector;
		this.movieStudio = movieStudio;
		this.movieActor = movieActor;
		this.movieStory = movieStory;
	}

	public MovieDTO(String movieName, String movieType, String movieDirector, String movieStudio,
			String movieActor, String movieStory, String movieImgPath, double movieStar) {
		super();
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieDirector = movieDirector;
		this.movieStudio = movieStudio;
		this.movieActor = movieActor;
		this.movieStory = movieStory;
		this.movieImgPath = movieImgPath;
		this.movieStar = movieStar;
	}

	public MovieDTO(int movieId, String movieName, String movieType, String movieDirector, String movieStudio,
			String movieActor, String movieStory, String movieImgPath, double movieStar) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieDirector = movieDirector;
		this.movieStudio = movieStudio;
		this.movieActor = movieActor;
		this.movieStory = movieStory;
		this.movieImgPath = movieImgPath;
		this.movieStar = movieStar;
	}
	
	
	
	

	public MovieDTO(int movieId, String movieName, String movieType, String movieDirector, String movieStudio,
			String movieActor, String movieStory, String movieImgPath, double movieStar, int reserveCount) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieDirector = movieDirector;
		this.movieStudio = movieStudio;
		this.movieActor = movieActor;
		this.movieStory = movieStory;
		this.movieImgPath = movieImgPath;
		this.movieStar = movieStar;
		this.reserveCount = reserveCount;
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

	public String getMovieStory() {
		return movieStory;
	}

	public void setMovieStory(String movieStory) {
		this.movieStory = movieStory;
	}

	public String getMovieImgPath() {
		return movieImgPath;
	}

	public void setMovieImgPath(String movieImgPath) {
		this.movieImgPath = movieImgPath;
	}

	public double getMovieStar() {
		return movieStar;
	}

	public void setMovieStar(double movieStar) {
		this.movieStar = movieStar;
	}

	public int getReserveCount() {
		return reserveCount;
	}

	public void setReserveCount(int reserveCount) {
		this.reserveCount = reserveCount;
	}






	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", movieName=" + movieName + ", movieType=" + movieType
				+ ", movieDirector=" + movieDirector + ", movieStudio=" + movieStudio + ", movieActor=" + movieActor
				+ ", movieStory=" + movieStory + ", movieImgPath=" + movieImgPath + ", movieStar=" + movieStar
				+ ", reserveCount=" + reserveCount + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
