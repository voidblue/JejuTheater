package DataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DBSetter extends DBBase {
    final String INSERT_SCREEN_INFO = "INSERT `screenInfo` VALUES ";
    final String INSERT_MOVIE_INFO = "INSERT `movieInfo` VALUES ";


    public static DBSetter getInstance(){
        return new DBSetter();
    }

    private DBSetter(){

    }

    public void updateScreenInfo(ArrayList<ArrayList<String>> data){
        for (ArrayList list : data){
            String insertValues = "(";
            String updateValues = "UPDATE `screenInfo` SET leftSeat = '" + (String)list.get(2) + "'" +
                    "WHERE screenId =" + "'"+ (String)list.get(0) +"'" +
                    " and startTime = " + "'" + (String)list.get(1)+ "'";

            for (Object e : list){
                insertValues += "'" + (String)e+"', ";
            }
            insertValues = insertValues.substring(0, insertValues.length()-2); // 마지막 콤마(,) 제거
            insertValues += ")";
            System.out.println(insertValues);

            execute( updateValues, INSERT_SCREEN_INFO + insertValues);
        }
    }

    public void updateMovieInfo(ArrayList<ArrayList<String>> data){
        for (ArrayList list : data){
            String insertValues = "(";
            String updateValues = "UPDATE `movieInfo` SET `release` = '" + (String)list.get(6)+ "', rating = '"
                    + list.get(8) + "', sales = '" + list.get(9) + "' WHERE movieId = '" + list.get(0) +
                    "' and brand = '" + list.get(1) +"'";
            System.out.println(updateValues);
            for (Object e : list){
                insertValues += "'" + (String)e+"', ";
            }
            insertValues = insertValues.substring(0, insertValues.length()-2); // 마지막 콤마(,) 제거
            insertValues += ")";
            System.out.println(insertValues);

            execute(updateValues, INSERT_MOVIE_INFO + insertValues);
        }
    }




    public void run(){
    }

    public static void main(String args[]){
        DBSetter dbSetter = DBSetter.getInstance();
//        ArrayList<ArrayList<String>> xxx = new ArrayList<>();
//        ArrayList<String> yyy = new ArrayList<>();
//        yyy.add("CGV제주1");
//        yyy.add("2018-01-17 16:00:00");
//        yyy.add("55");
//        yyy.add("testid");
//        yyy.add("CGV");
//        xxx.add(yyy);

        ArrayList<ArrayList<String>> xxx2 = new ArrayList<>();
        ArrayList<String> yyy2 = new ArrayList<>();
        yyy2.add("testid34");
        yyy2.add("CGV");
        yyy2.add("테스트");
        yyy2.add("test");
        yyy2.add("테스트");
        yyy2.add("테스트 스토리");
        yyy2.add("2018-01-20");
        yyy2.add("12세 제한");
        yyy2.add("4.5");
        yyy2.add("10000");
        xxx2.add(yyy2);

        dbSetter.updateMovieInfo(xxx2);



    }
}
