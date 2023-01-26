
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ErrorRate {

    public static void main(String[] args)throws Exception {
        double errorRate;

        Scanner file=new Scanner(new FileInputStream("Error.txt"));
        String input="JobId";
        int count1=0;
        while(file.hasNextLine()){
            String temp=file.nextLine();
            if(temp.contains(input)){
                count1++;
                file.nextLine();
            }
        }
        System.out.println("The total number of errors related to JobId in log file: "+count1);

        file.close();

        Scanner file2=new Scanner(new FileInputStream("jobsallocatedfull.txt"));
        int count2=0;
        while(file2.hasNextLine()){
            count2++;
            file2.nextLine();
        }
        System.out.println("The total number of jobs allocated in log file: "+count2);

        file2.close();

        errorRate=(double)count1/count2;
        DecimalFormat df = new DecimalFormat("0.00000");
        System.out.println("The error rate: "+ df.format(errorRate));



        //tabulation of data
        String title = "Error rate";
        String [] columns = {"Total number of errors related to JobId in log file",
                "Total number of jobs allocated in log file","Error Rate"};
        Object data [][] = {{count1,count2, df.format(errorRate)}};
        Data.Table tb = new Data.Table(title, columns, data);
    }
}