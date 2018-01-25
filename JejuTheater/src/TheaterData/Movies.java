package TheaterData;

import java.util.ArrayList;

public class Movies extends ArrayList<String> {
    String title;
    String title_en;
    String genre;
    String storyline;
    String release_date;
    String age_limit;
    String score;
    String ticket_sales;
    String running_time;

    public Movies(String id, String brand, String title, String title_en, String genre, String storyline, String release_date, String age_limit, String score, String ticket_sales, String running_time) {
        this.title = title;
        this.title_en = title_en;
        this.genre = genre;
        this.storyline = storyline;
        this.release_date = release_date;
        this.age_limit = age_limit;
        this.score = score;
        this.ticket_sales = ticket_sales;
        this.running_time = running_time;

        add(id);
        add(brand);
        add(title);
        add(title_en);
        add(genre);
        add(storyline);
        add(release_date);
        add(age_limit);
        add(score);
        add(ticket_sales);
        add(running_time);
    }
}
