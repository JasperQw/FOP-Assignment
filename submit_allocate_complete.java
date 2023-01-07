import java.io.*;
import java.util.*;

public class submit_allocate_complete {
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

        //Extract the JobId that allocated and completed within June to December
        ArrayList<String> AllocatedandCompleted = new ArrayList<>();
        for (int i = 0; i < completed_JobId.size(); i ++) {
            if (allocated_JobId.indexOf(completed_JobId.get(i)) != -1)
                AllocatedandCompleted.add(completed_JobId.get(i));
        }

        PrintWriter write = new PrintWriter(new FileOutputStream("all_Included_IncompletedWorkFlows.txt"));

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

        //Create an ArrayList to store the Jobid in all_together
        ArrayList<String> all_togetherOnlyId = new ArrayList<>();


        for (int i = 0; i < all_together.size(); i ++ ) {
            String [] temp = all_together.get(i).split(" ");
            all_togetherOnlyId.add(temp[0]);
        }
    
        PrintWriter writer = new PrintWriter(new FileOutputStream("all_Excluded_IncompletedWorkFlows.txt"));

        //Create an ArrayList to store the information of Jobs which have completed work flows only
        ArrayList<String> removedIncompletedJobs = new ArrayList<>();

        for (int i = 0; i < removedIncompletedJobsId.size(); i++) {
            int index = all_togetherOnlyId.indexOf("JobId=" + removedIncompletedJobsId.get(i));
            if (index != -1) {
                removedIncompletedJobs.add(all_together.get(index));
                removedIncompletedJobs.add(all_together.get(index + 1));
                removedIncompletedJobs.add(all_together.get(index + 2));
            }   
        }
        Collections.sort(removedIncompletedJobs);
        for (int i = 0; i < removedIncompletedJobs.size(); i ++) {
            writer.println(removedIncompletedJobs.get(i));
        }
        writer.close();


        System.out.println("Number of Jobs that have Allocated and Completed = " + AllocatedandCompleted.size());
    }
}
