import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numeration {
    public static void replace(ArrayList<String> str) throws IOException {
        String scrName = "";
        String scriptName = ".*testname=\"_UC(?<Name>[\\d]*).*";
        Pattern p = Pattern.compile(scriptName);

        for (String a:str) {
            if(a.matches(scriptName)) {
                Matcher matcher = p.matcher(a);
                while (matcher.find()) {
                    scrName = matcher.group("Name");
                    break;
                }
            }
        }

        String numberRegex = ".*testname=\"(?<Number>[\\d]*\\.[\\d]*\\.[\\d]*).*";
        int transactionNumber = -1;
        int justNumber = 1;
        for (int i = 0; i < str.size(); i++) {
            if (str.get(i).matches(".*testclass=\"TransactionController\".*")){
                transactionNumber++;
                justNumber = 1;
            }
            if (str.get(i).matches(numberRegex)){
                Pattern p2 = Pattern.compile(numberRegex);
                Matcher m2 = p2.matcher(str.get(i));
                String temp = "";
                while (m2.find()) {
                    String t = m2.group("Number");
                    System.out.println("t: "+t);
                    temp = str.get(i).replaceFirst(t, String.format("%s.%s.%s", scrName, transactionNumber, justNumber));
                    str.set(i,temp);

                }
                System.out.println(" str: "+str.get(i));
                justNumber++;
            }
        }
    }
}
