import java.io.*;
import java.util.Scanner;

public class Code_that_extracting_Error_into_txt{
    public static void main(String [] args) throws IOException{

            Scanner in = new Scanner(new FileReader("extracted_log"));
            PrintWriter out = new PrintWriter(new FileOutputStream("Error.txt"));

            while(in.hasNextLine()) {
                String read = in.nextLine();
                
                String[] array = read.split("[ :]");
                
                for (int i = 0; i < array.length; i ++) {
                    if(array[i].equalsIgnoreCase("error"))
                        out.println(read);
                }
            }
            
            out.close();
            in.close();

            Scanner input = new Scanner(new FileReader("Error.txt"));
            PrintWriter output6 = new PrintWriter(new FileOutputStream("June.txt"));
            PrintWriter output7 = new PrintWriter(new FileOutputStream("July.txt"));
            PrintWriter output8 = new PrintWriter(new FileOutputStream("August.txt"));
            PrintWriter output9 = new PrintWriter(new FileOutputStream("Sept.txt"));
            PrintWriter output10 = new PrintWriter(new FileOutputStream("Oct.txt"));
            PrintWriter output11 = new PrintWriter(new FileOutputStream("Nov.txt"));
            PrintWriter output12 = new PrintWriter(new FileOutputStream("Dec.txt"));

            while(input.hasNextLine()) {
                String reader = input.nextLine();
                //7
               
                if(reader.charAt(7) == '6')
                    output6.println(reader);

                else if(reader.charAt(7) == '7')
                    output7.println(reader);

                else if(reader.charAt(7) == '8')
                    output8.println(reader);
                    
                else if(reader.charAt(7) == '9')
                    output9.println(reader);

                else if(reader.charAt(7) == '0')
                    output10.println(reader);

                else if(reader.charAt(7) == '1')
                    output11.println(reader);

                else if(reader.charAt(7) == '2')
                    output12.println(reader);
                
            }

            input.close();
            output6.close();
            output7.close();
            output8.close();
            output9.close();
            output10.close();
            output11.close();
            output12.close();

            
            
    }

    
}