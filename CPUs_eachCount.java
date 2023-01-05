import java.util.*;
import java.io.*;

public class CPUs_eachCount extends CPUsType_count {
    public static void main(String [] args) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(new FileOutputStream("CPUs_count.txt", true));

        writer.println("For June: ");
        System.out.println("For June: ");
        count_CPUs('6');
        System.out.println();

        writer.println("For July: ");
        System.out.println("For July: ");
        count_CPUs('7');
        System.out.println();

        writer.println("For August: ");
        System.out.println("For August: ");
        count_CPUs('8');
        System.out.println();

        writer.println("For September: ");
        System.out.println("For September: ");
        count_CPUs('9');
        System.out.println();

        writer.println("For October: ");
        System.out.println("For October: ");
        count_CPUs('0');
        System.out.println();

        writer.println("For November: ");
        System.out.println("For November: ");
        count_CPUs('1');
        System.out.println();

        writer.println("For December: ");
        System.out.println("For December: ");
        count_CPUs('2');
        System.out.println();
        
        writer.close();
    }

    public static void count_CPUs(char month) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new FileOutputStream("CPUs_count.txt", true));

        for (int i = 0; i < Type_partition.Partition_type(month).length ;i ++) {
            String partition_name = Type_partition.Partition_type(month)[i].toString();
            System.out.println("Partition: " + partition_name);
            writer.println("Partition: " + partition_name);
            System.out.println();
            writer.println();
            Object [] arr_num = getCPUsType(month, Type_partition.Partition_type(month)[i].toString(), false);
            System.out.println(Arrays.toString(arr_num));
            writer.println(Arrays.toString(arr_num));
            for (int j = 0; j < arr_num.length; j ++) {
                Scanner in = new Scanner(new FileInputStream("extracted_log"));
                
                int count = 0;
                while(in.hasNextLine()) {
                    String temp = in.nextLine();
                    String [] array = temp.split(" ");
                    if(temp.charAt(7) == month && array.length == 7 && array[5].equals("#CPUs=" + arr_num[j]) && array[6].equals("Partition=" + partition_name)) {
                        count ++;
                    }
                    
                }
                writer.println("Number of CPUs=" + arr_num[j] + " for " + partition_name + ": " + count);
                System.out.println("Number of CPUs=" + arr_num[j] + " for " + partition_name + ": " + count);
            }
            System.out.println();
            writer.println();
        }

        writer.close();
    }
}
