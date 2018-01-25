package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class DBGetter extends DBBase{
    private final String BASE_QUERY = "SELECT * FROM movieInfo m\n" +
            "  INNER JOIN screenInfo I\n" +
            "    ON m.movieId = I.movieId\n" +
            "  INNER JOIN screens s\n" +
            "    ON I.screenId = s.screenId\n" +
            "  INNER JOIN theaters t\n" +
            "    ON s.theater = t.theater\n" +
            "  INNER JOIN brands b\n" +
            "    ON I.brand = b.brand";
    private ResultSet resultSet;
//    page
//            pagesize
//    date
//            theater   //영화관 건물별로
//    title
//            servicekey //제주 데이터 허브 쪽에서 어떻게 쓰나 보는걸로
    public static DBGetter getInstance(){
        return new DBGetter();
    }

    private DBGetter(){
    }

    public ArrayList<HashMap<String,String>> getData(int page, int pagesize, int fromToday,String date, String title){
        String where = " WHERE";
        boolean noWhere = true;
        if(date != null) {
            where += " date(starttime) = " + date;
            where += ",";
            noWhere = false;
        }
        if(title != null) {
            where += " Mname = " + title;
            where += ",";
            noWhere = false;
        }
        if(fromToday == 1){
            where += " DATE (startTime) >= DATE (curdate()),";
            where = where.substring(0, where.length() - 1);
            where += " ORDER BY startTime ASC";
        }else {
            if (noWhere) {
                where = "";
            }
            where += " ORDER BY startTime DESC";
        }
        //쉼표제거


        System.out.println(BASE_QUERY + where);
        resultSet = select(BASE_QUERY + where);
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        try {
            int i = page * pagesize;
            resultSet.absolute(i);
            while(true) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("brand",resultSet.getString("brand"));
                hashMap.put("movieId",resultSet.getString("movieId"));
                hashMap.put("movieName",resultSet.getString("Mname"));
                hashMap.put("movieNameENG",resultSet.getString("MnameEng"));
                hashMap.put("genre",resultSet.getString("genre"));
                hashMap.put("story",resultSet.getString("story"));
                hashMap.put("releaseDate",resultSet.getString("release"));
                hashMap.put("ageLimit",resultSet.getString("age"));
                hashMap.put("rating",resultSet.getString("rating"));
                hashMap.put("share",resultSet.getString("sales"));
                hashMap.put("screenId",resultSet.getString("screenId"));
                hashMap.put("startTime",resultSet.getString("startTime"));
                hashMap.put("screenNum",resultSet.getString("screenNum"));
                hashMap.put("totalSeat",resultSet.getString("totalSeat"));
                hashMap.put("theater",resultSet.getString("theater"));
                hashMap.put("address", resultSet.getString("address"));
                hashMap.put("phone", resultSet.getString("phone"));
                hashMap.put("durationTime", resultSet.getString("runTime"));
                list.add(hashMap);
                if (resultSet.next() && i < page*pagesize + pagesize) {
                    i++;
                    resultSet.absolute(i);
                }
                else{
                    break;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    //
    //
    //
    //TODO 가져올 데이터들과 쿼리문 그리고 JSON을 사용할 객체에 반환할 형식
    //
    //
    //



    public static void main(String args[]){
        DBGetter dbGetter = DBGetter.getInstance();
        ArrayList xxx = dbGetter.getData(1,100, 0, null, null);
        System.out.println(xxx.toString().replace("}", "}\n"));
    }
}


//TODO 여러 스케줄을 담은 클래스 또 만들기
class Schedule{
    public final String date;                    //스케줄이 가지게 될 자료, 자료형 클래스여서 쉽게 가져오도록
                                                // 퍼블릭으로 만듦면서 수정불가능하게
    private HashSet<String> theaterNames;   //HashSet은 같은데이터가 들어가면 무시해버림
    private HashMap<String, ArrayList> arrays;
    private ArrayList<Theater> theaters;
    public Schedule(ArrayList<HashMap<String, String>> arrayList){
        HashMap<String, String> item = arrayList.get(0);
        date = item.get("startTime").split(" ")[0];

        theaters = new ArrayList<>();
        theaterNames = new HashSet<>();
        arrays = new HashMap<>();
        for (HashMap<String, String> e : arrayList){
            String theaterName = e.get("theater");


            //새로운 이름을 가진 영화관이 발견될 경우
            //극장 이름에 따라 새로 리스트를 만들어 추가
            int before = theaterNames.size();
            theaterNames.add(theaterName);
            int after = theaterNames.size();
            if (before != after){
                arrays.put(theaterName, new ArrayList());
            }
            arrays.get(theaterName).add(e);

        }

        //스케줄이 가진 극장리스트에 name이란 키로 구분된 극장 넣기
        //반환은 ArrayList로 해서 name 몰라도 꺼네질 수 있도록 할것 그래서 리스트에 다시넣음
        for (String name : theaterNames){
            theaters.add(new Theater(arrays.get(name)));
        }
    }
}

class Theater{
    private HashSet<String> movieIds;
    private HashMap<String, ArrayList> arrays;
    private ArrayList<Movie> movies;
    public final String theaterName;
    public final String brand;
    public final String address;
    public final String phoneNumber;
    public Theater(ArrayList<HashMap<String, String>> arrayList) {
        HashMap<String, String> item = arrayList.get(0);
        theaterName = item.get("theater");
        brand = item.get("brand");
        address = item.get("address");
        phoneNumber = item.get("phone");

        movieIds = new HashSet<>();
        arrays = new HashMap<>();
        movies = new ArrayList<>();

        for (HashMap<String, String> e : arrayList){
            String movieId = e.get("movieId");

            int before = movieIds.size();
            movieIds.add(movieId);
            int after = movieIds.size();

            if(before != after){
                arrays.put(movieId, new ArrayList());
            }
            arrays.get(movieId).add(e);
        }
    }

    public ArrayList<Movie> getMovies() {

        return movies;
    }
}

class Movie{
    private HashSet<String> key;
    private  HashMap<String, ArrayList> arrays;
    private ArrayList<ScreenInfo> ScreenInfoList;
//    public final String movieId;
//    public final String movieName;
//    public final String movieNameENG;
//    public final String genre;
//    public final String ageLimit;
//    public final String openTime;
//    public final String story;
//    public final String rating;
//    public final String share;
//    public final String duration;
    //위에있는 거는 주석풀고 초기화해주시고 아래부터 짜면 됨
    public Movie(ArrayList<HashMap<String, String>> arrayList){
        HashMap<String, String> item = arrayList.get(0);

    }
}

class ScreenInfo{

}
