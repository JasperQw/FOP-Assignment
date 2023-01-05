import java.io.*;
import java.util.*;

public class Jobs_completed {
    
    public static void main(String [] args) throws FileNotFoundException {
        System.out.println("Completed Jobs in June: " + completion('6'));
        System.out.println("Completed Jobs in July: " + completion('7'));
        System.out.println("Completed Jobs in August: " + completion('8'));
        System.out.println("Completed Jobs in September: " + completion('9'));
        System.out.println("Completed Jobs in October: " + completion('0'));
        System.out.println("Completed Jobs in November: " + completion('1'));
        System.out.println("Completed Jobs in December: " + completion('2'));
    }

    public static int completion(char month) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        int count_complete = 0;
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            String [] array = temp.split(" ");
            if(temp.charAt(7) == month && array.length == 4 && (array[1] + " " + array[2] + " " + array[3]).matches("_job_complete: JobId=\\d{5} done")) {
                count_complete ++;
            }
        }
        return count_complete;
    }
}