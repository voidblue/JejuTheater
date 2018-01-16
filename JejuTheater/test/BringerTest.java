import Bringer.CGVBringer;
import TheaterData.Movies;
import TheaterData.Schedules;
import Utils.Bringer;
import org.junit.Test;

import java.util.ArrayList;

public class BringerTest {


    @Test
    public void CGVtest()
    {
        Bringer bringer = Bringer.getInstance(new CGVBringer());
        ArrayList<ArrayList> cgvlists = bringer.bring();
        Schedules schedules = (Schedules) cgvlists.get(0);
        Movies movies = (Movies) cgvlists.get(1);

        // print
    }
}
