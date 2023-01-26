import java.util.*;
import java.io.*;

public class submitfailreasons extends timecalculator{
    public static ArrayList<String> reasontype=new ArrayList<String>();
    public static ArrayList<Integer> reasontypenumbercounter=new ArrayList<Integer>();
    public static int counter;
    public static void main(String[] args)throws Exception{
        Scanner xx=new Scanner(new FileInputStream("jobssubmittedfailed.txt"));
        ArrayList<String> time=new ArrayList<String>();
        while(xx.hasNextLine()){
            time.add(xx.nextLine().substring(0,25));
        }
        
        k();
        System.out.println();
        System.out.println("The types of submission failure reasons has successfully printed into @@@ reasontypes.txt @@@ !!!!");
        System.out.println();
        for(int i=0;i<reasontype.size();i++){
            System.out.println("The number of submit failure reason for ###" + reasontype.get(i) +"### : "+ reasonnumber(reasontype.get(i)));
        }
        System.out.println("The total number of errors regarding to submission failure is: "+counter);
        
        Collections.sort(reasontypenumbercounter);
        System.out.println("The maximum number of failure for submission are: "+reasontypenumbercounter.get(reasontypenumbercounter.size()-1));
        System.out.println("The minimum number of failure for submission are: "+reasontypenumbercounter.get(0));
        System.out.println("The average number(BY types of erorrs) of all failures for submission are: "+(counter/reasontype.size()));
        System.out.println("The average number(BY overall time) of failure for submission are: "+(int)((counter)/((findtimedifference(time.get(0),time.get(time.size()-1)))/(1000*60*60*24))));  
        
    }
    public static void k()throws Exception{
        Scanner xx=new Scanner(new FileInputStream("jobssubmittedfailed.txt"));
        PrintWriter yy=new PrintWriter(new FileOutputStream("reasontypes.txt"));
        
        
        while(xx.hasNextLine()){
            String currentline= xx.nextLine();
            if(reasontype.indexOf(currentline.substring(55))==-1){
                reasontype.add(currentline.substring(55));
            }
        }
        xx.close();
        System.out.println("@@@@@@@@@@@@@@@@@@@@ Types of reason leading to job submission failure  @@@@@@@@@@@@@@@@@@");
        for(int i=0;i<reasontype.size();i++){
            yy.println(reasontype.get(i));
            System.out.println("Reason "+(i+1)+" : "+reasontype.get(i));
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        yy.close();
    }

    public static int reasonnumber(String s)throws Exception{
        
        Scanner xx=new Scanner(new FileInputStream("jobssubmittedfailed.txt"));
        int countreasontype=0;

        while(xx.hasNextLine()){
            String currentline=xx.nextLine();
            if(currentline.contains(s)){
                countreasontype++;
            }
        }
        counter+=countreasontype;
        reasontypenumbercounter.add(countreasontype);
        return countreasontype;

    }
}

