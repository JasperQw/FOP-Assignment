import java.io.*;
import java.util.*;

public class CPUsType_count extends Type_partition {
    public static void main(String [] args) throws FileNotFoundException {

        System.out.println("For June:");
        getCPUsType('6',"none",true);
        System.out.println();

        System.out.println("For July:");
        getCPUsType('7',"none",true);
        System.out.println();

        System.out.println("For August:");
        getCPUsType('8',"none",true);
        System.out.println();

        System.out.println("For September:");
        getCPUsType('9',"none",true);
        System.out.println();

        System.out.println("For October:");
        getCPUsType('0',"none",true);
        System.out.println();

        System.out.println("For November:");
        getCPUsType('1',"none",true);
        System.out.println();

        System.out.println("For December:");
        getCPUsType('2',"none",true);
        
    }
    

    public static ArrayList<String> CPUs_used(char month, String partition_name) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            String [] array = temp.split(" ");
            if(temp.charAt(7) == month && array.length == 7 && array[6].equals("Partition=" + partition_name) && array[5].matches("#CPUs=.*") && list.indexOf(array[5]) == -1) {
                list.add(array[5]);
        }
    }
    
    return list;
}

    public static Object[] getCPUsType(char month, String part, boolean displayAll) throws FileNotFoundException{
        ArrayList<Integer> listing2 = new ArrayList<Integer>();
        Object[] arr_num = null;
        for(int i = 0; i < Type_partition.Partition_type(month).length; i ++) {
            ArrayList<String> listing = CPUs_used(month, (Partition_type(month)[i]).toString());
            
            for (int j = 0; j < listing.size(); j ++) {
                listing.set(j, listing.get(j).replace("#CPUs=", ""));
                listing2.add(Integer.parseInt(listing.get(j)));
            }
                arr_num = listing2.toArray();
                Arrays.sort(arr_num);
                if ((i == 0 && part.contains("epyc")) || (i == 1 && part.contains("opteron")) || (i == 2 && part.contains("k10") || (i == 3 && part.contains("k40c")) || (i == 4 && part.contains("titan")) || (i == 5 && part.contains("v100s")))) {
                    return arr_num;
                }
                if (displayAll == true)
                    System.out.println("CPUs types for " + Partition_type(month)[i] + ": " + Arrays.toString(arr_num));

                listing2.clear();
        }
        return arr_num;
    }
    
}