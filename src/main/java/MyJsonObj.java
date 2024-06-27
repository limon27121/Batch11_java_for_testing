


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyJsonObj {
    public static void main(String[] args) throws IOException, ParseException {
        create_json_object();
        read_json_data();
    }
    public static void create_json_object() throws IOException {
        JSONObject empobj = new JSONObject();
        empobj.put("name", "limon");
        empobj.put("deparment", "CSE");
        empobj.put("phone", "01623692274");

        JSONObject addressobj = new JSONObject();
        addressobj.put("area", "mirpur");
        addressobj.put("thana", "shah ali");

        // Add the address object to the employee object
        empobj.put("address", addressobj);

        // Ensure the directory exists or handle the exception if the path is invalid
        FileWriter fw = new FileWriter("./src/main/resources/user.json");
        fw.write(empobj.toJSONString());
        fw.flush();
        fw.close();

    }

    public static void read_json_data() throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        JSONObject obj1=(JSONObject)parser.parse(new FileReader("./src/main/resources/user.json"));

        String name = (String) obj1.get("name");
        String phone = (String) obj1.get("phone");
        JSONObject addressobj=(JSONObject)obj1.get("address");
        String thana= (String) addressobj.get("thana");
        String area= (String) addressobj.get("area");
        // Output the values to verify they were read correctly
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("address: "+addressobj);
        System.out.println("thana: "+thana);
        System.out.println("area: "+area);
    }
}

