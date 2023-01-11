package node_umhpc;
import java.io.*;
import java.util.*;

public class Node_umhpc {

    public static void main(String[] args) {
        try{
            Scanner content=new Scanner(new FileInputStream("Error.txt"));
            PrintWriter print=new PrintWriter(new FileOutputStream("Nodes umhpc Error.txt"));
            String input="Nodes umhpc";
            int count=0;
            int June = 0;
            int July=0;
            int Aug=0;
            int Sep=0;
            int Oct=0;
            int Nov=0;
            int Dec=0;
            
            while(content.hasNextLine()){    
                String temp=content.nextLine();
               
                        if(temp.contains(input)){
                            count++;
                            print.write("\n"+ temp);
                            
                                if(temp.contains("2022-06"))
                                    June++;
                                    
                                if(temp.contains("2022-07"))
                                    July++;    
                                    
                                if(temp.contains("2022-08"))
                                    Aug++;
                                    
                                if(temp.contains("2022-09"))
                                    Sep++;
                                    
                                if(temp.contains("2022-10"))
                                    Oct++;
                                    
                                if(temp.contains("2022-11"))
                                    Nov++;
                                    
                                if(temp.contains("2022-12"))
                                    Dec++;
                        }        
                    
            }
                    System.out.println("Nodes umhpc error occurs in June: "+June);
                    System.out.println("Nodes umhpc error occurs in July: "+July);
                    System.out.println("Nodes umhpc error occurs in August: "+Aug);
                    System.out.println("Nodes umhpc error occurs in September: "+Sep);
                    System.out.println("Nodes umhpc error occurs in October: "+Oct);
                    System.out.println("Nodes umhpc error occurs in November: "+Nov);
                    System.out.println("Nodes umhpc error occurs in December: "+Dec);
                    
                    if(count!=0){
                        System.out.println("\nTotal Nodes umhpc error in the log file: "+count);
                    }
                    
                    AnalysisError calc = new AnalysisError(June, July, Aug, Sep, Oct, Nov, Dec);
                        System.out.println();
                        calc.Max();
                        calc.Min();
                        calc.Average();
                        System.out.println();
                    
            content.close();
            print.close();
                
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
       
    }
    
}