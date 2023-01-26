package Errors;
import java.io.*;
import java.util.Scanner;
public class SecurityError {
    public static void main(String[] args) {    
        String keyword = "SECURITY";
        try {
            Scanner sc = new Scanner(new FileInputStream("C:\\Users\\ProUser\\OneDrive\\Documents\\NetBeansProjects\\test\\Error.txt"));
            PrintWriter pw = new PrintWriter(new FileOutputStream("SecurityError.txt"));
          while(sc.hasNextLine()) {
                String read = sc.nextLine();
                    if(read.toLowerCase().indexOf(keyword.toLowerCase()) >= 0)
                        pw.println(read);
               
            }          
            sc.close();
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
