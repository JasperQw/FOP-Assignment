import java.util.*;
import java.io.*;


public class timeintervalbetweennewcompletion extends timecalculator {
    public static ArrayList<String> months=new ArrayList<String>();
    public static ArrayList<String> jobid=new ArrayList<String>();
    public static ArrayList<Double> difference=new ArrayList<Double>();

    public static void main(String[] args)throws Exception{
    
        timeintervalbetweennewcompletionSpecificMonth(6);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewcompletionSpecificMonth(7);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewcompletionSpecificMonth(8);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewcompletionSpecificMonth(9);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewcompletionSpecificMonth(10);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewcompletionSpecificMonth(11);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewcompletionSpecificMonth(12);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewcompletionOverall();
        formaltimeconverter(averagetimeexecution());


    }
    public static void timeintervalbetweennewcompletionSpecificMonth(int month)throws Exception{
        //Print result into txt file
        PrintWriter aa=new PrintWriter(new FileOutputStream("timeintervalbetweennewcompletionForMonth"+month+".txt"));
        Scanner xx=new Scanner(new FileInputStream("jobscompletedfull.txt"));
        
        
        while(xx.hasNextLine()){
            String currentline= xx.nextLine();
                if(currentline.substring(6,8).contains(Integer.toString(month))){
                    months.add(currentline.substring(0,25));
                    jobid.add(currentline.substring(41,52));
                }
        }
        
        xx.close();

        //Calculate time difference from previous to next completion in specific month 
       // System.out.println("========================================================================================");
        aa.println("========================================================================================");
       // System.out.println("@@@@@[The time difference between every completion in "+month+" are]@@@@@: ");
        aa.println("@@@@@[The time difference between every completion in month "+month+" are]@@@@@: ");
        
        for(int i=0;i<months.size()-1;i++){
            String current=months.get(i);
            String next=months.get(i+1);
           // System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
         //   System.out.println("The [*time difference*] from completion [["+(jobid.get(i))+"]] to completion [["+(jobid.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from completion [["+ (jobid.get(i))+"]] to completion [["+(jobid.get(i+1))+"]] is: ");
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

        System.out.println("The time interval between every new completion for month "+month+" are successfully printed onto #### timeintervalbetweennewcompletionForMonth"+month+".txt ####");
    }

    public static void timeintervalbetweennewcompletionOverall()throws Exception{
        //Print result into txt file
        PrintWriter aa=new PrintWriter(new FileOutputStream("timeintervalbetweennewcompletionOVERALL.txt"));
        Scanner xx=new Scanner(new FileInputStream("jobscompletedfull.txt"));
        
        
        while(xx.hasNextLine()){
            String currentline= xx.nextLine();
                months.add(currentline.substring(0,25));
                jobid.add(currentline.substring(41,52));     
        }
        
        xx.close();

        //Calculate time difference from previous to next completion 
       // System.out.println("========================================================================================");
        aa.println("========================================================================================");
       // System.out.println("@@@@@[The time difference between every completion OVERALL are]@@@@@: ");
        aa.println("@@@@@[The time difference between every completion OVERALL are]@@@@@: ");
        
        for(int i=0;i<months.size()-1;i++){
            String current=months.get(i);
            String next=months.get(i+1);
           // System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
         //   System.out.println("The [*time difference*] from completion [["+(jobid.get(i))+"]] to completion [["+(jobid.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from completion [["+ (jobid.get(i))+"]] to completion [["+(jobid.get(i+1))+"]] is: ");
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
        System.out.println("The time interval between every new completion OVERALL are successfully printed onto #### timeintervalbetweennewcompletionOVERALL.txt ####");
    }


      public static double averagetimeexecution(){
        double sum=0,average=0;

        for(int i=0;i<difference.size();i++){
            sum+=difference.get(i);
        }
        System.out.printf("The total time taken from earliest completion to latest completion in particular period @in seconds@ are: %11.4f %2s",sum/1000,"seconds");
        System.out.println();
        average=(sum/1000)/difference.size();
        System.out.printf("The average time interval between every new job completion  @in seconds@ are: %11.4f %-1s",average," seconds");
        System.out.println();
        System.out.printf("The average time interval between every new job completion  @in minutes@ are: %11.4f %-1s",(average/60)," minutes");
        System.out.println();
        System.out.printf("The average time interval between every new job completion  @in hours@   are: %11.4f %-1s",(average/60/60)," hours");
        System.out.println();
        System.out.printf("The average time interval between every new job completion  @in days@    are: %11.4f %-1s",(average/60/60/24)," days");
        System.out.println();
        difference.clear();
        return average*1000;
      }

      
    }