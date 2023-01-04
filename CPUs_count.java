import java.io.*;
import java.util.*;

public class CPUs_count {
    public static void main(String [] args) throws FileNotFoundException {
        System.out.println(CPUs_used('6'));
    }
    

    public static ArrayList<String> CPUs_used(char month) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(new FileInputStream("extracted_log"));
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            if(temp.charAt(7) == month) {
                String [] array = temp.split(" ");
                if (array.length == 7) {
                    if (array[5].matches("#CPUs=.*")) {
                        if (list.indexOf(array[5]) == -1) {
                            list.add(array[5]);
                        }
                    } 
            }
        }
    }

    return list;
}
}