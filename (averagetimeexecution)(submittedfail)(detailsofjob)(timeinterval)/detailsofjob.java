import java.util.*;
import java.io.*;

public class detailsofjob {

    static int countdone=0,countallocated=0,countsubmitted=0;
    public static ArrayList<Integer> comparatorforcompleted=new ArrayList<Integer>();
    public static ArrayList<Integer> comparatorforsubmitted=new ArrayList<Integer>();
    public static ArrayList<Integer> comparatorforallocated=new ArrayList<Integer>();
    static int monthcount=0;

    public static void main(String[] args) throws Exception{
        
        jobsmonth(6);
        jobsmonth(7);
        jobsmonth(8);
        jobsmonth(9);
        jobsmonth(10);
        jobsmonth(11);
        jobsmonth(12);

        System.out.println("The total jobs allocated in this log file :\n"+countallocated);
        System.out.println("The total jobs completed in this log file :\n"+countdone);
        System.out.println("The total jobs submitted successfully in this log file :\n"+countsubmitted);
        System.out.println("The average jobs allocated in this log file :\n"+countallocated/monthcount);
        System.out.println("The average jobs completed in this log file :\n"+countdone/monthcount);
        System.out.println("The average jobs submitted in this log file :\n"+countsubmitted/monthcount);

        Collections.sort(comparatorforallocated);
        int maximumforallocated=comparatorforallocated.get(comparatorforallocated.size()-1);
        int minimumforallocated=comparatorforallocated.get(0);
        Collections.sort(comparatorforcompleted);
        int maximumforcompleted=comparatorforcompleted.get(comparatorforcompleted.size()-1);
        int minimumforcompleted=comparatorforcompleted.get(0);
        Collections.sort(comparatorforsubmitted);
        int maximumforsubmitted=comparatorforsubmitted.get(comparatorforsubmitted.size()-1);
        int minimumforsubmitted=comparatorforsubmitted.get(0);

        System.out.println("=========================================================================");
        System.out.println("The maximum jobs submitted in this log file :\n"+maximumforsubmitted);
        System.out.println("The minimum jobs submitted in this log file :\n"+minimumforsubmitted);
        System.out.println("=========================================================================");
        System.out.println("The maximum jobs completed in this log file :\n"+maximumforcompleted);
        System.out.println("The minimum jobs completed in this log file :\n"+minimumforcompleted);
        System.out.println("=========================================================================");
        System.out.println("The maximum jobs allocated in this log file :\n"+maximumforallocated);
        System.out.println("The minimum jobs allocated in this log file :\n"+minimumforallocated);
        System.out.println("=========================================================================");


    }

    public static void jobsmonth(int month) throws Exception{
         //For months method
         PrintWriter aa=new PrintWriter(new FileOutputStream("jobsallocatedfull.txt",true));
         PrintWriter bb=new PrintWriter(new FileOutputStream("jobscompletedfull.txt",true));
         PrintWriter cc=new PrintWriter(new FileOutputStream("jobssubmittedfull.txt",true));
         
         ArrayList<String> jobscompleted=new ArrayList<String>();
         ArrayList<String> jobsallocated=new ArrayList<String>();
         ArrayList<String> jobssubmitted=new ArrayList<String>();

         Scanner xx=new Scanner(new FileInputStream("extracted_log"));
 
         String currentline="";
         String requirement1="";
         while(xx.hasNextLine()){
             currentline=xx.nextLine();
             if(currentline.substring(6,8).contains(Integer.toString(month))){
                 requirement1=currentline;
                 //Find the number of jobs completed for months
                 if(requirement1.contains("_job_complete")&& requirement1.contains("done"))
                     jobscompleted.add(requirement1);
                 //Find the number of jobs allocated for months
                 else if(requirement1.contains("Allocate JobId="))
                     jobsallocated.add(requirement1);
                 //Find the number of jobs submitted successfully for months
                 else if(requirement1.contains("_slurm_rpc_submit_batch_job: JobId"))
                    jobssubmitted.add(requirement1);
             }
         }
         countdone+=jobscompleted.size();
         countallocated+=jobsallocated.size();
         countsubmitted+=jobssubmitted.size();

         System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Month "+month+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
         System.out.println("The total jobs completed in month "+ month +"\n"+jobscompleted.size());
         System.out.println("The total jobs allocated in month "+ month +"\n"+jobsallocated.size());
         System.out.println("The total jobs submitted in month "+ month +"\n"+jobssubmitted.size());
         System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        //outputing the jobsallocated into new text file
        for(int i=0;i<jobsallocated.size();i++){
            aa.println(jobsallocated.get(i));
        }
        aa.close();

        //outputing the jobsdone into new text file
        for(int i=0;i<jobscompleted.size();i++){
            bb.println(jobscompleted.get(i));
        }
        bb.close();

        //outputing the jobssubmitted into new text file
        for(int i=0;i<jobssubmitted.size();i++){
            cc.println(jobssubmitted.get(i));
        }
        cc.close();

         
         //clear
        currentline="";
        requirement1="";

        xx.close();
        monthcount+=1;
        comparatorforcompleted.add(jobscompleted.size());
        comparatorforallocated.add(jobsallocated.size());
        comparatorforsubmitted.add(jobssubmitted.size());
       
        }

        
}
 

