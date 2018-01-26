package DataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//TODO 여러 스케줄을 담은 클래스 또 만들기
public class Schedule{
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

    public ArrayList<Theater> getThearters(){
        return theaters;
    }
}
