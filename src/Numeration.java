import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numeration {
    public static void replace(ArrayList<String> str) throws IOException {

        String scrName = "";

        String scriptName = ".*testname=\"_UC(?<Name>[\\d]*).*";
        //Pattern pattern = Pattern.compile(".*Ariel.*|.*Sleeping Beauty.*");
        //String pattern = "\\d\\d\\d([,\\s])?\\d\\d\\d\\d";
        Pattern p = Pattern.compile(scriptName);
        //System.out.println("str: "+str);
        for (String a:str) {
            //System.out.println("                            a: "+a);
            //System.out.println("Pattern.matches(scriptName,a): "+Pattern.matches("testname=\"_UC([\\d]*)",a));
            //System.out.println("        a.matches(scriptName): "+a.matches(".*testname=\"_UC([\\d]*).*"));
            if(a.matches(scriptName)) {
                Matcher matcher = p.matcher(a);
                //System.out.println("matcher: "+matcher);
                while (matcher.find()) {
                    scrName = matcher.group("Name");
                    System.out.println("scrName: " + scrName);
                    break;
                }
                //String scrName = matcher.find().group("Name").;
                //System.out.println("scrName: "+scrName);
            }
        }

        //String Regex = "testname=\"(?<Number>[\\d]*\\.[\\d]*\\.[\\d]*)";
        //Pattern numberRegex = Pattern.compile("testname=\"(?<Number>[\\d]*\\.[\\d]*\\.[\\d]*)");
        String numberRegex = ".*testname=\"(?<Number>[\\d]*\\.[\\d]*\\.[\\d]*).*";
        int transactionNumber = -1;
        int justNumber = 1;
        for (int i = 0; i < str.size(); i++) {
            //System.out.println("-----here-----");
            //String strFind = str.get(i);
            //System.out.println("str.get(i).matches(numberRegex): "+str.get(i).matches(".*testclass=\"TransactionController\".*"));
            if (str.get(i).matches(".*testclass=\"TransactionController\".*")){
                transactionNumber++;
                justNumber = 1;
            }
            //System.out.println("str.get(i).matches(numberRegex): "+str.get(i).matches(numberRegex));
            if (str.get(i).matches(numberRegex)){
                Pattern p2 = Pattern.compile(numberRegex);
                Matcher m2 = p2.matcher(str.get(i));
                String temp = "";
                while (m2.find()) {
                    String t = m2.group("Number");
                    System.out.println("t: "+t);
                    //temp = str.get(i).replaceFirst(t, String.format("#.#.#", scrName, transactionNumber, justNumber));
                    temp = str.get(i).replaceFirst(t, String.format("%s.%s.%s", scrName, transactionNumber, justNumber));
                    str.set(i,temp);

                }
                System.out.println("temp: "+temp);
                System.out.println(" str: "+str.get(i));
                //str.get(i) = temp;
                justNumber++;
            }
        }
    }
}
