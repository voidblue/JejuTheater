package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBGetter extends DBBase{
    private static String QUERY = "SELECT * FROM tablename";
    private ResultSet resultSet;

    public static DBGetter getInstance(){
        return new DBGetter();
    }

    private DBGetter(){
        resultSet = executeQuery(QUERY);
    }

    //
    //
    //
    //TODO 가져올 데이터들과 쿼리문 그리고 JSON을 사용할 객체에 반환할 형식
    //
    //
    //





    //TODO 지워야할 함수
    public void TEST(){
        try {
            resultSet.absolute(2);
            System.out.println(resultSet.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
