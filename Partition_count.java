import java.io.*;
import java.util.*;

public class Partition_count extends Type_partition {
    
    public static void main(String [] args) throws FileNotFoundException {
        System.out.println("For June:");
        amount_each_partition('6', Type_partition.Partition_type('6'));
        System.out.println();
        System.out.println("For July:");
        amount_each_partition('7', Type_partition.Partition_type('6'));
        System.out.println();
        System.out.println("For August:");
        amount_each_partition('8', Type_partition.Partition_type('6'));
        System.out.println();
        System.out.println("For September:");
        amount_each_partition('9', Type_partition.Partition_type('6'));
        System.out.println();
        System.out.println("For October:");
        amount_each_partition('0', Type_partition.Partition_type('6'));
        System.out.println();
        System.out.println("For November:");
        amount_each_partition('1', Type_partition.Partition_type('6'));
        System.out.println();
        System.out.println("For December:");
        amount_each_partition('2', Type_partition.Partition_type('6'));
        System.out.println();
        
    }

    public static int count_partition(char month, String partition_name) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        int count = 0;
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            
            if(temp.charAt(7) == month) {
                String [] array = temp.split(" ");
                if (array.length == 7) {
                    if ((array[6]).matches("Partition=.*")) {
                        //System.out.println(Arrays.toString(array));

                        if (array[6].equals("Partition=" + partition_name)) {
                            count ++;
                        }                  
                }
            }
        }
    }
        return count;
    }

    public static void amount_each_partition(char month, ArrayList<String> list) throws FileNotFoundException {
        Object [] arr = list.toArray();

        for(int i = 0; i < arr.length; i ++) {
            System.out.println("Number of " + arr[i].toString() + ": " + count_partition(month, arr[i].toString()));
        }


    }
}


