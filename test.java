import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class test{
    public static void main(String [] args) throws IOException{

            Scanner in = new Scanner(new FileReader("extracted_log"));
            PrintWriter out = new PrintWriter(new FileOutputStream("Error.txt"));

            while(in.hasNextLine()) {
                String read = in.nextLine();
                
                String[] array = read.split("[ :]");
                
                for (int i = 0; i < array.length; i ++) {
                    if(array[i].equalsIgnoreCase("error"))
                        out.println(read);
                }
            }
            
            out.close();
            in.close();

            Scanner input = new Scanner(new FileReader("Error.txt"));
            PrintWriter output6 = new PrintWriter(new FileOutputStream("June.txt"));
            PrintWriter output7 = new PrintWriter(new FileOutputStream("July.txt"));
            PrintWriter output8 = new PrintWriter(new FileOutputStream("August.txt"));
            PrintWriter output9 = new PrintWriter(new FileOutputStream("Sept.txt"));
            PrintWriter output10 = new PrintWriter(new FileOutputStream("Oct.txt"));
            PrintWriter output11 = new PrintWriter(new FileOutputStream("Nov.txt"));
            PrintWriter output12 = new PrintWriter(new FileOutputStream("Dec.txt"));

            while(input.hasNextLine()) {
                String reader = input.nextLine();
                //7
               
                if(reader.charAt(7) == '6')
                    output6.println(reader);

                else if(reader.charAt(7) == '7')
                    output7.println(reader);

                else if(reader.charAt(7) == '8')
                    output8.println(reader);
                    
                else if(reader.charAt(7) == '9')
                    output9.println(reader);

                else if(reader.charAt(7) == '0')
                    output10.println(reader);

                else if(reader.charAt(7) == '1')
                    output11.println(reader);

                else if(reader.charAt(7) == '2')
                    output12.println(reader);
                
            }

            input.close();
            output6.close();
            output7.close();
            output8.close();
            output9.close();
            output10.close();
            output11.close();
            output12.close();

            ArrayList<String> list = new ArrayList<String>();
            ArrayList<String> list2 = new ArrayList<String>();
            ArrayList<String> list3 = new ArrayList<String>();
            ArrayList<Object> list4 = new ArrayList<Object>();

            Scanner reader = new Scanner(new FileReader("June.txt"));
            
            while(reader.hasNextLine()) { //user='lobbeytan'
                String [] user = reader.nextLine().split(" ");
                if (user.length >= 6)
                    if (user[5].matches("user=.*"))
                        list.add(user[5]);
                    
            }

            int count = 0;
            while (count<list.size()) {
                list2.add(list.get(count).replaceAll("user='",""));
                list3.add(list2.get(count).replaceAll("[ ',]",""));
                count ++;
            }

            Object [] arr = list3.toArray();
            CheckDuplicate(arr);
            Arrays.sort(arr);
            //System.out.println(Arrays.toString(arr));

            for (int i = 0; i < arr.length; i ++) {
                if (arr[i] != "z")
                    list4.add(arr[i]);
            }

            int [] counting = new int [list4.size()];
            System.out.println(list3);
            for (int i = 0; i < list4.size(); i ++) {
                for (int j = 0; j <list3.size(); j ++) {
                    int num = list3.indexOf(list4.get(i));
                    if (num != -1)
                        list3.remove(num);
                    if (num == -1) {
                        counting[i] = j;
                        break;
                    }
                }
            }
            System.out.println(list3);
            System.out.println(list4);
            System.out.println(Arrays.toString(counting));
            
    }

    public static Object[] CheckDuplicate(Object [] arr) {
        for (int i = 0; i < arr.length; i ++) {
            for (int j = i+1; j < arr.length-1; j ++) {
                if (arr[i].equals(arr[j]) && !arr[i].equals("z"))
                    arr[j] = "z";
        }
    }
        return arr;
    }
}