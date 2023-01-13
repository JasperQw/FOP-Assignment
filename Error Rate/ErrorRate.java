package error.rate;

import java.io.*;
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
        System.out.printf("The error rate: %.5f\n",errorRate);
        
    }
}