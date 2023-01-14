import java.util.*;
import java.io.*;

public class backfillJobs {
    static int count = 0;
    public static void main(String [] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new FileOutputStream("backfill.txt"));
        BackFill('6', writer);
        BackFill('7', writer);
        BackFill('8', writer);
        BackFill('9', writer);
        BackFill('0', writer);
        BackFill('1', writer);
        BackFill('2', writer);
        System.out.println();
        writer.close();

        System.out.println("Total backfill jobs: " + count);
    }

    public static void BackFill(char month, PrintWriter writer) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileReader("extracted_log"));
        
        int counting = 0;
        while(reader.hasNextLine()) {
            String temp = reader.nextLine();

            if (temp.contains("sched/backfill:") && temp.charAt(7) == month) {
                writer.println(temp);
                counting ++;
            }
        }
        reader.close();
        System.out.println("Number of BackFill Jobs in month " + month + ": " + counting);

        count += counting;
    }
    
}
