import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class json_list {
    public static void main(String[] args) throws IOException, ParseException {
        create_users_list();
        read_data();
    }

    public static void create_users_list() throws IOException, ParseException {
        String location="./src/main/resources/users_list.json";
        JSONParser parser=new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader(location));
        JSONObject obj1=new JSONObject();
        obj1.put("name","emon");
        obj1.put("degisnation","tester");
        obj1.put("university","UIU");
        array.add(obj1);
        FileWriter fw=new FileWriter(location);
        fw.write(array.toJSONString());
        fw.flush();
        fw.close();

    }
    public static void read_data() throws IOException, ParseException {
        String location="./src/main/resources/users_list.json";
        JSONParser parser=new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader(location));
       JSONObject obj=new JSONObject();
        for (int i = 0; i < array.size(); i++) {
            obj= (JSONObject) array.get(i);
            String name= (String) obj.get("name");
            String degisnation= (String) obj.get("degisnation");
            String university=obj.get("university").toString();
            System.out.println("name: "+name);
            System.out.println("university: "+university);
            System.out.println("designation: "+degisnation);
        }


    }
}
