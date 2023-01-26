package Errors;
import java.util.Scanner;
import java.io.*;
public class InvalidError {
    public static void main(String[] args) {
        String keywords1 = "Invalid";
        String keywords2 = "qos";
        try {
            Scanner sc = new Scanner(new FileInputStream("C:\\Users\\ProUser\\OneDrive\\Documents\\NetBeansProjects\\test\\Error.txt"));
            PrintWriter pw = new PrintWriter(new FileOutputStream("InvalidError.txt"));
            while(sc.hasNextLine()){
                String read = sc.nextLine();
                    if(read.indexOf(keywords1) >= 0 && read.indexOf(keywords2) >= 0)
                        pw.println(read);
                
            }        
            sc.close();
            pw.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
