package DataBase;

import java.sql.*;

abstract class DBBase {

    private Connection connection = null;

    DBBase() {
        final String ServerUrl = "jdbc:mysql://54.199.161.232:3306/비밀";
        final String ServerID = "비밀";
        final String ServerPW = "비밀";
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

    protected ResultSet Select(String query){
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(query);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void execute(String query){
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            pstmt = connection.prepareStatement(query);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }
}
