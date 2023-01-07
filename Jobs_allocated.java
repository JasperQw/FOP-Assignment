import java.io.*;
import java.util.*;


public class Jobs_allocated {
    static int count_allocated_job = 0;
    public static void main(String [] args) throws FileNotFoundException {
        System.out.println("Allocated Jobs in June: " + allocation('6'));
        System.out.println("Allocated Jobs in July: " + allocation('7'));
        System.out.println("Allocated Jobs in August: " + allocation('8'));
        System.out.println("Allocated Jobs in September: " + allocation('9'));
        System.out.println("Allocated Jobs in October: " + allocation('0'));
        System.out.println("Allocated Jobs in November: " + allocation('1'));
        System.out.println("Allocated Jobs in December: " + allocation('2') + "\n");
        System.out.println("Total Allocated Jobs: " + count_allocated_job);
    }



    public static int allocation(char month) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new FileOutputStream("allocatedJobs.txt",true));
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        int count_allocate = 0;
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            if(temp.contains("Allocate JobId") && temp.charAt(7) == month) {
                writer.println(temp);
                count_allocate ++;
            }
        }
        count_allocated_job+=count_allocate;
        writer.close();
        return count_allocate;
    }
}

