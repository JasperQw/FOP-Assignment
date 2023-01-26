import java.util.*;
import java.io.*;


public class timefromSubmitToAllocate extends timecalculator{
    public static ArrayList<Double> difference=new ArrayList<Double>();

    public static void timefromSubmitToAllocateOVERALL()throws Exception{

        Scanner xx= new Scanner(new FileInputStream("simplified3importantAND.txt"));
        PrintWriter yy= new PrintWriter(new FileOutputStream("timefromSubmitToAllocateOverall.txt"));
        
        ArrayList<String> timeforsubmit= new ArrayList<String>();
        ArrayList<String> timeforallocate= new ArrayList<String>();
        ArrayList<String> jobid=new ArrayList<String>();

        //find for overall execution time
        while(xx.hasNextLine()){
            String currentline=xx.nextLine();
            if(currentline.contains("submitted")){
                timeforsubmit.add(currentline.substring(23));
                jobid.add(currentline.substring(0,12));
                
            }
            else if(currentline.contains("allocated")){
                timeforallocate.add(currentline.substring(23));
            }
        }
       
        //Calculate time difference from allocate to complete (overall)
        //System.out.println("========================================================================================");
        yy.println("========================================================================================");
        //System.out.println("@@@@@[The time difference from submission to allocation OVERALL are]@@@@@: ");
        yy.println("@@@@@[The time difference from submission to allocation OVERALL are]@@@@@: ");
        
        for(int i=0;i<jobid.size();i++){
            String current=timeforsubmit.get(i);
            String next=timeforallocate.get(i);
            String id=jobid.get(i);
            //System.out.println("_____________________________________________________________________________________");
            yy.println("_____________________________________________________________________________________");
            //System.out.println("The [*time difference*] from submission to allocation for [["+id+"]] is: ");
            yy.println("The [*time difference*] from submission to allocation for [["+id+"]] is: ");
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

        yy.close();
        xx.close();
        
    }
    // find the average execution time in seconds/ minutes from job submitted to allocated (with complete work flow).
    public static double averagetimeexecution(){
        double sum=0,average=0;

        for(int i=0;i<difference.size();i++){
            sum+=difference.get(i);
        }
        System.out.printf("The total time execution from Submitted to Allocated @in seconds@ are: %11.4f %2s",sum/1000,"seconds");
        System.out.println();
        average=(sum/1000)/difference.size();
        System.out.printf("The average time execution from Submitted to Allocated for each complete work flow Job ID @in seconds@ are: %11.4f %-1s",average," seconds");
        System.out.println();
        System.out.printf("The average time execution from Submitted to Allocated for each complete work flow Job ID @in minutes@ are: %11.4f %-1s",(average/60)," minutes");
        System.out.println();
        System.out.printf("The average time execution from Submitted to Allocated for each complete work flow Job ID @in hours@   are: %11.4f %-1s",(average/60/60)," hours");
        System.out.println();
        System.out.printf("The average time execution from Submitted to Allocated for each complete work flow Job ID @in days@    are: %11.4f %-1s",(average/60/60/24)," days");
        System.out.println();

        return average*1000;
    }

    public static void main(String[] args)throws Exception{
        //print the timefromSubmitToAllocateOverall into txt file  
        timefromSubmitToAllocateOVERALL();

        //find the average time execution for the timefromSubmitToAllocate to console 
        //in (yy DD HH mm SS)format
        formaltimeconverter(averagetimeexecution());

    }
}
