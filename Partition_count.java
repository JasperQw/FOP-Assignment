import java.io.*;
import java.util.*;

public class Partition_count extends Type_partition {
    
    public static void main(String [] args) throws FileNotFoundException {
        System.out.println("For June:");
        count_partition('6', Type_partition.Partition_type('6'));
        System.out.println();
        System.out.println("For July:");
        count_partition('7', Type_partition.Partition_type('6'));
        System.out.println();
        System.out.println("For August:");
        count_partition('8', Type_partition.Partition_type('6'));
        System.out.println();
        System.out.println("For September:");
        count_partition('9', Type_partition.Partition_type('6'));
        System.out.println();
        System.out.println("For October:");
        count_partition('0', Type_partition.Partition_type('6'));
        System.out.println();
        System.out.println("For November:");
        count_partition('1', Type_partition.Partition_type('6'));
        System.out.println();
        System.out.println("For December:");
        count_partition('2', Type_partition.Partition_type('6'));
        System.out.println();
        
    }

    public static void count_partition(char month, Object[] arr) throws FileNotFoundException {
        for (int i = 0; i < arr.length; i++) {
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        int count = 0;
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            String [] array = temp.split(" ");
            if(temp.charAt(7) == month && array.length == 7 && array[6].equals("Partition=" + arr[i].toString())) {
                count ++;
        }
    }
    System.out.println("Number of " + arr[i].toString() + ": " + count);
    }
    
}
}


