import java.util.*;
import java.io.*;


public class timefromSubmitToDone extends timecalculator{
    public static ArrayList<Double> difference=new ArrayList<Double>();

    public static void timefromSubmitToDoneOVERALL()throws Exception{

        Scanner xx= new Scanner(new FileInputStream("simplified3importantAND.txt"));
        PrintWriter yy= new PrintWriter(new FileOutputStream("timefromSubmitToDoneOverall.txt"));
        
        ArrayList<String> timeforsubmit= new ArrayList<String>();
        ArrayList<String> timeforcomplete= new ArrayList<String>();
        ArrayList<String> jobid=new ArrayList<String>();
        
        //find for overall execution time
        while(xx.hasNextLine()){
            String currentline=xx.nextLine();
            if(currentline.contains("submitted")){
                timeforsubmit.add(currentline.substring(23));
                jobid.add(currentline.substring(0,12));
                
            }
            else if(currentline.contains("completed")){
                timeforcomplete.add(currentline.substring(23));
            }
        }
       

        //Calculate time difference from submit to complete (overall)
        //System.out.println("========================================================================================");
        yy.println("========================================================================================");
        //System.out.println("@@@@@[The time difference from submission to completion OVERALL are]@@@@@: ");
        yy.println("@@@@@[The time difference from submission to completion OVERALL are]@@@@@: ");
        
        for(int i=0;i<jobid.size();i++){
            String current=timeforsubmit.get(i);
            String next=timeforcomplete.get(i);
            String id=jobid.get(i);
            //System.out.println("_____________________________________________________________________________________");
            yy.println("_____________________________________________________________________________________");
            //System.out.println("The [*time difference*] from submission to completion for [["+id+"]] is: ");
            yy.println("The [*time difference*] from submission to completion for [["+id+"]] is: ");
            //System.out.println("_____________________________________________________________________________________");
            yy.println("_____________________________________________________________________________________");
            //findforconsole(current, next);
            difference.add(findtimedifference(current, next));
            findforprintwriter(current, next);
            yy.print(cc.get(i));    
        }
        
        //System.out.println();
        yy.println();
        cc.clear();
        //System.out.println("========================================================================================");
        System.out.println();
        System.out.println("The Time stamp of complete flow job submission to completion for each JOB id in order has been printed to [[timefromSubmitToDoneOverall.txt]]!!");
        System.out.println();
        yy.close();
        xx.close();
        
    }

    public static void timefromSubmissionToDoneSpecificMonth(int month)throws Exception{

        Scanner xx= new Scanner(new FileInputStream("SubmitToCompleteANDMonth"+month+".txt"));
        PrintWriter yy= new PrintWriter(new FileOutputStream("timefromSubmitToDoneforMonth"+month+".txt"));
        
        ArrayList<String> timeforsubmit= new ArrayList<String>();
        ArrayList<String> timeforcomplete= new ArrayList<String>();
        ArrayList<String> jobid=new ArrayList<String>();

        //find for overall execution time
        while(xx.hasNextLine()){
            String currentline=xx.nextLine();
            if(currentline.contains("submitted")){
                timeforsubmit.add(currentline.substring(23));
                jobid.add(currentline.substring(0,12));
                
            }
            else if(currentline.contains("completed")){
                timeforcomplete.add(currentline.substring(23));
            }
        }
       
        //Calculate time difference from submission to complete for specific month
        //System.out.println("========================================================================================");
        yy.println("========================================================================================");
        //System.out.println("@@@@@[The time difference from submission to completion for Month "+month+ " are]@@@@@: ");
        yy.println("@@@@@[The time difference from submission to completion for Month "+month+" are]@@@@@: ");
        
        for(int i=0;i<jobid.size();i++){
            String current=timeforsubmit.get(i);
            String next=timeforcomplete.get(i);
            String id=jobid.get(i);
            //System.out.println("_____________________________________________________________________________________");
            yy.println("_____________________________________________________________________________________");
            //System.out.println("The [*time difference*] from submission to completion for [["+id+"]] is: ");
            yy.println("The [*time difference*] from submission to completion for [["+id+"]] is: ");
            //System.out.println("_____________________________________________________________________________________");
            yy.println("_____________________________________________________________________________________");
            //findforconsole(current, next);
            difference.add(findtimedifference(current, next));
            findforprintwriter(current, next);
            yy.print(cc.get(i));    
        }
        
        //System.out.println();
        yy.println();
        cc.clear();
        //System.out.println("========================================================================================");
        System.out.println();
        System.out.println("The Time stamp of complete flow job submission to completion for each JOB id in order for month "+month+"has been printed to [[timefromSubmitToDoneforMonth"+month+".txt]]!!");
        System.out.println();
        yy.close();
        xx.close();

    }

