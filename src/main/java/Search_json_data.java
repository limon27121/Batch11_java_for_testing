import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Search_json_data {
    public static void main(String[] args) throws IOException, ParseException {
        Search_json_data s1=new Search_json_data();
       JSONObject ob1= s1.search_json_data("UIU");
        System.out.println(ob1);

    }



    public static JSONObject search_json_data(String n1) throws IOException, ParseException {
        String location="./src/main/resources/users_list.json";
        JSONParser parser=new JSONParser();
       JSONArray array= (JSONArray) parser.parse(new FileReader(location));
       for (Object ob1:array){
           JSONObject jsob1= (JSONObject) ob1;
           String university= (String) jsob1.get("university");
           if(university.contains((n1))){
               return jsob1;
           }

       }
        return null;
    }

}
