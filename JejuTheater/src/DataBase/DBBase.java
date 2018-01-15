package DataBase;

import java.sql.*;

abstract class DBBase {

    private Connection connection = null;

    DBBase() {
        final String ServerUrl = "jdbc:mysql://54.199.161.232:3306/[DBname]";
        final String ServerID = "ID";
        final String ServerPW = "password";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(ServerUrl, ServerID, ServerPW);
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


// Statement 사용시
// stmt = connection.createStatement();
// rs = stmt.excuteQuery(query);

    protected ResultSet executeQuery(String query){
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(query);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
