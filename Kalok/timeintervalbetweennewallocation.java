import java.util.*;
import java.io.*;


public class timeintervalbetweennewallocation extends timecalculator {
    public static ArrayList<String> months=new ArrayList<String>();
    public static ArrayList<String> jobid=new ArrayList<String>();
    public static ArrayList<Double> difference=new ArrayList<Double>();

    public static void main(String[] args)throws Exception{
    
        timeintervalbetweennewallocationSpecificMonth(6);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewallocationSpecificMonth(7);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewallocationSpecificMonth(8);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewallocationSpecificMonth(9);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewallocationSpecificMonth(10);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewallocationSpecificMonth(11);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewallocationSpecificMonth(12);
        formaltimeconverter(averagetimeexecution());

        timeintervalbetweennewallocationOverall();
        formaltimeconverter(averagetimeexecution());


    }
    public static void timeintervalbetweennewallocationSpecificMonth(int month)throws Exception{
        //Print result into txt file
        PrintWriter aa=new PrintWriter(new FileOutputStream("timeintervalbetweennewallocationForMonth"+month+".txt"));
        Scanner xx=new Scanner(new FileInputStream("jobsallocatedfull.txt"));
        
        
        while(xx.hasNextLine()){
            String currentline= xx.nextLine();
                if(currentline.substring(6,8).contains(Integer.toString(month))){
                    months.add(currentline.substring(0,25));
                    jobid.add(currentline.substring(42,53));
                }
        }
        
        xx.close();

        //Calculate time difference from previous to next allocation in specific month 
       // System.out.println("========================================================================================");
        aa.println("========================================================================================");
       // System.out.println("@@@@@[The time difference between every allocation in "+month+" are]@@@@@: ");
        aa.println("@@@@@[The time difference between every allocation in month "+month+" are]@@@@@: ");
        
        for(int i=0;i<months.size()-1;i++){
            String current=months.get(i);
            String next=months.get(i+1);
           // System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
         //   System.out.println("The [*time difference*] from allocation [["+(jobid.get(i))+"]] to allocation [["+(jobid.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from allocation [["+ (jobid.get(i))+"]] to allocation [["+(jobid.get(i+1))+"]] is: ");
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

        System.out.println("The time interval between every new allocation for month "+month+" are successfully printed onto #### timeintervalbetweennewallocationForMonth"+month+".txt ####");
    }

    public static void timeintervalbetweennewallocationOverall()throws Exception{
        //Print result into txt file
        PrintWriter aa=new PrintWriter(new FileOutputStream("timeintervalbetweennewallocationOVERALL.txt"));
        Scanner xx=new Scanner(new FileInputStream("jobsallocatedfull.txt"));
        
        
        while(xx.hasNextLine()){
            String currentline= xx.nextLine();
                months.add(currentline.substring(0,25));
                jobid.add(currentline.substring(42,53));     
        }
        
        xx.close();

        //Calculate time difference from previous to next allocation 
       // System.out.println("========================================================================================");
        aa.println("========================================================================================");
       // System.out.println("@@@@@[The time difference between every allocation OVERALL are]@@@@@: ");
        aa.println("@@@@@[The time difference between every allocation OVERALL are]@@@@@: ");
        
        for(int i=0;i<months.size()-1;i++){
            String current=months.get(i);
            String next=months.get(i+1);
           // System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
         //   System.out.println("The [*time difference*] from allocation [["+(jobid.get(i))+"]] to allocation [["+(jobid.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from allocation [["+ (jobid.get(i))+"]] to allocation [["+(jobid.get(i+1))+"]] is: ");
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
        System.out.println("The time interval between every new allocation OVERALL are successfully printed onto #### timeintervalbetweennewallocationOVERALL.txt ####");
    }


      public static double averagetimeexecution(){
        double sum=0,average=0;

        for(int i=0;i<difference.size();i++){
            sum+=difference.get(i);
        }
        System.out.printf("The total time taken from earliest allocation to latest allocation in particular period @in seconds@ are: %11.4f %2s",sum/1000,"seconds");
        System.out.println();
        average=(sum/1000)/difference.size();
        System.out.printf("The average time interval between every new job allocation  @in seconds@ are: %11.4f %-1s",average," seconds");
        System.out.println();
        System.out.printf("The average time interval between every new job allocation  @in minutes@ are: %11.4f %-1s",(average/60)," minutes");
        System.out.println();
        System.out.printf("The average time interval between every new job allocation  @in hours@   are: %11.4f %-1s",(average/60/60)," hours");
        System.out.println();
        System.out.printf("The average time interval between every new job allocation  @in days@    are: %11.4f %-1s",(average/60/60/24)," days");
        System.out.println();
        difference.clear();
        return average*1000;
      }

      
    }