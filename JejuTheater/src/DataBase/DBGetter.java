package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DBGetter extends DBBase{
    private static String QUERY = "SELECT * FROM brands";
    public ResultSet resultSet;

    public static DBGetter getInstance(){
        return new DBGetter();
    }

    private DBGetter(){
        resultSet = Select(QUERY);
    }

    public ArrayList<HashMap<String,String>> getData(){
        ArrayList<HashMap<String, String>> list = new ArrayList<>();



        return list;

    }
    /*
      Date:"today",
  Theater:{Brand:"",Name:"", Address:"", Phone:""},
  Movies:[
    {
      Brand:"",
      Name:"",
      Address:"",
      Phone:""
      Movue_ID:"",
      Movie_Name:"",
      ENG_Name:"",
      genre:"",
      Age:"",
      OpenTime:"",
      Story:"",
      Rating:"",
      Sales:"",
      Date_List:[
        ShowTime:{ScreenID:"", Screen:"", Time:"", Left_Seat:"", Total_Seat:""},
    */


    //
    //
    //
    //TODO 가져올 데이터들과 쿼리문 그리고 JSON을 사용할 객체에 반환할 형식
    //
    //
    //



    public static void main(String args[]){
        DBGetter dbGetter = DBGetter.getInstance();
        try {
            dbGetter.resultSet.absolute(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

