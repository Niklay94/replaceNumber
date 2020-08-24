import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static ArrayList<String> list = new ArrayList<>();
   // public static String pathOut = null;
    public static void main(String[] args) throws IOException {
        try {
            //ReadFile.readFile("D:/ReplaceNumber(Java)_1/test.txt", list);
            ReadFile.readFile(args[0], list);
            Numeration.replace(list);

            if (args[1] == null)
                WriteToFile.write(list);
            else
                WriteToFile.write(list, args[1]);

            //WriteToFile.write(list, "D:/ReplaceNumber(Java)_1/test.txt");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: no file specified. \n " +
                    "Usage: java -jar <filename>, <output filename> \n");


        }
    }
}
