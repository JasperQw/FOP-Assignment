import java.util.*;
import java.io.*;

public class all {

    static int countdone=0,countallocated=0,countsubmitted=0;

    public static void main(String[] args) throws Exception{
        
         
        
        PrintWriter dd=new PrintWriter(new FileOutputStream("jobssubmitted&allocated&completedfull.txt",true));
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
    } 
}


