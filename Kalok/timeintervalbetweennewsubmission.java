import java.util.*;
import java.io.*;


public class timeintervalbetweennewsubmission extends timecalculator {

    public static void main(String[] args)throws Exception{
        //Print result into txt file
        PrintWriter aa=new PrintWriter(new FileOutputStream("timeintervalbetweennewsubmission.txt"));
        
        Scanner xx=new Scanner(new FileInputStream("simplified3importantall.txt"));
        ArrayList<String> month6= new ArrayList<String>();
        ArrayList<String> month7= new ArrayList<String>();
        ArrayList<String> month8= new ArrayList<String>();
        ArrayList<String> month9= new ArrayList<String>();
        ArrayList<String> month10= new ArrayList<String>();
        ArrayList<String> month11= new ArrayList<String>();
        ArrayList<String> month12= new ArrayList<String>();
        ArrayList<String> jobid6=new ArrayList<String>();
        ArrayList<String> jobid7=new ArrayList<String>();
        ArrayList<String> jobid8=new ArrayList<String>();
        ArrayList<String> jobid9=new ArrayList<String>();
        ArrayList<String> jobid10=new ArrayList<String>();
        ArrayList<String> jobid11=new ArrayList<String>();
        ArrayList<String> jobid12=new ArrayList<String>();
        
        while(xx.hasNextLine()){
            String currentline= xx.nextLine();
                if(currentline.substring(12).contains("submitted")&&currentline.substring(29,31).contains("06")){
                    month6.add(currentline.substring(23));
                    jobid6.add(currentline.substring(0,12));
                }
                else if(currentline.substring(12).contains("submitted")&&currentline.substring(29,31).contains("07")){
                    month7.add(currentline.substring(23));
                    jobid7.add(currentline.substring(0,12));
                }
                else if(currentline.substring(12).contains("submitted")&&currentline.substring(29,31).contains("08")){
                    month8.add(currentline.substring(23));
                    jobid8.add(currentline.substring(0,12));
                }
                else if(currentline.substring(12).contains("submitted")&&currentline.substring(29,31).contains("09")){
                    month9.add(currentline.substring(23));
                    jobid9.add(currentline.substring(0,12));
                }
                else if(currentline.substring(12).contains("submitted")&&currentline.substring(29,31).contains("10")){
                    month10.add(currentline.substring(23));
                    jobid10.add(currentline.substring(0,12));
                }
                else if(currentline.substring(12).contains("submitted")&&currentline.substring(29,31).contains("11")){
                    month11.add(currentline.substring(23));
                    jobid11.add(currentline.substring(0,12));
                }
                else if(currentline.substring(12).contains("submitted")&&currentline.substring(29,31).contains("12")){
                    month12.add(currentline.substring(23));
                    jobid12.add(currentline.substring(0,12));
                }

        }
        
        xx.close();

        //Calculate time difference from previous to next submission in month 6
        System.out.println("========================================================================================");
        aa.println("========================================================================================");
        System.out.println("@@@@@[The time difference between every submission in June are]@@@@@: ");
        aa.println("@@@@@[The time difference between every submission in June are]@@@@@: ");
        
        for(int i=0;i<month6.size()-1;i++){
            String current=month6.get(i);
            String next=month6.get(i+1);
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            System.out.println("The [*time difference*] from submission [["+(jobid6.get(i))+"]] to submission [["+(jobid6.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from submission [["+ (jobid6.get(i))+"]] to submission [["+(jobid6.get(i+1))+"]] is: ");
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            findforconsole(current, next);
            findforprintwriter(current, next);
            aa.print(cc.get(i));    
        }
        
        System.out.println();
        aa.println();
        cc.clear();
        System.out.println("========================================================================================");

        //Calculate time difference from previous to next submission in month 7
        System.out.println("========================================================================================");
        aa.println("========================================================================================");
        System.out.println("@@@@@[The time difference between every submission in July are]@@@@@: ");
        aa.println("@@@@@[The time difference between every submission in July are]@@@@@: ");
        
        for(int i=0;i<month7.size()-1;i++){
            String current=month7.get(i);
            String next=month7.get(i+1);
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            System.out.println("The [*time difference*] from submission [["+ (jobid7.get(i))+"]] to submission [["+(jobid7.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from submission [["+ (jobid7.get(i))+"]] to submission [["+(jobid7.get(i+1))+"]] is: ");
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            findforconsole(current,next);
            findforprintwriter(current, next);
            aa.print(cc.get(i));

        }
        cc.clear();
        System.out.println();
        aa.println();

        System.out.println("========================================================================================");

        //Calculate time difference from previous to next submission in month 8
        System.out.println("========================================================================================");
        aa.println("========================================================================================");
        System.out.println("@@@@@[The time difference between every submission in August are]@@@@@: ");
        aa.println("@@@@@[The time difference between every submission in August are]@@@@@: ");
        
        for(int i=0;i<month8.size()-1;i++){
            String current=month8.get(i);
            String next=month8.get(i+1);
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            System.out.println("The [*time difference*] from submission [["+ (jobid8.get(i))+"]] to submission [["+(jobid8.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from submission [["+ (jobid8.get(i))+"]] to submission [["+(jobid8.get(i+1))+"]] is: ");
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            findforconsole(current,next);
            findforprintwriter(current, next);
            aa.print(cc.get(i));



        }
        cc.clear();
        System.out.println();
        aa.println();

        System.out.println("========================================================================================");

        //Calculate time difference from previous to next submission in month 9
        System.out.println("========================================================================================");
        aa.println("========================================================================================");
        System.out.println("@@@@@[The time difference between every submission in September are]@@@@@: ");
        aa.println("@@@@@[The time difference between every submission in September are]@@@@@: ");
        
        for(int i=0;i<month9.size()-1;i++){
            String current=month9.get(i);
            String next=month9.get(i+1);
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            System.out.println("The [*time difference*] from submission [["+ (jobid9.get(i))+"]] to submission [["+(jobid9.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from submission [["+ (jobid9.get(i))+"]] to submission [["+(jobid9.get(i+1))+"]] is: ");
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            findforconsole(current,next);
            findforprintwriter(current, next);
            aa.print(cc.get(i));  
        }
        cc.clear();
        System.out.println();
        aa.println();

        System.out.println("========================================================================================");

        //Calculate time difference from previous to next submission in month 10
        System.out.println("========================================================================================");
        aa.println("========================================================================================");
        System.out.println("@@@@@[The time difference between every submission in October are]@@@@@: ");
        aa.println("@@@@@[The time difference between every submission in October are]@@@@@: ");
        
        for(int i=0;i<month10.size()-1;i++){
            String current=month10.get(i);
            String next=month10.get(i+1);
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            System.out.println("The [*time difference*] from submission [["+ (jobid10.get(i))+"]] to submission [["+(jobid10.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from submission [["+ (jobid10.get(i))+"]] to submission [["+(jobid10.get(i+1))+"]] is: ");
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            findforconsole(current,next);
            findforprintwriter(current, next);
            aa.print(cc.get(i));


            
        }
        cc.clear();
        System.out.println();
        aa.println();

        System.out.println("========================================================================================");

        //Calculate time difference from previous to next submission in month 11
        System.out.println("========================================================================================");
        aa.println("========================================================================================");
        System.out.println("@@@@@[The time difference between every submission in November are]@@@@@: ");
        aa.println("@@@@@[The time difference between every submission in November are]@@@@@: ");
        
        for(int i=0;i<month11.size()-1;i++){
            String current=month11.get(i);
            String next=month11.get(i+1);
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            System.out.println("The [*time difference*] from submission [["+ (jobid11.get(i))+"]] to submission [["+(jobid11.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from submission [["+ (jobid11.get(i))+"]] to submission [["+(jobid11.get(i+1))+"]] is: ");
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            findforconsole(current,next);
            findforprintwriter(current, next);
            aa.print(cc.get(i));


            
        }
        cc.clear();
        System.out.println();
        aa.println();

        System.out.println("========================================================================================");

        //Calculate time difference from previous to next submission in month 12
        System.out.println("========================================================================================");
        aa.println("========================================================================================");
        System.out.println("@@@@@[The time difference between every submission in December are]@@@@@: ");
        aa.println("@@@@@[The time difference between every submission in December are]@@@@@: ");
        
        for(int i=0;i<month12.size()-1;i++){
            String current=month12.get(i);
            String next=month12.get(i+1);
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            System.out.println("The [*time difference*] from submission [["+ (jobid12.get(i))+"]] to submission [["+(jobid12.get(i+1))+"]] is: ");
            aa.println("The [*time difference*] from submission [["+ (jobid12.get(i))+"]] to submission [["+(jobid12.get(i+1))+"]] is: ");
            System.out.println("_____________________________________________________________________________________");
            aa.println("_____________________________________________________________________________________");
            findforconsole(current,next);
            findforprintwriter(current, next);
            aa.print(cc.get(i));

            
        }    
        cc.clear();
        System.out.println();
        aa.println();

        System.out.println("========================================================================================");

        aa.close(); 
    }
}

