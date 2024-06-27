import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Update_json_file {
    public static void main(String[] args) throws IOException, ParseException {
       update("age",28);

    }

    public static void update(String key,int value) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        JSONObject obj=new JSONObject();
        obj= (JSONObject) parser.parse(new FileReader("./src/main/resources/update_json.json"));
        obj.put(key,value);
        System.out.println(obj);
        FileWriter fw=new FileWriter("./src/main/resources/update_json.json");
        fw.write(obj.toJSONString());
        fw.flush();
        fw.close();
        System.out.println("updated successfully");


    }
}
