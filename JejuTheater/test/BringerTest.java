import Bringer.CGVBringer;
import Interface.Bring;
import TheaterData.Movies;
import TheaterData.Schedules;
import Utils.Bringer;
import Utils.Scheduler;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BringerTest {


    @Test
    public void CGVtest()
    {
        Bringer bringer = Bringer.getInstance(new CGVBringer());

//        ArrayList<Movies> movies = bringer.getMovies();
        ArrayList<ArrayList> JejuSchedules = bringer.getAllSchedules().get(0);
        ArrayList<ArrayList> result = bringer.getSchedules("0121");
        Assert.assertTrue(result.equals(JejuSchedules));

//        Movies movie = movies.get(1);
//        ArrayList<ArrayList> JejuSchedule = alldaySchedules.get(0);
//        ArrayList<Schedules> todaySchedule = JejuSchedule.get(0);
//        Schedules firstShow = todaySchedule.get(0);
//
//        for(int i = 0; i < movie.size(); i++) System.out.println(movie.get(i));
//        for(int i = 0; i < firstShow.size(); i++) System.out.println(firstShow.get(i));
    }
}
