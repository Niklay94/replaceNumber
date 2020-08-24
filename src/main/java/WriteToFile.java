import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Writer;

public class WriteToFile {
    public static void write(ArrayList<String> str) throws IOException {
        Writer writer = null;
        try {
            writer = new FileWriter("test2.txt", false);
            for(String line : str) {
                writer.write(line);
                writer.write(System.getProperty("line.separator"));
                writer.flush();
            }
        } catch (Exception e) {
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                }
            }
        }

    }
}
