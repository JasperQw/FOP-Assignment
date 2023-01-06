import java.util.*;
import java.io.*;

public class NodeList_eachCount extends NodelistType {
    public static void main(String [] args) throws FileNotFoundException{
        
        System.out.println("For June: ");
        count_NodeList('6');
        System.out.println();

        System.out.println("For July: ");
        count_NodeList('7');
        System.out.println();

        System.out.println("For August: ");
        count_NodeList('8');
        System.out.println();

        System.out.println("For September: ");
        count_NodeList('9');
        System.out.println();

        System.out.println("For October: ");
        count_NodeList('0');
        System.out.println();

        System.out.println("For November: ");
        count_NodeList('1');
        System.out.println();

        System.out.println("For December: ");
        count_NodeList('2');
        System.out.println();
        
    }

    public static void count_NodeList(char month) throws FileNotFoundException {

        for (int i = 0; i < Type_partition.Partition_type(month).length ;i ++) {
            String partition_name = Type_partition.Partition_type(month)[i].toString();
            System.out.println("Partition: " + partition_name);
            System.out.println();
            Object [] arr_nodelis = getNodelistType(month, Type_partition.Partition_type(month)[i].toString(), false);
            System.out.println(Arrays.toString(arr_nodelis));
            for (int j = 0; j < arr_nodelis.length; j ++) {
                Scanner in = new Scanner(new FileInputStream("extracted_log"));
                
                int count = 0;
                while(in.hasNextLine()) {
                    String temp = in.nextLine();
                    String [] array = temp.split(" ");
                    if(temp.charAt(7) == month && array.length == 7 && array[4].equals("NodeList=" + arr_nodelis[j]) && array[6].equals("Partition=" + partition_name)) {
                        count ++;
                    }
                    
                }
                System.out.println("Number of NodeList=" + arr_nodelis[j] + " for " + partition_name + ": " + count);
            }
            System.out.println();
        }
    }
}
