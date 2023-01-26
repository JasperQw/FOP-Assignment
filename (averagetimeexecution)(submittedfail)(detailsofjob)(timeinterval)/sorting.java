import java.io.*;
import java.util.*;

public class sorting {
    static int counter = 0;
    public static void main(String[] args)throws Exception{
        sort(6);
        sort(7);
        sort(8);
        sort(9);
        sort(10);
        sort(11);
        sort(12);
    }

    
    public static void sort(int a) throws IOException {
        Scanner input1 = new Scanner(new FileReader("jobscompletedfull.txt"));
        Scanner input2 = new Scanner(new FileReader("jobsallocatedfull.txt"));
        Scanner input3 = new Scanner(new FileReader("jobssubmittedfull.txt"));
        ArrayList<String> completed_Job = new ArrayList<>();
        ArrayList<String> allocated_Job = new ArrayList<>();
        ArrayList<String> submitted_Job = new ArrayList<>();

        ArrayList<String> completed_JobId = new ArrayList<>();
        ArrayList<String> allocated_JobId = new ArrayList<>();
        ArrayList<String> submitted_JobId = new ArrayList<>();
        
        while(input1.hasNextLine()) {
            String temp = input1.nextLine();
            String [] splited_temp = temp.split(" ");
            if (temp.substring(6,8).contains(Integer.toString(a))) {
            completed_JobId.add(splited_temp[2].replace("JobId=","")); //only contain JobId
            completed_Job.add(splited_temp[2] + " 3completed " + splited_temp[0]);} //contain JobId, and time, ease the sorting process
        }

        while(input2.hasNextLine()) {
            String temp = input2.nextLine();
            String [] splited_temp = temp.split(" ");
            if (temp.substring(6,8).contains(Integer.toString(a))) {
            allocated_JobId.add(splited_temp[3].replace("JobId=","")); //only contain JobId
            allocated_Job.add(splited_temp[3] + " 2allocated " + splited_temp[0]);} //contain JobId, and time, ease the sorting process
        }

        while(input3.hasNextLine()) {
            String temp = input3.nextLine();
            String [] splited_temp = temp.split(" ");
            if (temp.substring(6,8).contains(Integer.toString(a))) {
            submitted_JobId.add(splited_temp[2].replace("JobId=","")); //only contain JobId
            submitted_Job.add(splited_temp[2] + " 1submitted " + splited_temp[0]); }//contain JobId, and time, ease the sorting process
        }

        //Extract the JobId with completed Job flows (submit -> allocate -> complete)
        ArrayList<String> removedIncompletedJobsId = new ArrayList<>();
        for (int i = 0; i < completed_JobId.size(); i ++) {
            if (allocated_JobId.indexOf(completed_JobId.get(i)) != -1 && submitted_JobId.indexOf(completed_JobId.get(i)) != -1)
                removedIncompletedJobsId.add(completed_JobId.get(i));
        }
        Collections.sort(removedIncompletedJobsId);

        //Extract the JobId with Job flows from allocate -> complete
        ArrayList<String> removedIncompletedJobsId_allo_comp = new ArrayList<>();
        for (int i = 0; i < completed_JobId.size(); i ++) {
            if (allocated_JobId.indexOf(completed_JobId.get(i)) != -1)
            removedIncompletedJobsId_allo_comp.add(completed_JobId.get(i));
        }

        PrintWriter write = new PrintWriter(new FileOutputStream("simplified3importantall.txt",true));

        //create an ArrayList to store all the submitted, allocate, completed Job
        ArrayList<String> all_together = new ArrayList<>();


        for(int i = 0; i < submitted_Job.size(); i ++) {
            all_together.add(submitted_Job.get(i));
        }

        for(int i = 0; i < allocated_Job.size(); i ++) {
            all_together.add(allocated_Job.get(i));
        }

        for(int i = 0; i < completed_Job.size(); i ++) {
            all_together.add(completed_Job.get(i));
        }

        //sort the all_together and write it into txt file to confirm that same JobId can be placed together
        Collections.sort(all_together);
        for (int i = 0; i <all_together.size(); i ++) {
            write.println(all_together.get(i));
        }

        write.close();


        System.out.println("All JobID that contains i) Job Submission ii) Job Allocation  iii)Job Completion in the log file for month "+a+"\n are printed onto [[simplified3importantall.txt]]");
        System.out.println();

        
        Scanner scan = new Scanner(new FileReader("extracted_log"));
        

        //Create an ArrayList to store the information of Jobs which have completed work flows only
        ArrayList<String> temporary = new ArrayList<>();
        ArrayList<String> completed_workFlows_JobsID = new ArrayList<>();
        ArrayList<String> temporary2 = new ArrayList<>();
        ArrayList<String> completed_workFlows_JobsID_AlloComp = new ArrayList<>();

        while (scan.hasNextLine()) {
            String temp = scan.nextLine();
            String [] tempo = temp.split(" ");
           if(temp.contains("_slurm_rpc_submit_batch_job: JobId=")) {
                for (int i = 0; i < removedIncompletedJobsId.size(); i ++) {
                if(temp.contains(removedIncompletedJobsId.get(i) + " InitPrio=")) {
                    
                    if (temporary.indexOf(tempo[2] + " " + "2submitted") != -1) {
                        break;
                    }

                    else {
                        temporary.add(tempo[2] + " " + "1submitted");
                        completed_workFlows_JobsID.add(tempo[2] + " " + "1submitted" + " " + tempo[0]);
                    }
                    break;
                }
            }
            }

            else if(temp.contains("sched: Allocate JobId=") && temp.contains("NodeList=")) {
                for (int i = 0; i < removedIncompletedJobsId.size(); i ++) {
                    if(temp.contains(removedIncompletedJobsId.get(i))) {

                        if (temporary.indexOf(tempo[3] + " " + "2allocated") != -1) {
                            break;
                        }

                        else {
                            temporary.add(tempo[3] + " " + "2allocated");
                            completed_workFlows_JobsID.add(tempo[3] + " " + "2allocated" + " " + tempo[0]);
                        }
                        break;
                }
            }
            }

            else if(temp.contains("_job_complete: JobId=") && temp.contains("done")) {
                for (int i = 0; i < removedIncompletedJobsId.size(); i ++) {
                if(temp.contains(removedIncompletedJobsId.get(i))) {
                    
                    if (temporary.indexOf(tempo[2] + " " + "3completed") != -1) {
                        break;
                    }

                    else {
                        temporary.add(tempo[2] + " " + "3completed");
                        completed_workFlows_JobsID.add(tempo[2] + " " + "3completed" + " " + tempo[0]);
                    }
                    break;
                }
                }
            }

            else continue;
        }
        System.out.println("All JobID that contains complete work flow from i) Job Submission UNTIL iii)Job Completion in the log file for month "+a+"\n are printed onto [[SubmitToCompleteANDMonth"+a+".txt]]");
        System.out.println();


        Scanner scanner = new Scanner(new FileReader("extracted_log"));

        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            String [] tempo = temp.split(" ");

            if(temp.contains("sched: Allocate JobId=") && temp.contains("NodeList=")) {
                for (int i = 0; i < removedIncompletedJobsId_allo_comp.size(); i ++) {
                    if(temp.contains(removedIncompletedJobsId_allo_comp.get(i))) {

                        if (temporary2.indexOf(tempo[3] + " " + "2allocated") != -1) {
                            break;
                        }

                        else {
                            temporary2.add(tempo[3] + " " + "2allocated");
                            completed_workFlows_JobsID_AlloComp.add(tempo[3] + " " + "2allocated" + " " + tempo[0]);
                        }
                        break;
                }
            }
            }

            else if(temp.contains("_job_complete: JobId=") && temp.contains("done")) {
                for (int i = 0; i < removedIncompletedJobsId_allo_comp.size(); i ++) {
                if(temp.contains(removedIncompletedJobsId_allo_comp.get(i))) {
                    
                    if (temporary2.indexOf(tempo[2] + " " + "3completed") != -1) {
                        break;
                    }

                    else {
                        temporary2.add(tempo[2] + " " + "3completed");
                        completed_workFlows_JobsID_AlloComp.add(tempo[2] + " " + "3completed" + " " + tempo[0]);
                    }
                    break;
                }
                }
            }

            else continue;
        }
        PrintWriter writer = new PrintWriter(new FileOutputStream("SubmitToCompleteANDMonth"+a+".txt"));
        
        Collections.sort(completed_workFlows_JobsID);
        Collections.sort(completed_workFlows_JobsID_AlloComp);
        for (int i = 0; i < completed_workFlows_JobsID.size(); i ++) {
            writer.println(completed_workFlows_JobsID.get(i));
        }

        PrintWriter writing = new PrintWriter(new FileOutputStream("AllocateToCompleteANDforMonth"+a+".txt"));

        for (int i = 0; i < completed_workFlows_JobsID_AlloComp.size(); i ++) {
            writing.println(completed_workFlows_JobsID_AlloComp.get(i));
        }

        writer.close();
        writing.close();

        System.out.println("All JobID that contains  work flow from ii) Job Allocation UNTIL iii)Job Completion in the log file for month "+a+"\n are printed onto [[AllocateToCompleteANDforMonth"+a+".txt]]");
        System.out.println();

        
    
    }
}