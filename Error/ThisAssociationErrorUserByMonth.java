import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThisAssociationErrorUserByMonth {

    public static ArrayList<String> user = new ArrayList<String>();

    public static void main(String[] args)throws Exception{
        ThisAssocErrorMonth(6);
        ThisAssocErrorMonth(7);
        ThisAssocErrorMonth(8);
        ThisAssocErrorMonth(9);
        ThisAssocErrorMonth(10);
        ThisAssocErrorMonth(11);


    }

    public static void ThisAssocErrorMonth(int month) throws FileNotFoundException {
        String regex = "user='(\\w+)";

        Pattern pattern = Pattern.compile(regex);
        Scanner sc = new Scanner(new FileReader("This Association Error.txt"));
        String line;

        while(sc.hasNextLine()){
            line = sc.nextLine();
            if(line.substring(6,8).contains(Integer.toString(month))){
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    user.add(matcher.group(1));
                }
            }
        }

        //remove duplicates user
        LinkedHashSet<String> userError = new LinkedHashSet<>(user);
        ArrayList<String> userError_List = new ArrayList<>(userError);


        System.out.println("-------- MONTH "+ month +" --------");
        System.out.printf("%-18s%1s\n","User","Frequency of error(s) executed");


        if(!user.isEmpty()){
            for (int i=0; i<userError_List.size();i++){
                int freq = Collections.frequency(user, userError_List.get(i));
                System.out.printf("%-13s: %4d %1s \n", userError_List.get(i), freq, "times");
            }
        }
        else
            System.out.println("*** No error found ***");

        System.out.println("");
        user.clear();
    }
}
