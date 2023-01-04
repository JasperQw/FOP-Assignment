import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class chingwei{
    public static void main(String [] args) throws FileNotFoundException {

            Scanner in = new Scanner(new FileInputStream("extracted_log"));
            
            //for checking number of CPUs for opteron
            ArrayList<String> CPUs_opteron = new ArrayList<String>();
            
            //for checking number of CPUs for v100s
            ArrayList<String> CPUs_v100s = new ArrayList<String>();

            //for checking number of CPUs for k10
            ArrayList<String> CPUs_k10 = new ArrayList<String>();

            //for checking number of CPUs for titan
            ArrayList<String> CPUs_titan = new ArrayList<String>();

            //for checking number of CPUs for k40c
            ArrayList<String> CPUs_k40c = new ArrayList<String>();

            //for checking number of CPUs for epyc
            ArrayList<String> CPUs_epyc = new ArrayList<String>();

            //for checking number of partition type;
            int count_cpu = 0;
            String [] CPU = new String [10]; 
            Arrays.fill(CPU, "NO");
            while(in.hasNextLine()) {
                if(in.nextLine().charAt(7) == '6') {
                    String [] array = in.nextLine().split(" ");
                    if (array.length == 7) {

                        if ((array[6]).matches("Partition=.*")) { //Partition count
                            System.out.println(Arrays.toString(array));

                            if (array[6].equals("Partition=cpu-opteron")) {
                                




                                if (array[5].matches("#CPUs=.*")) {
                                    if (CPUs_opteron.indexOf(array[5]) == -1) {
                                        CPUs_opteron.add(array[5]);
                                    }
                                } 




                            }

                            else if (array[6].equals("Partition=gpu-v100s")) {
                                


                                if (array[5].matches("#CPUs=.*")) {
                                    if (CPUs_v100s.indexOf(array[5]) == -1) {
                                        CPUs_v100s.add(array[5]);
                                    }
                                } 



                            }

                            else if (array[6].equals("Partition=gpu-k10")) {
                                



                                if (array[5].matches("#CPUs=.*")) {
                                    if (CPUs_k10.indexOf(array[5]) == -1) {
                                        CPUs_k10.add(array[5]);
                                    }
                                } 



                            }
                            
                            else if (array[6].equals("Partition=gpu-titan")) {
                                



                                if (array[5].matches("#CPUs=.*")) {
                                    if (CPUs_titan.indexOf(array[5]) == -1) {
                                        CPUs_titan.add(array[5]);
                                    }
                                } 


                                
                            }

                            else if (array[6].equals("Partition=gpu-k40c")) {
                                


                                if (array[5].matches("#CPUs=.*")) {
                                    if (CPUs_k40c.indexOf(array[5]) == -1) {
                                        CPUs_k40c.add(array[5]);
                                    }
                                } 



                            }
                            else if (array[6].equals("Partition=cpu-epyc")) {
                                
                            


                                if (array[5].matches("#CPUs=.*")) {
                                    if (CPUs_epyc.indexOf(array[5]) == -1) {
                                        CPUs_epyc.add(array[5]);
                                    }
                                } 



                            }
                        }
                        

                    } 

                }
            }


            System.out.println("Count of number of partition used: " + count_cpu);
            System.out.println("Count of CPUs opteron: " + CPUs_opteron.size());
            System.out.println("Count of CPUs v100s: " + CPUs_v100s.size());
            System.out.println("Count of CPUs k10: " + CPUs_k10.size());
            System.out.println("Count of CPUs titan: " + CPUs_titan.size());
            System.out.println("Count of CPUs k40c: " + CPUs_k40c.size());
            System.out.println("Count of CPUs epyc: " + CPUs_epyc.size());
            System.out.println(CPUs_opteron);
            System.out.println(CPUs_v100s);
            System.out.println(CPUs_k10);
            System.out.println(CPUs_titan);
            System.out.println(CPUs_k40c);
            System.out.println(CPUs_epyc);



    }

    
}
