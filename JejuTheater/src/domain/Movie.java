package domain;

/**
 * @author user
 * @since 2018. 01. 25.
 */
public class Movie {
	private String title;
	private String title_en;
	private String genre;
	private String storyline;
	private String release_date;
	private String age_limit;
	private String score;
	private String ticket_sales;
	private String running_time;
	
	
	public Movie(String title, String title_en, String genre, String storyline, String release_date,
		String age_limit, String score, String ticket_sales, String running_time) {
		this.title = title;
		this.title_en = title_en;
		this.genre = genre;
		this.storyline = storyline;
		this.release_date = release_date;
		this.age_limit = age_limit;
		this.score = score;
		this.ticket_sales = ticket_sales;
		this.running_time = running_time;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle_en() {
		return title_en;
	}
	
	public void setTitle_en(String title_en) {
		this.title_en = title_en;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getStoryline() {
		return storyline;
	}
	
	public void setStoryline(String storyline) {
		this.storyline = storyline;
	}
	
	public String getRelease_date() {
		return release_date;
	}
	
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	
	public String getAge_limit() {
		return age_limit;
	}
	
	public void setAge_limit(String age_limit) {
		this.age_limit = age_limit;
	}
	
	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public String getTicket_sales() {
		return ticket_sales;
	}
	
	public void setTicket_sales(String ticket_sales) {
		this.ticket_sales = ticket_sales;
	}
	
	public String getRunning_time() {
		return running_time;
	}
	
	public void setRunning_time(String running_time) {
		this.running_time = running_time;
	}
}
