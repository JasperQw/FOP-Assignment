import java.util.*;
import java.io.*;


public class timeintervalbetweennewsubmission extends timecalculator {
    public static ArrayList<String> months=new ArrayList<String>();
    public static ArrayList<String> jobid=new ArrayList<String>();
    public static ArrayList<Double> difference=new ArrayList<Double>();

    public static void main(String[] args)throws Exception{
    
        timeintervalbetweennewsubmissionSpecificMonth(6);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewsubmissionSpecificMonth(7);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewsubmissionSpecificMonth(8);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewsubmissionSpecificMonth(9);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewsubmissionSpecificMonth(10);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewsubmissionSpecificMonth(11);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewsubmissionSpecificMonth(12);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewsubmissionOverall();
        formaltimeconverter(averagetimeexecution());


    }
    public static void timeintervalbetweennewsubmissionSpecificMonth(int month)throws Exception{
        //Print result into txt file
        PrintWriter aa=new PrintWriter(new FileOutputStream("timeintervalbetweennewsubmissionForMonth"+month+".txt"));
        Scanner xx=new Scanner(new FileInputStream("jobssubmittedfull.txt"));
        
        
        while(xx.hasNextLine()){
            String currentline= xx.nextLine();
                if(currentline.substring(6,8).contains(Integer.toString(month))){
                    months.add(currentline.substring(0,25));
                    jobid.add(currentline.substring(55,66));
                }
        }
        
        xx.close();

        //Calculate time difference from previous to next submission in specific month 
       // System.out.println("========================================================================================");
        aa.println("========================================================================================");
       // System.out.println("@@@@@[The time difference between every submission in "+month+" are]@@@@@: ");
        aa.println("@@@@@[The time difference between every submission in month "+month+" are]@@@@@: ");
        
        for(int i=0;i<months.size()-1;i++){
            String current=months.get(i);
            String next=months.get(i+1);
           // System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
         //   System.out.println("The [*time difference*] from submission [["+(jobid.get(i))+"]] to submission [["+(jobid.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from submission [["+ (jobid.get(i))+"]] to submission [["+(jobid.get(i+1))+"]] is: ");
          //  System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
         //   findforconsole(current, next);
            difference.add(findtimedifference(current, next));
            findforprintwriter(current, next);
            aa.print(cc.get(i));    
        }
        
      //  System.out.println();
        aa.println();
        cc.clear();
      //  System.out.println("========================================================================================");
        months.clear();
        jobid.clear();
        aa.close();

        System.out.println("The time interval between every new submission for month "+month+" are successfully printed onto #### timeintervalbetweennewsubmissionForMonth"+month+".txt ####");
    }

    public static void timeintervalbetweennewsubmissionOverall()throws Exception{
        //Print result into txt file
        PrintWriter aa=new PrintWriter(new FileOutputStream("timeintervalbetweennewsubmissionOVERALL.txt"));
        Scanner xx=new Scanner(new FileInputStream("jobssubmittedfull.txt"));
        
        
        while(xx.hasNextLine()){
            String currentline= xx.nextLine();
                months.add(currentline.substring(0,25));
                jobid.add(currentline.substring(55,66));     
        }
        
        xx.close();

        //Calculate time difference from previous to next submission 
       // System.out.println("========================================================================================");
        aa.println("========================================================================================");
       // System.out.println("@@@@@[The time difference between every submission OVERALL are]@@@@@: ");
        aa.println("@@@@@[The time difference between every submission OVERALL are]@@@@@: ");
        
        for(int i=0;i<months.size()-1;i++){
            String current=months.get(i);
            String next=months.get(i+1);
           // System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
         //   System.out.println("The [*time difference*] from submission [["+(jobid.get(i))+"]] to submission [["+(jobid.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from submission [["+ (jobid.get(i))+"]] to submission [["+(jobid.get(i+1))+"]] is: ");
          //  System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
         //   findforconsole(current, next);
            difference.add(findtimedifference(current, next));
            findforprintwriter(current, next);
            aa.print(cc.get(i));    
        }
        
      //  System.out.println();
        aa.println();
        cc.clear();
      //  System.out.println("========================================================================================");
        months.clear();
        jobid.clear();
        aa.close();
        System.out.println("The time interval between every new submission OVERALL are successfully printed onto #### timeintervalbetweennewsubmissionOVERALL.txt ####");
    }


      public static double averagetimeexecution(){
        double sum=0,average=0;

        for(int i=0;i<difference.size();i++){
            sum+=difference.get(i);
        }
        System.out.printf("The total time taken from earliest submission to latest submission in particular period @in seconds@ are: %11.4f %2s",sum/1000,"seconds");
        System.out.println();
        average=(sum/1000)/difference.size();
        System.out.printf("The average time interval between every new job submission  @in seconds@ are: %11.4f %-1s",average," seconds");
        System.out.println();
        System.out.printf("The average time interval between every new job submission  @in minutes@ are: %11.4f %-1s",(average/60)," minutes");
        System.out.println();
        System.out.printf("The average time interval between every new job submission  @in hours@   are: %11.4f %-1s",(average/60/60)," hours");
        System.out.println();
        System.out.printf("The average time interval between every new job submission  @in days@    are: %11.4f %-1s",(average/60/60/24)," days");
        System.out.println();
        difference.clear();
        return average*1000;
      }

      
    }