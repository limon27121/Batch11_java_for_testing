import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File_write {
    public static void main(String[] args) throws IOException {
        file_write();
        read_file();

    }
    public static void file_write() throws IOException {
        FileWriter fw=new FileWriter("./src/main/resources/test.txt",true);
        fw.write("Welcome to javaTpoint.\n");
        fw.write("hello limon");
        fw.close();
    }
    public static void read_file() throws IOException {
        FileReader fr=new FileReader("./src/main/resources/test.txt");
        int i;
        while((i=fr.read())!=-1)
            System.out.print((char)i);
        fr.close();
    }
}
