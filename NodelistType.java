import java.io.*;
import java.util.*;

public class NodelistType extends Type_partition {
    public static void main(String [] args) throws FileNotFoundException {

        System.out.println("For June:");
        getNodelistType('6',"none",true);
        System.out.println();

        System.out.println("For July:");
        getNodelistType('7',"none",true);
        System.out.println();

        System.out.println("For August:");
        getNodelistType('8',"none",true);
        System.out.println();

        System.out.println("For September:");
        getNodelistType('9',"none",true);
        System.out.println();

        System.out.println("For October:");
        getNodelistType('0',"none",true);
        System.out.println();

        System.out.println("For November:");
        getNodelistType('1',"none",true);
        System.out.println();

        System.out.println("For December:");
        getNodelistType('2',"none",true);
        
    }
    

    public static ArrayList<String> Nodelist_used(char month, String partition_name) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            String [] array = temp.split(" ");
            if(temp.charAt(7) == month && array.length == 7 && array[6].equals("Partition=" + partition_name) && array[4].matches("NodeList=.*") && list.indexOf(array[4]) == -1) {
                list.add(array[4]);
        }
    }
    
    return list;
}

    public static Object[] getNodelistType(char month, String part, boolean displayAll) throws FileNotFoundException{
        Object[] arr_nodelis = null;
        for(int i = 0; i < Type_partition.Partition_type(month).length; i ++) {
            ArrayList<String> listing = Nodelist_used(month, (Partition_type(month)[i]).toString());
            
            for (int j = 0; j < listing.size(); j ++) {
                listing.set(j, listing.get(j).replace("NodeList=", ""));
                
            }
                arr_nodelis = listing.toArray();
                Arrays.sort(arr_nodelis);
                if ((i == 0 && part.contains("epyc")) || (i == 1 && part.contains("opteron")) || (i == 2 && part.contains("k10") || (i == 3 && part.contains("k40c")) || (i == 4 && part.contains("titan")) || (i == 5 && part.contains("v100s")))) {
                    return arr_nodelis;
                }
                if (displayAll == true)
                    System.out.println("NodeList types for " + Partition_type(month)[i] + ": " + Arrays.toString(arr_nodelis));

                listing.clear();
        }
        return arr_nodelis;
    }
    
}