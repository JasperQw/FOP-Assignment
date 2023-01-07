import java.util.*;
import java.io.*;


public class submitfailreasons {
    
  
    public static void main(String[] args)throws Exception{
        k();
       
    }
    public static ArrayList<String> k()throws Exception{
        Scanner xx=new Scanner(new FileInputStream("jobssubmittedfailed.txt"));
        PrintWriter yy=new PrintWriter(new FileOutputStream("reasontypes.txt"));
        ArrayList<String> reasontype=new ArrayList<String>();
        
        
        while(xx.hasNextLine()){
            String currentline= xx.nextLine();
            if(reasontype.indexOf(currentline.substring(55))==-1){
                reasontype.add(currentline.substring(55));
            }
        }
        xx.close();

        for(int i=0;i<reasontype.size();i++){
            yy.println(reasontype.get(i));
        }

       
        yy.close();
        return reasontype;
    }
}
