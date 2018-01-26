package Interface;

import TheaterData.Movies;
import java.util.ArrayList;

public interface Bring {
    ArrayList<ArrayList> getAllSchedules();
    ArrayList<ArrayList> getSchedules(String theater);
    ArrayList<Movies> getMovies();
}
