import java.io.*;
import java.util.*;

public class CPUs_count extends Type_partition {
    public static void main(String [] args) throws FileNotFoundException {
        ArrayList<String> listing = new ArrayList<>();
        
        System.out.println("For June:");
        getCPUsType('6',listing);
        System.out.println();

        System.out.println("For July:");
        getCPUsType('7', listing);
        System.out.println();

        System.out.println("For August:");
        getCPUsType('8', listing);
        System.out.println();

        System.out.println("For September:");
        getCPUsType('9', listing);
        System.out.println();

        System.out.println("For October:");
        getCPUsType('0', listing);
        System.out.println();

        System.out.println("For November:");
        getCPUsType('1', listing);
        System.out.println();

        System.out.println("For December:");
        getCPUsType('2', listing);
        System.out.println();
    }
    

    public static ArrayList<String> CPUs_used(char month, String partition_name) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            if(temp.charAt(7) == month) {
                String [] array = temp.split(" ");
                if (array.length == 7) {
                    if ((array[6]).matches("Partition=.*")) {
                        //System.out.println(Arrays.toString(array));

                        if (array[6].equals("Partition=" + partition_name)) {
                            if (array[5].matches("#CPUs=.*")) {
                                if (list.indexOf(array[5]) == -1) {
                                    list.add(array[5]);
                                }
                            } 
                        }                  
                }
                    
            }
        }
    }

    return list;
}

    public static void getCPUsType(char month, ArrayList<String> listing) throws FileNotFoundException{
        for(int i = 0; i < Type_partition.Partition_type(month).size(); i ++) {
            System.out.println("CPUs types for " + Type_partition.Partition_type(month).get(i) + ": " + CPUs_used(month, Type_partition.Partition_type(month).get(i)));
            //listing.add(Arrays.toString(CPUs_used(month, Type_partition.Partition_type(month).get(i)).toArray()));
        }
    }
}