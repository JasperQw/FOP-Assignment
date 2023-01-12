import java.util.*;
import java.io.*;

public class all {

    static int countdone=0,countallocated=0,countsubmitted=0;

    public static void main(String[] args) throws Exception{
        
         
        
        PrintWriter dd=new PrintWriter(new FileOutputStream("jobssubmitted&allocated&completedfull.txt"));
        Scanner xx=new Scanner(new FileInputStream("extracted_log"));
        ArrayList<String> all= new ArrayList<String>();
 
        
        String requirement1="";
        while(xx.hasNextLine()){
             requirement1=xx.nextLine();
                 //Add jobs submitted, allocate and completeddone.
                 if((requirement1.contains("_job_complete")&& requirement1.contains("done"))|(requirement1.contains("Allocate JobId="))|(requirement1.contains("_slurm_rpc_submit_batch_job: JobId"))){
                    all.add(requirement1);  
                }
        }
        

        //write into file
        for(int i=0;i<all.size();i++){
            dd.println(all.get(i));
        }
        dd.close();
         //clear
    
        requirement1="";

        xx.close();
        System.out.println("The file has been scanned successfully!");  
        System.out.println("Lines containing keywords: \n@@@ _job_complete........done @@@ \n@@@ Allocate JobId=...... @@@ \n@@@ _slurm_rpc_submit_batch_job: JobId @@@");   
        System.out.println("have been printed successfully onto ---> [ jobssubmitted&allocated&completedfull.txt ]");   
        System.out.println();
        System.out.println("Total of lines containing the keywords: ["+all.size()+"]");
    } 
}


