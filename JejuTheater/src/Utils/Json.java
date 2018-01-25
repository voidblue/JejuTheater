package Utils;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Json {
    JSONObject schedule;
    JSONObject externalObject;
    ArrayList<JSONObject> list;


    public Json(){
        schedule = new JSONObject();
        externalObject = new JSONObject();

        list = new ArrayList<>();
        try {
            externalObject = new JSONObject();
            externalObject.put("schedule", schedule);
            schedule.put("date", "date");
            JSONObject theater = new JSONObject();
            schedule.put("theater", theater);

            theater.put("brand", "brand");
            theater.put("theaterName", "theaterName");
            theater.put("address", "address");
            theater.put("phoneNumber", "phoneNumber");
            JSONArray movies = new JSONArray();
            theater.put("movies", movies);
            JSONObject movie = new JSONObject();
            movies.put(movies.length(), movie);

            movie.put("movieId", "movieId");
            movie.put("movieName", "movieName");
            movie.put("movieNameENG", "movieNameENG");
            movie.put("genre", "genre");
            movie.put("ageLimit", "age");
            movie.put("openDate", "date");
            movie.put("story", "story");
            movie.put("share", "share");
            movie.put("sales", "sales");
            JSONArray timeList = new JSONArray();
            movie.put("timeList", timeList);

            JSONObject showTime = new JSONObject();
            timeList.put(showTime);
            showTime.put("screenId", "screenId");
            showTime.put("room", "room");
            showTime.put("time", "time");
            showTime.put("leftSeat", "leftSeat");
            showTime.put("totalSeat", "totalSeat");
//            internalObject.put("Date", "today");
//            list.add(internalObject);
//
//
//
//            externalObject2 = new JSONObject(schedule);
//            externalObject2.put("Theater" , schedule);
//
//            getInternalObject = new JSONObject();
//            getInternalObject.put("Brand", "");
//            getInternalObject.put("Name", "");
//            getInternalObject.put("Address", "");
//            getInternalObject.put("Phone", "");
//            list.add(getInternalObject);
//
//
//            getGetInternalObject = new JSONObject();
//            getGetInternalObject.put("name", "matrix3");
//            list.add(getGetInternalObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (JSONObject e : list){
//            schedule.put(e);
        }

        System.out.println(externalObject.toString().replace("}", "}\n"));
    }

    public static void main(String args[]){
        Json json = new Json();
    }
}
