import java.io.*;
import java.util.*;

public class CPUs_count extends Type_partition {
    public static void main(String [] args) throws FileNotFoundException {
        
        System.out.println("For June:");
        CPUs_used('6');
        System.out.println();

        System.out.println("For July:");
        CPUs_used('7');
        System.out.println();

        System.out.println("For August:");
        CPUs_used('8');
        System.out.println();

        System.out.println("For September:");
        CPUs_used('9');
        System.out.println();

        System.out.println("For October:");
        CPUs_used('0');
        System.out.println();

        System.out.println("For November:");
        CPUs_used('1');
        System.out.println();

        System.out.println("For December:");
        CPUs_used('2');
        System.out.println();
    }
    

    public static void CPUs_used(char month) throws FileNotFoundException {
        for (int i = 0; i < Type_partition.Partition_type(month).length; i ++) {
            ArrayList<String> list = new ArrayList<>();
            Scanner in = new Scanner(new FileInputStream("extracted_log"));
            while(in.hasNextLine()) {
                String temp = in.nextLine();
                String [] array = temp.split(" ");
                if(temp.charAt(7) == month && array.length == 7 && (array[6]).matches("Partition=.*") && array[6].equals("Partition=" + Type_partition.Partition_type('6')[i]) && array[5].matches("#CPUs=.*") && list.indexOf(array[5]) == -1) {
                    list.add(array[5]);
            }
        }
        System.out.println("CPUs types for " + Type_partition.Partition_type(month)[i] + ": " + list);
    }
        
     /*    ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            String [] array = temp.split(" ");
            if(temp.charAt(7) == month && array.length == 7 && (array[6]).matches("Partition=.*") && array[6].equals("Partition=" + partition_name) && array[5].matches("#CPUs=.*") && list.indexOf(array[5]) == -1) {
                list.add(array[5]);
        }
    }
    Object arr[] = list.toArray();
    Arrays.sort(arr);
    return list;
}

    public static void CPUs_used(char month, ArrayList<String> listing) throws FileNotFoundException{
        for(int i = 0; i < Type_partition.Partition_type(month).length; i ++) {
            System.out.println("CPUs types for " + Type_partition.Partition_type(month)[i] + ": " + CPUs_used(month, Type_partition.Partition_type(month)[i].toString()));
            //listing.add(Arrays.toString(CPUs_used(month, Type_partition.Partition_type(month).get(i)).toArray()));
        }
    } */
}
}