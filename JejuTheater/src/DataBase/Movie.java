package DataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Movie{
    private HashSet<String> key;
    private HashMap<String, ArrayList> arrays;
    private ArrayList<ScreenInfo> ScreenInfoList;
//    public final String movieId;
//    public final String movieName;
//    public final String movieNameENG;
//    public final String genre;
//    public final String ageLimit;
//    public final String openTime;
//    public final String story;
//    public final String rating;
//    public final String share;
//    public final String duration;
    //위에있는 거는 주석풀고 초기화해주시고 아래부터 짜면 됨
    public Movie(ArrayList<HashMap<String, String>> arrayList){
        HashMap<String, String> item = arrayList.get(0);

    }
}
