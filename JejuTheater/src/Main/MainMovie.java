package Main;

import Bringer.CGVBringer;
import DataBase.DBSetter;
import DataBase.Movie;
import TheaterData.Movies;
import Utils.Bringer;

import java.util.ArrayList;

public class MainMovie {

    public static void main(String[] args)
    {
        Bringer bringer = Bringer.getInstance(new CGVBringer());
        DBSetter dbSetter = DBSetter.getInstance();

        dbSetter.updateMovieInfo((ArrayList) bringer.getMovies());
    }
}
