import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    //String list = null;
    ArrayList<String> list;

    public static void readFile(String path, ArrayList<String> list){
        //String fileName = "E:/работа/ReplaceNumber(Java)/test.txt";
        String fileName = path;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            //StringBuilder stringBuilder = new StringBuilder();
            //String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                list.add(line);
                //stringBuilder.append(ls);
            }
            //stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            //System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
