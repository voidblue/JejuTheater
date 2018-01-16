import Bringer.CGVBringer;
import Utils.Bringer;
import org.junit.Test;

import java.util.ArrayList;

public class BringerTest {


    @Test
    public void CGVtest()
    {
        Bringer bringer = Bringer.getInstance(new CGVBringer());
        ArrayList<ArrayList> cgvlists = bringer.bring();
        ArrayList schedules = cgvlists.get(0);
        ArrayList movies = cgvlists.get(1);

        // print
    }
}
