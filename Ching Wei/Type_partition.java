import java.io.*;
import java.util.*;

public class Type_partition {
    
    public static void main(String [] args) throws FileNotFoundException {
        System.out.println("Number partition type in June: " + Partition_type('6').length);
        System.out.println("Partition type: " + Arrays.toString(Partition_type('6')) + "\n");
        System.out.println("Number partition type in July: " + Partition_type('7').length);
        System.out.println("Partition type: " + Arrays.toString(Partition_type('7')) + "\n");
        System.out.println("Number partition type in August: " + Partition_type('8').length);
        System.out.println("Partition type: " + Arrays.toString(Partition_type('8')) + "\n");
        System.out.println("Number partition type in September: " + Partition_type('9').length);
        System.out.println("Partition type: " + Arrays.toString(Partition_type('9')) + "\n");
        System.out.println("Number partition type in October: " + Partition_type('0').length);
        System.out.println("Partition type: " + Arrays.toString(Partition_type('0')) + "\n");
        System.out.println("Number partition type in November: " + Partition_type('1').length);
        System.out.println("Partition type: " + Arrays.toString(Partition_type('1')) + "\n");
        System.out.println("Number partition type in December: " + Partition_type('2').length);
        System.out.println("Partition type: " + Arrays.toString(Partition_type('2')) + "\n");
    }

    public static Object[] Partition_type(char month) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        ArrayList<String> list_partition_type = new ArrayList<>();
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            String [] array = temp.split(" ");
            if(temp.charAt(7) == month && array.length == 7 && (array[6]).matches("Partition=.*") 
                && list_partition_type.indexOf(array[6]) == -1) {
                    
                list_partition_type.add(array[6]);
        }
    }
    for (int i = 0; i < list_partition_type.size(); i ++) {
        list_partition_type.set(i, list_partition_type.get(i).replace("Partition=", ""));
    }
    Object arr [] = list_partition_type.toArray();
    Arrays.sort(arr);

        return arr;
    }
}

