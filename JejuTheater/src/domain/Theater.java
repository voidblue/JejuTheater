package domain;

import java.util.List;

/**
 * @author user
 * @since 2018. 01. 25.
 */
public class Theater {
	private String address;
	private String phoneNumber;
	private String theaterName;
	private String brand;
	private List<Movie> movieList;
	
	public Theater(String address, String phoneNumber, String theaterName, String brand,
		List<Movie> movieList) {
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.theaterName = theaterName;
		this.brand = brand;
		this.movieList = movieList;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getTheaterName() {
		return theaterName;
	}
	
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public List<Movie> getMovieList() {
		return movieList;
	}
	
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
}
