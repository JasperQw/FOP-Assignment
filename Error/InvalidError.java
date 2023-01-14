import Data.Table;
import java.util.Scanner;
import java.io.*;
public class InvalidError {
    public static void main(String[] args) throws Exception {
        String keywords1 = "Invalid";
        String keywords2 = "qos";
        String keywords3 = "slurm";
        String keywords4 = "submit";
        int totalError = 0;
        //read the log file and write the line that contain the keyword into a txt.file
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\ProUser\\Downloads\\extracted_log"));
        PrintWriter pw = new PrintWriter(new FileOutputStream("InvalidErrorNew.txt"));
            while(sc.hasNextLine()){
                String read = sc.nextLine();
                    if(read.indexOf(keywords1) >= 0 && read.indexOf(keywords2) >= 0 && read.indexOf(keywords3) >= 0 && read.indexOf(keywords4) >= 0){
                        pw.println(read);
                        totalError += 1;
                    }       
            }        
            sc.close();
            pw.close();
            System.out.println("The total invalid qos error in this log file is: " + totalError);

            //find the error occur in each month
            char ch = ' ';         
            Scanner input = new Scanner(new FileInputStream("InvalidErrorNew.txt"));
            int Error6 = 0,Error7 = 0,Error8 = 0,Error9 = 0,Error10 = 0,Error11 = 0,Error12 = 0;
            while(input.hasNextLine()){
                String read = input.nextLine();
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
                
                //Analysis data
                AnalysisError obj = new AnalysisError(Error6,Error7,Error8,Error9,Error10,Error11,Error12);
                System.out.println("Month with the most invalid qos error: "+ obj.Max());   
                System.out.println("Month with the least invalid qos error: "+ obj.Min());  
                System.out.printf("Average invalid qos error in each month: %.2f ", obj.Average(totalError));
                
                //tabulate the month and number of error in each month
                String title = "Invalid Qos Error";
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
    }
}
