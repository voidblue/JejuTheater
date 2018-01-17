package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DBGetter extends DBBase{
    private static String QUERY = "SELECT * FROM brands";
    public ResultSet resultSet;

    public static DBGetter getInstance(){
        return new DBGetter();
    }

    private DBGetter(){
        resultSet = Select(QUERY);
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
        try {
            dbGetter.resultSet.absolute(3);
            System.out.println(dbGetter.resultSet.getString("moviename"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
