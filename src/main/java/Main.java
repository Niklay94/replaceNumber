import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String baseDir = new File("").getAbsolutePath();
        ArrayList<String> list = new ArrayList<>();
        String fileName = baseDir+"/test.txt";
        ReadFile.readFile(fileName, list);
        Numeration.replace(list);
        WriteToFile.write(list);
    }
}
