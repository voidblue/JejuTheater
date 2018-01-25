package Main;

import Bringer.CGVBringer;
import DataBase.DBSetter;
import Interface.Bring;
import TheaterData.Movies;
import TheaterData.Schedules;
import Utils.Bringer;
import Utils.Crawler;

import java.util.ArrayList;
import java.util.Arrays;

public class MainParser {
    public static void main(String args[]){
        Bringer bringer = Bringer.getInstance(new CGVBringer());
        DBSetter dbSetter = DBSetter.getInstance();
        for(ArrayList e : bringer.bring()){
            if (e.get(0) instanceof Movies) {
                dbSetter.updateMovieInfo(e);
            }
            else if (e.get(0) instanceof ArrayList){
                for (Object data : e)
                    dbSetter.updateScreenInfo((ArrayList)data);
            }
        }
    }
}
