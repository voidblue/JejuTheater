package DataBase;

import java.sql.*;

abstract class DBBase {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";

    private Connection connection = null;

    DBBase() {
        final String ServerUrl = "jdbc:mysql://54.199.161.232:3306/jejutheater?characterEncoding=euckr";
        final String ServerID = "son";
        final String ServerPW = "kakao123";
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

    protected void execute(String updatequery, String insertquery){
        PreparedStatement pstmt = null;
        int result = 0;
        String updateError = null;
        String insertError = null;
        try {
            pstmt = connection.prepareStatement(updatequery);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            updateError = e.getMessage();
        }finally {
            try {
                pstmt = connection.prepareStatement(insertquery);
                result = pstmt.executeUpdate();
            } catch (SQLException e) {
                insertError = updateError = e.getMessage();
            }
        }

        System.out.println(result);
        if(result == 0){
            System.out.println(ANSI_RED + updateError + ANSI_RESET);
            System.out.println(ANSI_RED + insertError + ANSI_RESET);
        }
    }
}
