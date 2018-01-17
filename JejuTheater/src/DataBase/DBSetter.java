package DataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DBSetter extends DBBase {
    final String INSERT_SCREEN_INFO = "INSERT screenInfo ";
    final String UPDATE_SCREEN_INFO = "UPDATE screenInfo ";
    final String INSERT_MOVIE_INFO = "INSERT movieInfo ";
    final String UPDATE_MOVIE_INFO = "UPDATE movieInfo ";


    public static DBSetter getInstance(){
        return new DBSetter();
    }

    private DBSetter(){

    }

    public void updateScreenInfo(ArrayList<ArrayList<String>> data){
        for (ArrayList list : data){
            String value = "(";
            for (Object e : list){
                value += "'" + (String)e+"', ";
            }
            value = value.substring(0, value.length()-2); // 마지막 콤마(,) 제거
            value += ")";
            System.out.println(value);

//            execute(qurey + value);
        }
    }

    public void updatamoiveInfo(){

    }



    public void run(){
    }

    public static void main(String args[]){
        DBSetter dbSetter = DBSetter.getInstance();
        ArrayList<ArrayList<String>> xxx = new ArrayList<>();
        ArrayList<String> yyy = new ArrayList<>();
        yyy.add("a");
        yyy.add("b");
        yyy.add("c");
        xxx.add(yyy);

    }
}
