import Bringer.CGVBringer;
import TheaterData.Movies;
import TheaterData.Schedules;
import Utils.Bringer;
import Utils.Scheduler;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BringerTest {


    @Test
    public void CGVtest()
    {
        Bringer bringer = Bringer.getInstance(new CGVBringer());
        ArrayList<ArrayList> cgvlists = bringer.bring();
        
        ArrayList<Movies> movies = cgvlists.get(0);
        ArrayList<ArrayList> alldaySchedules = cgvlists.get(1);

        Movies movie = movies.get(1);
        ArrayList<Schedules> todaySchedule = alldaySchedules.get(0);
        Schedules firstShow = todaySchedule.get(0);

        System.out.println(movie.getTitle() + movie.getTitle_en());
        System.out.println(firstShow.getTheater() + firstShow.getDay_of_week() + firstShow.getMovie_title() + firstShow.getShow_time());
    }
}
