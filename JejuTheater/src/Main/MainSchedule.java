package Main;

import Bringer.CGVBringer;
import DataBase.DBSetter;
import Utils.Bringer;

import java.util.ArrayList;

public class MainSchedule {

    public static void main(String[] args)
    {
        Bringer bringer = Bringer.getInstance(new CGVBringer());
        DBSetter dbSetter = DBSetter.getInstance();

        for (ArrayList e : bringer.getAllSchedules())
        {
            for (Object data : e)
                dbSetter.updateScreenInfo((ArrayList)data);
        }
    }
}
