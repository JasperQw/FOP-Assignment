
import java.util.*;
import java.text.*;

public class timecalculator {
    public static ArrayList<String> cc= new ArrayList<String>();
    public static final DateFormat xx = new SimpleDateFormat( "[yyyy-MM-dd'T'HH:mm:ss.SSS]");

    public static void main(String[] args)throws Exception{
        

    }
    //for console
    public static void findforconsole(String start,String end)throws Exception{

            Date date1 = xx.parse(start);
            Date date2= xx.parse(end);
 
            long difference= date2.getTime() - date1.getTime();

            double Seconds= (double)(difference%60000)/1000;
            long Minutes= (difference/(1000*60))% 60;
            long Hours= (difference/(1000*60*60))%24;
            long Years= (difference/(1000l*60*60*24*365));
            long Days= (difference/(1000*60*60*24))%365;
            System.out.print(
                Years
                + " years, "
                + Days
                + " days, "
                + Hours
                + " hours, "
                + Minutes
                + " minutes ");
            System.out.printf("%.3f",Seconds);
            System.out.print(" seconds");
            System.out.println();

        }    
    //find time difference
    public static double findtimedifference(String start,String end)throws Exception{
            Date date1 = xx.parse(start);
            Date date2= xx.parse(end);
        
            long difference= date2.getTime() - date1.getTime();
            //find time difference in milliseconds
            
            return difference;

    }
    //for printwriter
    public static ArrayList<String> findforprintwriter(String start,String end)throws Exception{

        Date date1 = xx.parse(start);
        Date date2= xx.parse(end);
        
      
        long difference= date2.getTime() - date1.getTime();

        double Seconds= (double)(difference%60000)/1000;
        long Minutes= (difference/(1000*60))% 60;
        long Hours= (difference/(1000*60*60))%24;
        long Years= (difference/(1000l*60*60*24*365));
        long Days= (difference/(1000*60*60*24))%365;
        Formatter formatter = new Formatter();
        formatter.format("%.3f", Seconds);
        formatter.close();
    
        
        String wow=Years
            + " years, "
            + Days
            + " days, "
            + Hours
            + " hours, "
            + Minutes
            + " minutes "+Seconds
            +"seconds"+"\n";
        cc.add(wow);
        return cc;
        
    }
    
    public static void formaltimeconverter(double time){

            long difference=(long)time; 

            double Seconds= (double)(difference%60000)/1000;
            long Minutes= (difference/(1000*60))% 60;
            long Hours= (difference/(1000*60*60))%24;
            long Years= (difference/(1000l*60*60*24*365));
            long Days= (difference/(1000*60*60*24))%365;
            System.out.println(" @in YYDD HHmmSS format@ :");
            System.out.print(
                Years
                + " years, "
                + Days
                + " days, "
                + Hours
                + " hours, "
                + Minutes
                + " minutes ");
            System.out.printf("%.3f",Seconds);
            System.out.print(" seconds");
            System.out.println();

    }
    
}

