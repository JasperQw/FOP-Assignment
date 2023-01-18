import Data.Table;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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
public class QueueJob {
    public static void main(String[] args) throws Exception {
            String keyword = "Requeuing";
            int total = 0;
            //read the log file and write the line that contain the keyword into a txt.file
            Scanner sc = new Scanner(new FileInputStream("extracted_log"));
            PrintWriter pw = new PrintWriter(new FileOutputStream("Queue Job.txt"));
            while(sc.hasNextLine()) {
                String read = sc.nextLine();
                String []array = read.split(" ");
                    if(array[1].equalsIgnoreCase(keyword)){
                        pw.println(read);
                        total += 1;
                    }
            }          
            System.out.println("The total number of requeuing job in this log file is: " + total);
            sc.close();
            pw.close();    
            
            //find the number of requeuing job occut in each month
            char ch = ' ';         
            Scanner input = new Scanner(new FileInputStream("Queue Job.txt"));
            int M6 = 0,M7 = 0,M8 = 0,M9 = 0,M10 = 0,M11 = 0,M12 = 0;
            while(input.hasNextLine()){
                String read = input.nextLine();
                ch = read.charAt(7);
                if(ch == '6'){
                        M6 += 1; 
                }
                else if(ch == '7'){
                        M7 += 1; 
                }
                else if(ch== '8'){
                        M8 += 1; 
                }
                else if(ch == '9'){
                        M9 += 1; 
                }
                else if(ch == '0'){
                        M10 += 1; 
                }
                else if(ch == '1'){
                        M11 += 1; 
                }
                else if(ch == '2'){
                        M12 += 1; 
                }            
            } 
                System.out.println("The total requeuing job occur in June: " + M6);
                System.out.println("The total requeuing job occur in July: " + M7);
                System.out.println("The total requeuing job occur in August: " + M8);
                System.out.println("The total requeuing job occur in September: " + M9);
                System.out.println("The total requeuing job occur in October: " + M10);
                System.out.println("The total requeuing job occur in November: " + M11);
                System.out.println("The total requeuing job occur in December: " + M12);
                
                //Analysis data
                AnalysisError obj = new AnalysisError(M6,M7,M8,M9,M10,M11,M12);
                System.out.println("Month with the most requeuing job: "+ obj.Max());   
                System.out.println("Month with the least requeuing job: "+ obj.Min());  
                System.out.printf("Average requeuing job in each month: %.2f ", obj.Average(total));

            // find the job id using pattern and matcher       
            Scanner input1 = new Scanner(new FileInputStream("Queue Job.txt"));
            String regex = "JobId=(\\w+)";
            Pattern pattern = Pattern.compile(regex);
            String line; 
            int k = 0;
            String [] JobId= new String[total];
            while (input1.hasNextLine()&& k < total) { 
                line = input1.nextLine();
                Matcher matcher = pattern.matcher(line);
                
                if (matcher.find()) {
                    JobId[k] = matcher.group(1);
                }
                k++; 
            }
            
            //filter out the repeated job id using list, set and hashmap
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
                System.out.println("\n\nJobId         The Number of Requeuing Job by Each JobId");
                System.out.println("---------------------------------------------------");
                for (String job : counts.keySet()) {
                       System.out.printf("%-13s: ",job);
                       System.out.println(counts.get(job));
                }
                System.out.println("---------------------------------------------------");
                System.out.println("The total job id with requeuing job: " + count);
                
                //tabulate the job id and number of requeuing job by each job id
                String[] stringData = counts.keySet().toArray(new String[counts.size()]);
                Integer[] integerData = counts.values().toArray(new Integer[counts.size()]);
                Map.Entry<String,Integer>[] entrySet = counts.entrySet().toArray(new Map.Entry[counts.size()]);
                stringData = new String[entrySet.length];
                integerData = new Integer[entrySet.length];
                for(int c =0;c < entrySet.length; c++){
                        stringData[c] = entrySet[c].getKey();
                        integerData[c] = entrySet[c].getValue();
                }
                Object[][] data3 = new Object[stringData.length][count];
                    for (int j = 0; j < data3.length; j++) {
                         data3[j][0] = stringData[j];
                        for(int h = 1; h < data3.length; h++){
                            data3[j][h] = integerData[j];
                        }
                    }
               //tabulate the job id and number of requeuing job by each job id
                String title3 = "Job Id with number of Requeuing Job";
                String [] columns3 = {"Job Id", "Number of Requeuing Job by each Job Id"};
                Table tb3 = new Table(title3, columns3, data3);
                
                //tabulate month and number of requeuing job
                String title1 = "Requeuing Job";
                String [] columns1 = {"Month", "Number of Requeuing Job"};
                Object data1[][] = {{"June", M6 },
                                   {"July", M7},
                                   {"August",M8},
                                   {"September", M9},
                                   {"October", M10},
                                   {"November", M11},
                                   {"December", M12}
                                    };
                Table tb1 = new Table(title1, columns1,data1);

                    
                //tabulate the attributes of requeuing job and details
                DecimalFormat df = new DecimalFormat("#.00");
                String title2 = "Data Analysis of Requeuing Job";
                String [] columns2 = {"Attributes of Requeuing Job", "Details"};
                Object data2[][] = {{"Total number of requeuing job", total },
                                       {"Month with the highest requeuing job", obj.Max()},
                                       {"Month with the lowest requeuing job",obj.Min()},
                                       {"Average requeuing job among the month", df.format(obj.Average(total))},
                                       {"Total job id with requeuing job",count}
                                       };
                Table tb2 = new Table(title2, columns2,data2);    
                    
              
    }
}
