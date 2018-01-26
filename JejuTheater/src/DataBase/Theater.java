package DataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Theater{
    private HashSet<String> movieIds;
    private HashMap<String, ArrayList> arrays;
    private ArrayList<Movie> movies;
    public final String theaterName;
    public final String brand;
    public final String address;
    public final String phoneNumber;
    public Theater(ArrayList<HashMap<String, String>> arrayList) {
        HashMap<String, String> item = arrayList.get(0);
        theaterName = item.get("theater");
        brand = item.get("brand");
        address = item.get("address");
        phoneNumber = item.get("phone");

        movieIds = new HashSet<>();
        arrays = new HashMap<>();
        movies = new ArrayList<>();

        for (HashMap<String, String> e : arrayList){
            String movieId = e.get("movieId");

            int before = movieIds.size();
            movieIds.add(movieId);
            int after = movieIds.size();

            if(before != after){
                arrays.put(movieId, new ArrayList());
            }
            arrays.get(movieId).add(e);
        }
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
