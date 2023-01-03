import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class asg {
    public static void main(String [] args) {

        try {
            Scanner in = new Scanner(new FileInputStream("extracted_log"));
            int count_allocate = 0;
            int count_complete = 0;
            int count_cpu_opteron = 0;
            int count_gpu_v100s = 0;
            int count_gpu_k10 = 0;
            int count_gpu_titan = 0;
            int count_gpu_k40c = 0;
            int count_cpu_epyc = 0;
            
            //for checking number of CPUs for opteron
            int count_type_opteron = 0;
            String [] CPUs_opteron = new String [20];
            Arrays.fill(CPUs_opteron, "NO");

            //for checking number of CPUs for v100s
            int count_type_v100s = 0;
            String [] CPUs_v100s = new String [20];
            Arrays.fill(CPUs_v100s, "NO");

            //for checking number of CPUs for k10
            int count_type_k10 = 0;
            String [] CPUs_k10 = new String [20];
            Arrays.fill(CPUs_k10, "NO");

            //for checking number of CPUs for titan
            int count_type_titan = 0;
            String [] CPUs_titan = new String [20];
            Arrays.fill(CPUs_titan, "NO");

            //for checking number of CPUs for k40c
            int count_type_k40c = 0;
            String [] CPUs_k40c = new String [20];
            Arrays.fill(CPUs_k40c, "NO");

            //for checking number of CPUs for epyc
            int count_type_epyc = 0;
            String [] CPUs_epyc = new String [20];
            Arrays.fill(CPUs_epyc, "NO");

            //for checking number of partition type;
            int count_cpu = 0;
            String [] CPU = new String [10]; 
            Arrays.fill(CPU, "NO");
            while(in.hasNextLine()) {
                if(in.nextLine().charAt(7) == '6') {
                    String [] array = in.nextLine().split(" ");
                    if (array.length == 7) {
                        if (array[2].equals("Allocate")) {  //Job allocated
                            System.out.println(Arrays.toString(array));
                            count_allocate ++;
                        }

                        if ((array[6]).matches("Partition=.*")) { //Partition count
                            System.out.println(Arrays.toString(array));

                            if (array[6].equals("Partition=cpu-opteron")) {
                                count_cpu_opteron ++;




                                if (array[5].matches("#CPUs=.*")) {
                                    

                                    boolean found = true;
                                    for (int i = 0; i < count_type_opteron; i ++) {
                                        if (array[5].equals(CPUs_opteron[i])) {
                                            
                                            found = false;
                                            break;
                                        }
                                    }
                                    if (found == true) {
                                    CPUs_opteron[count_type_opteron] = array[5];
                                    count_type_opteron++;
                                    }  
                                } 




                            }

                            else if (array[6].equals("Partition=gpu-v100s")) {
                                count_gpu_v100s ++;


                                if (array[5].matches("#CPUs=.*")) {
                                
                                    boolean found = true;
                                    for (int i = 0; i < count_type_v100s; i ++) {
                                        if (array[5].equals(CPUs_v100s[i])) {
                                            found = false;
                                            break;
                                        }
                                    }
                                    if (found == true) {
                                    CPUs_v100s[count_type_v100s] = array[5];
                                    count_type_v100s++;
                                    }  
                                } 



                            }

                            else if (array[6].equals("Partition=gpu-k10")) {
                                count_gpu_k10 ++;



                                if (array[5].matches("#CPUs=.*")) {

                                    boolean found = true;
                                    for (int i = 0; i < count_type_k10; i ++) {
                                        if (array[5].equals(CPUs_k10[i])) {
                                            found = false;
                                            break;
                                        }
                                    }
                                    if (found == true) {
                                    CPUs_k10[count_type_k10] = array[5];
                                    count_type_k10++;
                                    }  
                                } 



                            }
                            
                            else if (array[6].equals("Partition=gpu-titan")) {
                                count_gpu_titan ++;



                                if (array[5].matches("#CPUs=.*")) {

                                    boolean found = true;
                                    for (int i = 0; i < count_type_titan; i ++) {
                                        if (array[5].equals(CPUs_titan[i])) {
                                            found = false;
                                            break;
                                        }
                                    }
                                    if (found == true) {
                                    CPUs_titan[count_type_titan] = array[5];
                                    count_type_titan++;
                                    }  
                                } 


                                
                            }

                            else if (array[6].equals("Partition=gpu-k40c")) {
                                count_gpu_k40c ++;


                                if (array[5].matches("#CPUs=.*")) {
                                    
                                    boolean found = true;
                                    for (int i = 0; i < count_type_k40c; i ++) {
                                        if (array[5].equals(CPUs_k40c[i])) {
                                            found = false;
                                            break;
                                        }
                                    }
                                    if (found == true) {
                                    CPUs_k40c[count_type_k40c] = array[5];
                                    count_type_k40c++;
                                    }  
                                } 



                            }
                            else if (array[6].equals("Partition=cpu-epyc")) {
                                count_cpu_epyc ++;
                            


                                if (array[5].matches("#CPUs=.*")) {

                                    boolean found = true;
                                    for (int i = 0; i < count_type_epyc; i ++) {
                                        if (array[5].equals(CPUs_epyc[i])) {
                                            found = false;
                                            break;
                                        }
                                    }
                                    if (found == true) {
                                    CPUs_epyc[count_type_epyc] = array[5];
                                    count_type_epyc++;
                                    }  
                                } 



                            }
                        }
                        if ((array[6]).matches("Partition=.*")) { //Type of cpu
                                boolean found = true;
                                for (int i = 0; i < count_cpu; i ++) {
                                    if (array[6].equals(CPU[i])) {
                                        found = false;
                                        break;
                                    }
                                }
                                if (found == true) {
                                CPU[count_cpu] = array[6];
                                count_cpu++;
                                }  
                        }

                    } 

                    if (array.length == 4) {
                        if ((array[1] + " " + array[2] + " " + array[3]).matches("_job_complete: JobId=\\d{5} done")) { //_job_complete:
                            System.out.println(Arrays.toString(array));
                            count_complete ++;
                        }} 
                
                
                }
            }
            System.out.println("Count Allocated jobs: " + count_allocate);
            System.out.println("Count Completed Jobs: " + count_complete);
            System.out.println("Count CPU opteron: " + count_cpu_opteron);
            System.out.println("Count GPU v100s: " + count_gpu_v100s);
            System.out.println("Count GPU k10: " + count_gpu_k10);
            System.out.println("Count GPU titan: " + count_gpu_titan);
            System.out.println("Count GPU k40c: " + count_gpu_k40c);
            System.out.println("Count CPU epyc: " + count_cpu_epyc);

            System.out.println("Count of number of partition used: " + count_cpu);
            System.out.println("Count of CPUs opteron: " + count_type_opteron);
            System.out.println("Count of CPUs v100s: " + count_type_v100s);
            System.out.println("Count of CPUs k10: " + count_type_k10);
            System.out.println("Count of CPUs titan: " + count_type_titan);
            System.out.println("Count of CPUs k40c: " + count_type_k40c);
            System.out.println("Count of CPUs epyc: " + count_type_epyc);
            System.out.println(Arrays.toString(CPUs_opteron));
            System.out.println(Arrays.toString(CPUs_v100s));
            System.out.println(Arrays.toString(CPUs_k10));
            System.out.println(Arrays.toString(CPUs_titan));
            System.out.println(Arrays.toString(CPUs_k40c));
            System.out.println(Arrays.toString(CPUs_epyc));


        }

        catch (FileNotFoundException e) {
                System.out.print("File does not exist!");
        }


    }
}
