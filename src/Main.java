import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        String baseDir = new File("").getAbsolutePath();
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Hello World!");
        String fileName = baseDir+"/test.txt";
        ReadFile.readFile(fileName, list);
        //System.out.println("list: "+list);
        Numeration.replace(list);
        WriteToFile.write(list);
        //System.out.println(list);
    }
}
