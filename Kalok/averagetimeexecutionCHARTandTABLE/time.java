package averagetimeexecutionCHARTandTABLE;
import java.util.*;

public class time {
    public static void main(String[] args){
    Scanner xx=new Scanner(System.in);
    
    System.out.println("The average execution time [from jobs allocation to jobs completion] (in Days) ");
    System.out.println("---------Type anything to run---------");   
    String input=xx.nextLine();
    averagetimeexecutionCHART1.createAndShowGUI();
    System.out.println();
    
    System.out.println("The average execution time [from jobs allocation to jobs completion] (in Hours) ");
    System.out.println("---------Type anything to run---------");  
    String input2=xx.nextLine();
    averagetimeexecutionCHART2.createAndShowGUI();
    System.out.println();

    System.out.println("The average execution time [from jobs allocation to jobs completion] (in Minutes) ");
    System.out.println("---------Type anything to run---------");  
    String input3=xx.nextLine();
    averagetimeexecutionCHART3.createAndShowGUI();
    System.out.println();

    System.out.println("The average execution time [from jobs allocation to jobs completion] (in Seconds) ");
    System.out.println("---------Type anything to run---------");  
    String input4=xx.nextLine();
    averagetimeexecutionCHART4.createAndShowGUI();
    System.out.println();

    System.out.println("The total execution time [from jobs allocation to jobs completion] (in Seconds) ");
    System.out.println("---------Type anything to run---------");  
    String input5=xx.nextLine();
    averagetimeexecutionCHART5.createAndShowGUI();
    System.out.println();

    System.out.println("Execution Time [From Jobs Allocated to Jobs Completed]");
    System.out.println("---------Type anything to run---------");  
    String input6=xx.nextLine();
    new averagetimeexecutionTABLE();
    System.out.println();

    System.out.println("That's all for average time execution visualization");
    xx.close();
    }
}