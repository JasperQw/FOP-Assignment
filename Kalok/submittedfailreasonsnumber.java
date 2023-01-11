import java.io.*;
import java.util.*;
public class submittedfailreasonsnumber extends submitfailreasons{

    public static void main(String[] args)throws Exception{
 
        for(int i=0;i<k().size();i++){
            reasonnumber(k().get(i));
        }

    }
    public static void reasonnumber(String s)throws Exception{
        
        Scanner xx=new Scanner(new FileInputStream("jobssubmittedfailed.txt"));
        int countreasontype=0;

        while(xx.hasNextLine()){
            String currentline=xx.nextLine();
            if(currentline.contains(s)){
                countreasontype++;
            }
        }
        System.out.println("The number of submit failure reason for " + s +" : \n"+ countreasontype);

    }
}



