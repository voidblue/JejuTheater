package Utils;

import Bringer.CGVBringer;
import Interface.Bring;
import TheaterData.Movies;
import org.junit.Test;

import java.util.ArrayList;

public class Bringer {
    private Bring bringer;
    public static Bringer getInstance(Bring bringer) { return new Bringer(bringer); }
    private Bringer(Bring bringer) { this.bringer = bringer; };

    public ArrayList<ArrayList> getAllSchedules() { return bringer.getAllSchedules(); }
    public ArrayList<ArrayList> getSchedules(String theater) { return bringer.getSchedules(theater); }
    public ArrayList<Movies> getMovies() { return bringer.getMovies(); }

}
