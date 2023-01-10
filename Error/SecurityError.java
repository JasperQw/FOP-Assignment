import Data.Table;
import java.io.*;
import java.util.Scanner;
public class SecurityError {
    public static void main(String[] args) {    
        try {
            String keyword = "SECURITY";
            int totalError = 0;
            Scanner sc = new Scanner(new FileInputStream("C:\\Users\\ProUser\\Downloads\\extracted_log"));
            PrintWriter pw = new PrintWriter(new FileOutputStream("SecurityError.txt"));
            while(sc.hasNextLine()) {
                String read = sc.nextLine();
                    if(read.toLowerCase().indexOf(keyword.toLowerCase()) >= 0){
                        pw.println(read);
                        totalError += 1;
                    }
            }          
            System.out.println("The total security error in this log file is: " + totalError);
            sc.close();
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex); 
        }
        try { 
            char ch = ' ';         
           
            Scanner sc = new Scanner(new FileInputStream("SecurityError.txt"));
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
                System.out.println("The total security violation error occur in June: " + Error6);
                System.out.println("The total security violation error occur in July: " + Error7);
                System.out.println("The total security violation error occur in August: " + Error8);
                System.out.println("The total security violation error occur in September: " + Error9);
                System.out.println("The total security violation error occur in October: " + Error10);
                System.out.println("The total security violation error occur in November: " + Error11);
                System.out.println("The total security violation error occur in December: " + Error12);

                AnalysisError obj = new AnalysisError(Error6,Error7,Error8,Error9,Error10,Error11,Error12);
                obj.Max();      
                obj.Min();
                obj.Average();
                String title = "Security Violation Error";
                    String [] columns = {"Month", "Number of Error"};
                    Object data[][] = {{"June", Error6 },
                                       {"July", Error7},
                                       {"August",Error8},
                                       {"September", Error9},
                                       {"October", Error10},
                                       {"November", Error11},
                                       {"December", Error12}
                                       };
                    Table tb = new Table(title, columns,data);
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        }
        
    }
}
