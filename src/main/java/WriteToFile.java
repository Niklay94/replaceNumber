import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WriteToFile {
    public static void write(ArrayList<String> str, String newFilePath) throws IOException {
        //Writer writer = null;
        if (checkTheFileAlreadyExists(newFilePath))
            try (Writer writer = new FileWriter(newFilePath, false)) {
                //newFilePath = newFilePath.replaceFirst(".{4}$", "");
                //writer = new FileWriter(newFilePath + "_new.txt", false);
                // System.out.println("writer: "+writer);


                for (String line : str) {
                    writer.write(line);
                    writer.write(System.getProperty("line.separator"));
                    writer.flush();
                }
            }
    }
    public static void write(ArrayList<String> str) throws IOException {
       // Writer writer = null;

        try (Writer writer = new FileWriter("output.jmx", false)) {
            //writer = new FileWriter("output.jmx", false);
            System.out.println("writer: "+writer);
            for(String line : str) {
                writer.write(line);
                writer.write(System.getProperty("line.separator"));
                writer.flush();
            }
        }
    }

    private static boolean checkTheFileAlreadyExists(String FilePath) throws IOException {
        if(Files.exists(Paths.get(FilePath))) {
            System.out.println("File already exists. Rewrite it? (y / n)   ");
            String acception = new BufferedReader(new InputStreamReader(System.in)).readLine();

            return acception.equals("y") || acception.equals("yes");
        }

        return true;
    }
}
