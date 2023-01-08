package pkgthis.association.error;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThisAssociationError {

    public static void main(String[] args) throws FileNotFoundException {
        try{
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

            int [] qos= new int[2];
            
            while(content.hasNextLine()){    
                String temp=content.nextLine();
                    if(temp.contains(input)){
                        count++;
                            print.write(temp);
                            print.println();    
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
                        System.out.println("\nTotal This association error in the log file: "+count);
                
                    AnalysisError calc = new AnalysisError(June, July, Aug, Sep, Oct, Nov, Dec);
                        System.out.println();
                        calc.Max();
                        calc.Min();
                        calc.Average();
                    
                    System.out.println();
                    System.out.println("\nThis association does not have access to qos long: "+qos[0]);
                    System.out.println("This association does not have access to qos normal: "+qos[1]);
                    
            
            }
            content.close();
            print.close();     
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
        String regex = "user='(\\w+)";

        Pattern pattern = Pattern.compile(regex);
        try (Scanner sc = new Scanner(new FileReader("This Association Error.txt"))) {
            String line; 
            int i = 0;
            String [] username = new String[143];
            while (sc.hasNextLine()&& i < 143) { 
                line = sc.nextLine();
                Matcher matcher = pattern.matcher(line);
                
                if (matcher.find()) {
                    username[i] = matcher.group(1);
                }
                i++; 
            }
            List<String> names = Arrays.asList(username);
            Set<String> printedNames = new HashSet<>();
            int count = 0;
            for (String name : names) {
                if (!printedNames.contains(name)) {
                     printedNames.add(name);
                     count++;
                }
                
            }
            System.out.println("\nThe total users with This association error: " + count);
            HashMap<String, Integer> counts = new HashMap<>();
                for (String person : username) {
                    if (counts.containsKey(person)) {
                            counts.put(person, counts.get(person) + 1);
                    } 
                    else {
                            counts.put(person, 1);
                    }
                }
                for (String person : counts.keySet()) {
                        System.out.println(person + ": " + counts.get(person));
                }
 
            
        } catch (FileNotFoundException ex) {
                System.out.println("Error: " + ex);
        }catch (IOException ex) {
                System.out.println("Error: " + ex);
        }
    
    }
}
  
        
        