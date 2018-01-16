package Utils;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Json {
    JSONArray jsonArray;
    JSONObject externalObject;
    JSONObject internalObject;
    ArrayList<JSONObject> list;


    public Json(){
        jsonArray = new JSONArray();
        externalObject = new JSONObject();
        list = new ArrayList<>();
        try {
            externalObject.put("영화", jsonArray);
            internalObject = new JSONObject();
            internalObject.put("name", "matrix");
            list.add(internalObject);
            internalObject = new JSONObject();
            internalObject.put("name", "matrix2");
            list.add(internalObject);
            internalObject = new JSONObject();
            internalObject.put("name", "matrix3");
            list.add(internalObject);
            internalObject = new JSONObject();
            internalObject.put("name", "matrix4");
            list.add(internalObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (JSONObject e : list){
            jsonArray.put(e);
        }

        System.out.println(externalObject.toString());
    }

    public static void main(String args[]){
        Json json = new Json();
    }
}
