package TheaterData;

import java.util.ArrayList;

public class Schedules extends ArrayList {
    String theater;
    String screen_number;
    String month;
    String day;
    String day_of_week;
    String show_time;
    String movie_title;
    String seat_left;

    public Schedules(String theater, String screen_number, String month, String day, String day_of_week, String show_time, String movie_title, String seat_left) {
        this.theater = theater;
        this.screen_number = screen_number;
        this.month = month;
        this.day = day;
        this.day_of_week = day_of_week;
        this.show_time = show_time;
        this.movie_title = movie_title;
        this.seat_left = seat_left;
    }

    public String getTheater() {
        return theater;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public String getScreen_number() {
        return screen_number;
    }

    public String getShow_time() {
        return show_time;
    }

    public String getSeat_left() {
        return seat_left;
    }
}
