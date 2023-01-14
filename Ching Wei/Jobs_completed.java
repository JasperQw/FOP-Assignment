import java.io.*;
import java.util.*;

public class Jobs_completed {
    static int count_completed_job = 0;
    public static void main(String [] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter (new FileOutputStream("completedJobs.txt"));
        System.out.println("Completed Jobs in June: " + completion('6', writer));
        System.out.println("Completed Jobs in July: " + completion('7', writer));
        System.out.println("Completed Jobs in August: " + completion('8', writer));
        System.out.println("Completed Jobs in September: " + completion('9', writer));
        System.out.println("Completed Jobs in October: " + completion('0', writer));
        System.out.println("Completed Jobs in November: " + completion('1', writer));
        System.out.println("Completed Jobs in December: " + completion('2', writer) + "\n");
        System.out.println("Total Completed Jobs: " + count_completed_job);

        writer.close();
    }

    public static int completion(char month, PrintWriter writer) throws FileNotFoundException {
        
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        int count_complete = 0;
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            if(temp.charAt(7) == month && temp.contains("_job_complete: JobId=") && temp.contains("done")) {
                writer.println(temp);
                count_complete ++;
            }
        }
        count_completed_job += count_complete;

        return count_complete;
    }
}