import java.io.*;
import java.util.*;

public class Jobs_submitted {
    static int count_Submitted_job = 0;
    public static void main(String [] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter (new FileOutputStream("submittedJobs.txt"));
        System.out.println("Submitted Jobs in June: " + submission('6', writer));
        System.out.println("Submitted Jobs in July: " + submission('7', writer));
        System.out.println("Submitted Jobs in August: " + submission('8', writer));
        System.out.println("Submitted Jobs in September: " + submission('9', writer));
        System.out.println("Submitted Jobs in October: " + submission('0', writer));
        System.out.println("Submitted Jobs in November: " + submission('1', writer));
        System.out.println("Submitted Jobs in December: " + submission('2', writer) + "\n");
        System.out.println("Total Submitted Jobs: " + count_Submitted_job);

        writer.close();
    }

    public static int submission(char month, PrintWriter writer) throws FileNotFoundException {
        
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        int count_submit = 0;
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            if(temp.charAt(7) == month && temp.contains("_slurm_rpc_submit_batch_job: JobId=")) {
                writer.println(temp);
                count_submit ++;
            }
        }
        count_Submitted_job += count_submit;

        return count_submit;
    }
}
