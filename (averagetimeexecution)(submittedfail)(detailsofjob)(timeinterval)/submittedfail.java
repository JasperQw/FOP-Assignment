//users that are allocated and done within the month

import java.util.*;
import java.io.*;
public class submittedfail{
    static int countsubmittedfail=0;
    public static void main(String[] args) throws Exception{
        submitfail(6);
        submitfail(7);
        submitfail(8);
        submitfail(9);
        submitfail(10);
        submitfail(11);
        submitfail(12);

        System.out.println("The total jobs submitted failure in this log file (overall) :\n"+countsubmittedfail);  
    }
    public static void submitfail(int month) throws Exception{
        
        ArrayList<String> submittedfail = new ArrayList<String>();
        
        Scanner xx=new Scanner(new FileInputStream("extracted_log"));
        PrintWriter aa=new PrintWriter(new FileOutputStream("jobssubmittedfailed.txt",true));
        
        String currentline="";
        String requirement1="";
        

        while(xx.hasNextLine()){
            currentline=xx.nextLine();
            if(currentline.substring(6,8).contains(Integer.toString(month))){
                requirement1=currentline;
                //Find the number of jobs submission failure for months
                if(requirement1.contains("_slurm_rpc_submit_batch_job:")&& !requirement1.contains("JobId"))
                    submittedfail.add(requirement1);  
            }
        }
        countsubmittedfail+=submittedfail.size();
        System.out.println("The total jobs submitted failure in month "+ month +"\n"+submittedfail.size());
    
       //outputing the jobs submitted failures into new text file
       for(int i=0;i<submittedfail.size();i++){
           aa.println(submittedfail.get(i));
       }
       aa.close();
        //clear
       currentline="";
       requirement1="";
       xx.close();
    }
}
