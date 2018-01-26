package DataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Movie{
    private ArrayList<ScreenInfo> ScreenInfoList;
    public final String movieId;
    public final String movieName;
    public final String movieNameENG;
    public final String genre;
    public final String ageLimit;
    public final String openTime;
    public final String story;
    public final String rating;
    public final String share;
    public final String duration;

    public Movie(ArrayList<HashMap<String, String>> arrayList){
        HashMap<String, String> item = arrayList.get(0);
        this.movieId = item.get("movieId");
        this.movieName = item.get("movieName");
        this.movieNameENG = item.get("movie");
        this.genre = item.get("genre");
        this.ageLimit = item.get("ageLimit");
        this.openTime = item.get("releaseDate");
        this.story = item.get("story");
        this.rating = item.get("rating");
        this.share = item.get("share");
        this.duration = item.get("durationTime");

        this.ScreenInfoList = new ArrayList<ScreenInfo>();

        for (HashMap<String, String> e : arrayList)
        {
            ScreenInfo screenInfo = new ScreenInfo();
            String screenID = e.get("screenId");
            String screen = e.get("screenNum");
            String time = e.get("startTime");
            String leftSeat = e.get("leftSeat");
            String totalSeat = e.get("totalSeat");

            ScreenInfoList.add(screenInfo);
        }
    }

    public ArrayList<ScreenInfo> getScreenInfoList() {
        return ScreenInfoList;
    }
}
