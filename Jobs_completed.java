import java.io.*;
import java.util.*;

public class Jobs_completed {
    
    public static void main(String [] args) throws FileNotFoundException {
        System.out.println("Allocated Jobs in June: " + completion('6'));
        System.out.println("Allocated Jobs in July: " + completion('7'));
        System.out.println("Allocated Jobs in August: " + completion('8'));
        System.out.println("Allocated Jobs in September: " + completion('9'));
        System.out.println("Allocated Jobs in October: " + completion('0'));
        System.out.println("Allocated Jobs in November: " + completion('1'));
        System.out.println("Allocated Jobs in December: " + completion('2'));
    }

    public static int completion(char month) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        int count_complete = 0;
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            if(temp.charAt(7) == month) {
                String [] array = temp.split(" ");
                if (array.length == 4) {
                    if ((array[1] + " " + array[2] + " " + array[3]).matches("_job_complete: JobId=\\d{5} done")) { 
                        //System.out.println(Arrays.toString(array));
                        count_complete ++;
                    }} 
            }
        }
        return count_complete;
    }
}