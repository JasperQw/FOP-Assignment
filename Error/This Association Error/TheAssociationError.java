import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
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

public class TheAssociationError {

    public static void main(String[] args) throws Exception {
        
            Scanner content=new Scanner(new FileInputStream("Error.txt"));
            PrintWriter print=new PrintWriter(new FileOutputStream("This Association Error.txt"));
            String input="This association";
            int count=0;
            
            int June = 0;
            int July=0;
            int Aug=0;
            int Sep=0;
            int Oct=0;
            int Nov=0;
            int Dec=0;
            
            int[] qoslong=new int[7];
            int[] qosnormal=new int[7];
            int [] qos= new int[2];
            
            while(content.hasNextLine()){    
                String temp=content.nextLine();
                    if(temp.contains(input)){
                        count++;
                            print.write(temp);
                            print.println();    
                                if(temp.contains("2022-06"))
                                    June++;
                                    if(temp.contains("2022-06")&&temp.contains("qos long")){
                                        qoslong[0]++;
                                    }
                                    else if(temp.contains("2022-06")&&temp.contains("qos normal")){
                                        qosnormal[0]++;
                                    }
                                    
                                if(temp.contains("2022-07"))
                                    July++;   
                                    if(temp.contains("2022-07")&&temp.contains("qos long")){
                                        qoslong[1]++;
                                    }
                                    else if(temp.contains("2022-07")&&temp.contains("qos normal")){
                                        qosnormal[1]++;
                                    }
                                    
                                if(temp.contains("2022-08"))
                                    Aug++;
                                     if(temp.contains("2022-08")&&temp.contains("qos long")){
                                        qoslong[2]++;
                                    }
                                    else if(temp.contains("2022-08")&&temp.contains("qos normal")){
                                        qosnormal[2]++;
                                    }
                                    
                                if(temp.contains("2022-09"))
                                    Sep++;
                                    if(temp.contains("2022-09")&&temp.contains("qos long")){
                                        qoslong[3]++;
                                    }
                                    else if(temp.contains("2022-09")&&temp.contains("qos normal")){
                                        qosnormal[3]++;
                                    }
                                    
                                if(temp.contains("2022-10"))
                                    Oct++;
                                     if(temp.contains("2022-10")&&temp.contains("qos long")){
                                        qoslong[4]++;
                                    }
                                    else if(temp.contains("2022-10")&&temp.contains("qos normal")){
                                        qosnormal[4]++;
                                    }
                                    
                                if(temp.contains("2022-11"))
                                    Nov++;
                                    if(temp.contains("2022-11")&&temp.contains("qos long")){
                                        qoslong[5]++;
                                    }
                                    else if(temp.contains("2022-11")&& temp.contains("qos normal")){
                                        qosnormal[5]++;
                                    }
                                    
                                if(temp.contains("2022-12"))
                                    Dec++;
                                     if(temp.contains("2022-12")&&temp.contains("qos long")){
                                        qoslong[6]++;
                                    }
                                    else if(temp.contains("2022-12")&&temp.contains("qos normal")){
                                        qosnormal[6]++;
                                    }

                                if(temp.contains("long"))
                                    qos[0]++;
                                    
                                
                                if(temp.contains("normal"))
                                    qos[1]++;
                    }

            }
                    System.out.println("This association error occurs in June: "+June);
                    System.out.println("This association error occurs in July: "+July);
                    System.out.println("This association error occurs in August: "+Aug);
                    System.out.println("This association error occurs in September: "+Sep);
                    System.out.println("This association error occurs in October: "+Oct);
                    System.out.println("This association error occurs in November: "+Nov);
                    System.out.println("This association error occurs in December: "+Dec);
                    
                    if(count!=0){
                        System.out.println("\nTotal number of This association error in the log file: "+count);
                
                    AnalysisError calc = new AnalysisError(June, July, Aug, Sep, Oct, Nov, Dec);
                        System.out.println();
                        System.out.println("Month with the most This association error: "+calc.Max());
                        System.out.println("Month with the least This association error: "+calc.Min());
                        System.out.printf("Average number of This association error: %.2f",calc.Average(count));
                        
                    System.out.println();
                    System.out.println("\nThis association does not have access to qos long: "+qos[0]);
                    System.out.println("This association does not have access to qos normal: "+qos[1]);
                    
                    System.out.println("\n\nqos long");
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("The total number for \nThis association does not have access to qos long:\n in June : " +qoslong[0]);
                    System.out.println("\nThe total number for \nThis association does not have access to qos long:\n in July : " +qoslong[1]);
                    System.out.println("\nThe total number for \nThis association does not have access to qos long:\n in August : " +qoslong[2]);
                    System.out.println("\nThe total number for \nThis association does not have access to qos long:\n in September : " +qoslong[3]);
                    System.out.println("\nThe total number for \nThis association does not have access to qos long:\n in October : " +qoslong[4]);
                    System.out.println("\nThe total number for \nThis association does not have access to qos long:\n in November : " +qoslong[5]);
                    System.out.println("\nThe total number for \nThis association does not have access to qos long:\n in December : " +qoslong[6]);
                    
                    System.out.println("\n\nqos normal");
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("The total number for \nThis association does not have access to qos normal:\n in June : " +qosnormal[0]);
                    System.out.println("\nThe total number for \nThis association does not have access to qos normal:\n in July : " +qosnormal[1]);
                    System.out.println("\nThe total number for \nThis association does not have access to qos normal:\n in August : " +qosnormal[2]);
                    System.out.println("\nThe total number for \nThis association does not have access to qos normal:\n in September : " +qosnormal[3]);
                    System.out.println("\nThe total number for \nThis association does not have access to qos normal:\n in October : " +qosnormal[4]);
                    System.out.println("\nThe total number for \nThis association does not have access to qos normal:\n in November : " +qosnormal[5]);
                    System.out.println("\nThe total number for \nThis association does not have access to qos normal:\n in December : " +qosnormal[6]);
                    
                    //tabulate month, number of errors 
                    String title1 = "This Association Error";
                    String [] columns1 = {"Month", "Number of Errors"};
                    Object data1[][] = {{"June", June},
                                       {"July", July},
                                       {"August", Aug},
                                       {"September", Sep},
                                       {"October", Oct},
                                       {"November", Nov},
                                       {"December", Dec}
                                       };
                    
                    Table tb = new Table(title1, columns1,data1);
                    
                    //tabulate month, number of errors that does not have access to qos long
                    String title2 = "This association error that does not have access to qos long";
                    String [] columns2 = {"Month", "Number of errors that does not have access to qos long"};
                    Object data2[][] = {{"June",qoslong[0]},
                                       {"July", qoslong[1]},
                                       {"August",qoslong[2]},
                                       {"September",qoslong[3]},
                                       {"October",qoslong[4]},
                                       {"November",qoslong[5]},
                                       {"December",qoslong[6]}
                                       };
                    
                    Table ab = new Table(title2, columns2,data2);
                    
                    //tabulate month, number of errors that does not have access to qos normal
                    String title3 = "This association error that does not have access to qos normal";
                    String [] columns3 = {"Month", "Number of errors that does not have access to qos normal"};
                    Object data3[][] = {{"June",qosnormal[0]},
                                       {"July", qosnormal[1]},
                                       {"August",qosnormal[2]},
                                       {"September",qosnormal[3]},
                                       {"October",qosnormal[4]},
                                       {"November",qosnormal[5]},
                                       {"December",qosnormal[6]}
                                       };
                    
                    Table cd = new Table(title3, columns3,data3);
            }
            content.close();
            print.close();     
            
        //find users' names using pattern and matcher    
        String regex = "user='(\\w+)";

        Pattern pattern = Pattern.compile(regex);
        Scanner sc = new Scanner(new FileReader("This Association Error.txt"));
            String line; 
            int i = 0;
            String [] username = new String[count];
            while (sc.hasNextLine()&& i < count) { 
                line = sc.nextLine();
                Matcher matcher = pattern.matcher(line);
                
                if (matcher.find()) {
                    username[i] = matcher.group(1);
                }
                i++; 
            }
            
            //filter out the repeated users' names using set, list and hashmap
            List<String> names = Arrays.asList(username);
            Set<String> printedNames = new HashSet<>();
            int count1 = 0;
            for (String name : names) {
                if (!printedNames.contains(name)) {
                     printedNames.add(name);
                     count1++;
                }
                
            }
            HashMap<String, Integer> counts = new HashMap<>();
                for (String person : username) {
                    if (counts.containsKey(person)) {
                            counts.put(person, counts.get(person) + 1);
                    } 
                    else {
                            counts.put(person, 1);
                    }
                }
                System.out.println("\n\nUser         Number of Errors Made by Each User");
                System.out.println("---------------------------------------------------");
                for (String person : counts.keySet()) {
                       System.out.printf("%-13s: ",person);
                       System.out.println(counts.get(person));  
                }
                
                //tabulate the users'names and number of errors made
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
                
                System.out.println("---------------------------------------------------");
                System.out.println("The total number of users with This association error: " + count1);
                
                String title = "Users and Number of This Association Errors made";
                   String [] columns = {"Users", "Number of Errors"};
                    
                    Table tb = new Table(title, columns,data);
                    
                    AnalysisError calc = new AnalysisError(June, July, Aug, Sep, Oct, Nov, Dec);
                    
                    DecimalFormat df = new DecimalFormat("#.00");
                    String title5 = "Data Analysis of This Association Error ";
                    String [] columns5 = {"Attributes of Error", "Details"};
                    Object data5[][] = {{"Total number of This association error ",count},
                                       {"Month with the most This association error", calc.Max()},
                                       {"Month with the least This association error",calc.Min()},
                                       {"Average number of This association error ",df.format(calc.Average(count))},
                                       {"Total number of This association error that does not have access to qos long",qos[0]},
                                       {"Total number of This association error that does not have access to qos normal",qos[1]},
                                       {"Total number of users who make This association error",count1}
                                       };
                    
                    Table all = new Table(title5,columns5,data5);
                
                //Tabulate the users' names and number of errors made    
                ThisAssociationErrorMonth errorMonth6 = new ThisAssociationErrorMonth(6);
                ThisAssociationErrorMonth errorMonth8 = new ThisAssociationErrorMonth(8);
                ThisAssociationErrorMonth errorMonth9 = new ThisAssociationErrorMonth(9);
                ThisAssociationErrorMonth errorMonth10 = new ThisAssociationErrorMonth(10);
                ThisAssociationErrorMonth errorMonth11 = new ThisAssociationErrorMonth(11);
    }
}
