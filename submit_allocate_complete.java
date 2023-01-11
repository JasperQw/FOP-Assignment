import java.io.*;
import java.util.*;

public class submit_allocate_complete {
    static int counter = 0;
    public static void main(String [] args) throws IOException {
        Scanner input1 = new Scanner(new FileReader("completedJobs.txt"));
        Scanner input2 = new Scanner(new FileReader("allocatedJobs.txt"));
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
            completed_JobId.add(splited_temp[2].replace("JobId=","")); //only contain JobId
            completed_Job.add(splited_temp[2] + " 3completed " + splited_temp[0]); //contain JobId, and time, ease the sorting process
        }

        while(input2.hasNextLine()) {
            String temp = input2.nextLine();
            String [] splited_temp = temp.split(" ");
            allocated_JobId.add(splited_temp[3].replace("JobId=","")); //only contain JobId
            allocated_Job.add(splited_temp[3] + " 2allocated " + splited_temp[0]); //contain JobId, and time, ease the sorting process
        }

        while(input3.hasNextLine()) {
            String temp = input3.nextLine();
            String [] splited_temp = temp.split(" ");
            submitted_JobId.add(splited_temp[2].replace("JobId=","")); //only contain JobId
            submitted_Job.add(splited_temp[2] + " 1submitted " + splited_temp[0]); //contain JobId, and time, ease the sorting process
        }

        //Extract the JobId with completed Job flows (submit -> allocate -> complete)
        ArrayList<String> removedIncompletedJobsId = new ArrayList<>();
        for (int i = 0; i < completed_JobId.size(); i ++) {
            if (allocated_JobId.indexOf(completed_JobId.get(i)) != -1 && submitted_JobId.indexOf(completed_JobId.get(i)) != -1)
                removedIncompletedJobsId.add(completed_JobId.get(i));
        }

        //Extract the JobId with completed Job flows (submit -> allocate -> complete)
        ArrayList<String> removedIncompletedJobsId_allo_comp = new ArrayList<>();
        for (int i = 0; i < completed_JobId.size(); i ++) {
            if (allocated_JobId.indexOf(completed_JobId.get(i)) != -1)
            removedIncompletedJobsId_allo_comp.add(completed_JobId.get(i));
        }

        //Extract the JobId that allocated and completed within June to December
        ArrayList<String> AllocatedandCompleted = new ArrayList<>();
        for (int i = 0; i < completed_JobId.size(); i ++) {
            if (allocated_JobId.indexOf(completed_JobId.get(i)) != -1)
                AllocatedandCompleted.add(completed_JobId.get(i));
        }

        PrintWriter write = new PrintWriter(new FileOutputStream("all_Included_IncompletedWorkFlows.txt"));

        //create an ArrayList to store all the submitted, allocate, completed Job
        ArrayList<String> all_together = new ArrayList<>();

         //Create an ArrayList to store the Jobid for allocate and completed
         ArrayList<String> all_together_allo_comp = new ArrayList<>();

        for(int i = 0; i < submitted_Job.size(); i ++) {
            all_together.add(submitted_Job.get(i));
        }

        for(int i = 0; i < allocated_Job.size(); i ++) {
            all_together.add(allocated_Job.get(i));
            all_together_allo_comp.add(allocated_Job.get(i));
        }

        for(int i = 0; i < completed_Job.size(); i ++) {
            all_together.add(completed_Job.get(i));
            all_together_allo_comp.add(completed_Job.get(i));
        }

        //sort the all_together and write it into txt file to confirm that same JobId can be placed together
        Collections.sort(all_together);
        for (int i = 0; i <all_together.size(); i ++) {
            write.println(all_together.get(i));
        }

        write.close();

        //Create an ArrayList to store the Jobid for allocate and completed
        ArrayList<String> OnlyAlloAndComp_JobId = new ArrayList<>();

        for (int i = 0; i < all_together_allo_comp.size(); i ++ ) {
            String [] temp = all_together_allo_comp.get(i).split(" ");
            OnlyAlloAndComp_JobId.add(temp[0]);
        }

        //Create an ArrayList to store the Jobid in all_together
        ArrayList<String> all_togetherOnlyId = new ArrayList<>();


        for (int i = 0; i < all_together.size(); i ++ ) {
            String [] temp = all_together.get(i).split(" ");
            all_togetherOnlyId.add(temp[0]);
        }

        Collections.sort(removedIncompletedJobsId);
        Scanner scan = new Scanner(new FileReader("extracted_log"));
        PrintWriter writer = new PrintWriter(new FileOutputStream("all_Excluded_IncompletedWorkFlows.txt"));

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

        Collections.sort(completed_workFlows_JobsID);
        Collections.sort(completed_workFlows_JobsID_AlloComp);
        for (int i = 0; i < completed_workFlows_JobsID.size(); i ++) {
            writer.println(completed_workFlows_JobsID.get(i));
        }

        PrintWriter writing = new PrintWriter(new FileOutputStream("allo_comp_jobID.txt"));

        for (int i = 0; i < completed_workFlows_JobsID_AlloComp.size(); i ++) {
            writing.println(completed_workFlows_JobsID_AlloComp.get(i));
        }

        writer.close();
        writing.close();

        System.out.println("Number of Jobs that have Allocated and Completed = " + AllocatedandCompleted.size());

    
    }
}
