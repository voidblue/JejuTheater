package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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

