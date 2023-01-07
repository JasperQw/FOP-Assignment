import java.util.Scanner;
import java.io.*;
public class InvalidError {
    public static void main(String[] args) {
        String keywords1 = "Invalid";
        String keywords2 = "qos";
        int totalError = 0;
        try {
            Scanner sc = new Scanner(new FileInputStream("C:\\Users\\ProUser\\Downloads\\extracted_log"));
            PrintWriter pw = new PrintWriter(new FileOutputStream("InvalidErrorNew.txt"));
            while(sc.hasNextLine()){
                String read = sc.nextLine();
                    if(read.indexOf(keywords1) >= 0 && read.indexOf(keywords2) >= 0){
                        pw.println(read);
                        totalError += 1;
                    }       
            }        
            sc.close();
            pw.close();
            System.out.println("The total invalid qos error in this log file is: " + totalError);
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        }
        try { 
            char ch = ' ';         
           
            Scanner sc = new Scanner(new FileInputStream("InvalidErrorNew.txt"));
            int i = 0;
            int Error6 = 0,Error7 = 0,Error8 = 0,Error9 = 0,Error10 = 0,Error11 = 0,Error12 = 0;
            while(sc.hasNextLine()){
                String read = sc.nextLine();
                ch = read.charAt(7);
                if(ch == '6'){
                        Error6 += 1; 
                }
                else if(ch == '7'){
                        Error7 += 1; 
                }
                else if(ch== '8'){
                        Error8 += 1; 
                }
                else if(ch == '9'){
                        Error9 += 1; 
                }
                else if(ch == '0'){
                        Error10 += 1; 
                }
                else if(ch == '1'){
                        Error11 += 1; 
                }
                else if(ch == '2'){
                        Error12 += 1; 
                }            
            } 
                System.out.println("The total invalid qos error occur in June: " + Error6);
                System.out.println("The total invalid qos occur in July: " + Error7);
                System.out.println("The total invalid qos occur in August: " + Error8);
                System.out.println("The total invalid qos occur in September: " + Error9);
                System.out.println("The total invalid qos occur in October: " + Error10);
                System.out.println("The total invalid qos occur in November: " + Error11);
                System.out.println("The total invalid qos occur in December: " + Error12);
                AnalysisError obj = new AnalysisError(Error6,Error7,Error8,Error9,Error10,Error11,Error12);
                obj.Max();      
                obj.Min();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        }
        
    }
   
}
