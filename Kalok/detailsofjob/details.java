package detailsofjob;
import java.util.*;

public class details {
    public static void main(String[] args){
    Scanner xx=new Scanner(System.in);
    
    System.out.println("Total jobs completed by months");
    System.out.println("---------Type anything to run---------");   
    String input=xx.nextLine();
    detailsofjobCHART.createAndShowGUI();
    System.out.println();
    
    System.out.println("Total jobs submitted by months");
    System.out.println("---------Type anything to run---------");  
    String input2=xx.nextLine();
    detailsofjobCHART2.createAndShowGUI();
    System.out.println();

    System.out.println("Total jobs allocated by months");
    System.out.println("---------Type anything to run---------");  
    String input3=xx.nextLine();
    detailsofjobCHART3.createAndShowGUI();
    System.out.println();

    System.out.println("The average number of jobs attributes by days");
    System.out.println("---------Type anything to run---------");  
    String input4=xx.nextLine();
    detailsofjobCHART4.createAndShowGUI();
    System.out.println();

    System.out.println("The maximum number of jobs attributes along the months");
    System.out.println("---------Type anything to run---------");  
    String input5=xx.nextLine();
    detailsofjobCHART5.createAndShowGUI();
    System.out.println();

    System.out.println("The minimum number of jobs attributes along the months");
    System.out.println("---------Type anything to run---------");  
    String input6=xx.nextLine();
    detailsofjobCHART6.createAndShowGUI();
    System.out.println();

    System.out.println(" Total Jobs Completed, Allocated & Submitted by Months ");
    System.out.println("---------Type anything to run---------");  
    String input7=xx.nextLine();
    new detailsofjobTABLE();
    System.out.println();
    
    System.out.println(" Total Jobs Completed, Allocated & Submitted by Months ");
    System.out.println("---------Type anything to run---------");  
    String input8=xx.nextLine();
    new detailsofjobTABLE2();
    System.out.println();

    System.out.println("That's all for average time execution visualization");
    }
}