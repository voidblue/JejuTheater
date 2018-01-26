package DataBase;

import Utils.Xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DataForm {
    private HashSet<String> dates;
    private HashMap<String, ArrayList> arrays;
    private ArrayList<Schedule> schedules;

    public DataForm(ArrayList<HashMap<String, String>> arrayList){
        schedules = new ArrayList<>();
        dates = new HashSet<>();
        arrays = new HashMap<>();
        for (HashMap<String, String> e : arrayList){
            String date = e.get("startTime").split(" ")[0];

            int before = dates.size();
            dates.add(date);
            int after = dates.size();
            if (before != after){
                arrays.put(date, new ArrayList());
            }
            arrays.get(date).add(e);

        }

        //스케줄이 가진 극장리스트에 name이란 키로 구분된 극장 넣기
        //반환은 ArrayList로 해서 name 몰라도 꺼네질 수 있도록 할것 그래서 리스트에 다시넣음
        for (String name : dates){
            schedules.add(new Schedule(arrays.get(name)));
        }
    }

    public String toXmlFormatString(){
        Xml xml = new Xml(schedules);

        return xml.toXmlFormatString();
    }
}
