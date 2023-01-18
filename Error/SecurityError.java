import Data.Table;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SecurityError {
    public static void main(String[] args) throws Exception {    
            String keyword1 = "SECURITY";
            String keyword2 = "JobId";
            int totalError = 0;
            //read the log file and write the line that contain the keyword into a txt.file
            Scanner sc = new Scanner(new FileInputStream("C:\\Users\\ProUser\\Downloads\\extracted_log"));
            PrintWriter pw = new PrintWriter(new FileOutputStream("SecurityError.txt"));
            while(sc.hasNextLine()) {
                String read = sc.nextLine();
                    if(read.toLowerCase().indexOf(keyword1.toLowerCase()) >= 0 && read.toLowerCase().indexOf(keyword2.toLowerCase()) >= 0){
                        pw.println(read);
                        totalError += 1;
                    }
            }          
            System.out.println("The total security violation error in this log file is: " + totalError);
            sc.close();
            pw.close();

            //find the error occur in each month
            char ch = ' ';         
            Scanner input = new Scanner(new FileInputStream("SecurityError.txt"));       
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
                System.out.println("The total security violation error occur in June: " + Error6);
                System.out.println("The total security violation error occur in July: " + Error7);
                System.out.println("The total security violation error occur in August: " + Error8);
                System.out.println("The total security violation error occur in September: " + Error9);
                System.out.println("The total security violation error occur in October: " + Error10);
                System.out.println("The total security violation error occur in November: " + Error11);
                System.out.println("The total security violation error occur in December: " + Error12);

                //analysis the data
                AnalysisError obj = new AnalysisError(Error6,Error7,Error8,Error9,Error10,Error11,Error12);
                System.out.println("Month with the most security violation error: "+ obj.Max());   
                System.out.println("Month with the least security violation error: "+ obj.Min());  
                System.out.printf("Average security violation error in each month: %.2f ", obj.Average(totalError));
                
                //tabulate the month and number of error
                String title1 = "Security Violation Error";
                String [] columns1 = {"Month", "Number of Error"};
                Object data1[][] = {{"June", Error6 },
                                   {"July", Error7},
                                   {"August",Error8},
                                   {"September", Error9},
                                   {"October", Error10},
                                   {"November", Error11},
                                   {"December", Error12}
                                    };
                Table tb1 = new Table(title1, columns1,data1);

            //find the job id using pattern and matcher
            Scanner input1 = new Scanner(new FileInputStream("SecurityError.txt"));
            String regex = "JobId=(\\w+)";
            Pattern pattern = Pattern.compile(regex);
            String line; 
            int i = 0;
            String [] JobId= new String[totalError];
            while (input1.hasNextLine()&& i < totalError) { 
                line = input1.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    JobId[i] = matcher.group(1);
                }
                i++; 
            }
            
            //filter out the repeated job id using set,list and hashmap
            List<String> ID = Arrays.asList(JobId);
            Set<String> printedID = new HashSet<>();
            int count = 0;
            for (String job_id : ID) {
                if (!printedID.contains(job_id)) {
                     printedID.add(job_id);
                     count++;
                }
            }
            HashMap<String, Integer> counts = new HashMap<>();
                for (String job : JobId) {
                    if (counts.containsKey(job)) {
                            counts.put(job, counts.get(job) + 1);
                    } 
                    else {
                            counts.put(job, 1);
                    }
                }
                System.out.println("\n\nJobId         The Number of Error Made by Each JobId");
                System.out.println("---------------------------------------------------");
                for (String job : counts.keySet()) {
                       System.out.printf("%-13s: ",job);
                       System.out.println(counts.get(job));
                }
                System.out.println("---------------------------------------------------");
                System.out.println("The total job id with security violation error: " + count); 
                
                //tabulate the job id and number of job id occur
                String[] stringData = counts.keySet().toArray(new String[counts.size()]);
                Integer[] integerData = counts.values().toArray(new Integer[counts.size()]);
                Map.Entry<String,Integer>[] entrySet = counts.entrySet().toArray(new Map.Entry[counts.size()]);
                stringData = new String[entrySet.length];
                integerData = new Integer[entrySet.length];
                for(int c =0;c < entrySet.length; c++){
                        stringData[c] = entrySet[c].getKey();
                        integerData[c] = entrySet[c].getValue();
                }
                Object[][] data = new Object[stringData.length][count];
                    for (int j = 0; j < data.length; j++) {
                         data[j][0] = stringData[j];
                        for(int h = 1; h < data.length; h++){
                            data[j][h] = integerData[j];
                        }
                    }
                String title2 = "Job Id with number of security violation error";
                String [] columns2 = {"Job Id", "Number of Error"};
                Table tb2 = new Table(title2, columns2, data);
                
                //tabulate the attributes of error and details
                DecimalFormat df = new DecimalFormat("#.00");
                String title3 = "Data Analysis of Security Violation Error";
                String [] columns3 = {"Attributes of Error", "Details"};
                Object data3[][] = {{"Total error", totalError },
                                       {"Month with the highest error", obj.Max()},
                                       {"Month with the lowest error",obj.Min()},
                                       {"Average error among the month", df.format(obj.Average(totalError))},
                                       {"Total job id with security error",count}
                                       };
                    Table tb3 = new Table(title3, columns3,data3);    
    }
}
