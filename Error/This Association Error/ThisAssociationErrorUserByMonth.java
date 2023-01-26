import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThisAssociationErrorUserByMonth {

    public static void main(String[] args)throws Exception{
        ThisAssocErrorMonth(6);
        ThisAssocErrorMonth(7);
        ThisAssocErrorMonth(8);
        ThisAssocErrorMonth(9);
        ThisAssocErrorMonth(10);
        ThisAssocErrorMonth(11);


    }
    public static ArrayList<String> user = new ArrayList<String>();

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

        //count the frequency of error of each user
        int count_row = 0;
        ArrayList<Integer> freq_List = new ArrayList<>();

        if(!user.isEmpty()){
            for (int i=0; i<userError_List.size();i++){
                count_row++;
                freq_List.add(Collections.frequency(user, userError_List.get(i)));
                System.out.printf("%-13s: %4d %1s \n", userError_List.get(i), freq_List.get(i), "times");
            }
        }
        else
            System.out.println("*** No error found ***");

        //tabulation of data
        String title = ("User with This Association Error on Month" + month);
        String [] columns = {"User ID ","Frequency of Error"};
        Object data [][] = new Object[count_row][2];
        for(int i=0; i <count_row; i++) {
            data[i][0] = userError_List.get(i);
            data[i][1] = freq_List.get(i);
        }
        Data.Table tb = new Data.Table(title, columns, data);

        System.out.println("");
        user.clear();

    }
}
