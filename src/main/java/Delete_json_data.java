import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Delete_json_data {
    public static void main(String[] args) throws IOException, ParseException {
        delete_data();

    }
    public static void delete_data() throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        String location="./src/main/resources/users_list.json";
        JSONArray array= (JSONArray) parser.parse(new FileReader(location));
        JSONObject obj= (JSONObject) array.get(0);
        array.remove(obj);
        FileWriter fw=new FileWriter(location);
        fw.write(array.toJSONString());
        fw.flush();
        fw.close();
        System.out.println("delete successfully");

    }
}