    // find the average execution time in seconds/ minutes from job submission to completed (with complete work flow).
    public static double averagetimeexecution(){
        double sum=0,average=0;

        for(int i=0;i<difference.size();i++){
            sum+=difference.get(i);
        }
        System.out.printf("The total time execution from Submission to Completed @in seconds@ are: %11.4f %2s",sum/1000,"seconds");
        System.out.println();
        System.out.println();
        average=(sum/1000)/difference.size();
        System.out.printf("The average time execution from Submission to Completed for each complete work flow Job ID @in seconds@ are: %11.4f %-1s",average," seconds");
        System.out.println();
        System.out.printf("The average time execution from Submission to Completed for each complete work flow Job ID @in minutes@ are: %11.4f %-1s",(average/60)," minutes");
        System.out.println();
        System.out.printf("The average time execution from Submission to Completed for each complete work flow Job ID @in hours@   are: %11.4f %-1s",(average/60/60)," hours");
        System.out.println();
        System.out.printf("The average time execution from Submission to Completed for each complete work flow Job ID @in days@    are: %11.4f %-1s",(average/60/60/24)," days");
        System.out.println();
        difference.clear();
        return (average*1000);
    }


    public static void main(String[] args)throws Exception{
        
        //print the timefromSubmitToDoneOverall into txt file  
        timefromSubmitToDoneOVERALL();
        System.out.println("@@@@@@@@@@@@@@@ OVERALL @@@@@@@@@@@@@@\n");

        //find the average time execution for the timefromSubmitToCompletedOVERALL to console 
        //in (yy DD HH mm SS)format
        formaltimeconverter(averagetimeexecution());
        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

        //print the timefromSubmissionToDoneForMonth6 into txt file  
        timefromSubmissionToDoneSpecificMonth(6);
        System.out.println("@@@@@@@@@@@@@@@ Month 6 @@@@@@@@@@@@@@\n");
        //find the overall average time execution for the timefromSubmissionToDoneforMonth6 to console 
        //in (yy DD HH mm SS)format
        formaltimeconverter(averagetimeexecution());
        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

          //print the timefromSubmissionToDoneForMonth7 into txt file  
        timefromSubmissionToDoneSpecificMonth(7);
        System.out.println("@@@@@@@@@@@@@@@ Month 7 @@@@@@@@@@@@@@\n");
        //find the overall average time execution for the timefromSubmissionToDoneforMonth7 to console 
        //in (yy DD HH mm SS)format
        formaltimeconverter(averagetimeexecution());
        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");


          //print the timefromSubmissionToDoneForMonth8 into txt file  
        timefromSubmissionToDoneSpecificMonth(8);
        System.out.println("@@@@@@@@@@@@@@@ Month 8 @@@@@@@@@@@@@@\n");
        //find the overall average time execution for the timefromSubmissionToDoneforMonth8 to console 
        //in (yy DD HH mm SS)format
        formaltimeconverter(averagetimeexecution());
        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


          //print the timefromSubmissionToDoneForMonth9 into txt file  
        timefromSubmissionToDoneSpecificMonth(9);
        System.out.println("@@@@@@@@@@@@@@@ Month 9 @@@@@@@@@@@@@@\n");
        //find the overall average time execution for the timefromSubmissionToDoneforMonth9 to console 
        //in (yy DD HH mm SS)format
        formaltimeconverter(averagetimeexecution());
        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");



      //print the timefromSubmissionToDoneForMonth10 into txt file  
        timefromSubmissionToDoneSpecificMonth(10);
        System.out.println("@@@@@@@@@@@@@@@ Month 10 @@@@@@@@@@@@@@\n");
        //find the overall average time execution for the timefromSubmissionToDoneforMonth10 to console 
        //in (yy DD HH mm SS)format
        formaltimeconverter(averagetimeexecution());
        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


          //print the timefromSubmissionToDoneForMonth11 into txt file  
        timefromSubmissionToDoneSpecificMonth(11);
        System.out.println("@@@@@@@@@@@@@@@ Month 11 @@@@@@@@@@@@@@\n");
        //find the overall average time execution for the timefromSubmissionToDoneforMonth11 to console 
        //in (yy DD HH mm SS)format
        formaltimeconverter(averagetimeexecution());
        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


          //print the timefromSubmissionToDoneForMonth12 into txt file  
        timefromSubmissionToDoneSpecificMonth(12);
        System.out.println("@@@@@@@@@@@@@@@ Month 12 @@@@@@@@@@@@@@\n");
        //find the overall average time execution for the timefromSubmissionToDoneforMonth12 to console 
        //in (yy DD HH mm SS)format
        formaltimeconverter(averagetimeexecution());
        System.out.println();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


    
    }
}
