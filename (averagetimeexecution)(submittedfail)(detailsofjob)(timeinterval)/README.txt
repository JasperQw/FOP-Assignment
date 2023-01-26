//
1. detailsofjob.java
->read from extracted_log
->select and print the jobs allocated into "jobsallocatedfull.txt" [all months]
->select and print the jobs completed into "jobscompletedfull.txt" [all months]
->select and print the jobs submitted successfully into "jobssubmittedfull.txt" [all months]






//
4. timefromSubmitToDone.java
->read from simplified3importantAND.txt
->find the time from Submit to Completion for each Job ID.
->print into timefromSubmitToDoneOverall.txt
->ALSO find the average execution time from Submit to Completion by Overall.in every format (printed in console)






->@@@@@(haventdone)->find the total number


//
7.timeintervalbetweennewsubmission.java
->read from simplified3importantall.txt
->find out the time interval between every new submission (organized in months)
->print it into timeintervalbetweennewsubmission.txt (organized in months)

->@@@@@@@(havent done)->find the average time interval, find maximum , find minimum



//
2. submittedfailed.java  (total 468 cases)
->read from extracted_log
->select and print the jobs submitted failure into "jobssubmittedfailed.txt")  [all months]

8. submitfailreasons.java
->read from jobssubmittedfailed.txt
->filter out all possible types of failure reasons.
->print into reasontypes.txt
9. submittedfailreasonsnumber.java
->read from jobssubmittedfailed.txt
->count the total number of each submit failed reason types (total 936)

@@@@ reasontypes.txt@@@@@
->read from jobssubmittedfailed.txt
->print all types of reasontypes 

//
11. all.java
->read from extracted_log
->select and print the jobs allocated ,completed and submitted without arranging into "jobssubmitted&allocated&completedfull.txt"
@@@@@jobssubmitted&allocated&completedfull.txt@@@@@
->read from extracted_log
->select and print all JobId that containt the word " submit" , "allocate " and "completed".

i) simplified3importantall.txt
-> simplified version of 11.jobssubmitted&allocated&completedfull.txt, 
where consist of JobId and numbers of allocate OR completed OR submitted


//
13. timefromSubmitToAllocate.java
->read from simplified3impotantAND.txt
->find the time from Submit to Completion for each Job ID.
->print into timefromSubmitToDoneOverall.txt
->ALSO find the average execution time from Submit to Allocation by Overall in every format (printed in console)
@@@@@@simplified3importantAND.txt@@@@@      (done)!!!!!!!
->only consist of JobId that have allocate AND completed AND submitted in the log file
for particular months:
i）SubmitToCompleteANDMonth6.txt
i）SubmitToCompleteANDMonth7.txt
i）SubmitToCompleteANDMonth8.txt
i）SubmitToCompleteANDMonth9.txt
i）SubmitToCompleteANDMonth10.txt
i）SubmitToCompleteANDMonth11.txt
i）SubmitToCompleteANDMonth12.txt


//
14 timefromAllocateToDone.java
->read from AllocateToCompleteAND.txt
->find the time from Allocate to Completion for each Job ID.
->print into timefromAllocateToDoneOverall.txt
->ALSO find the average execution time from Allocate to Completion by Overall.in every format (printed in console)

@@@@ AllocateToCompleteAND.txt@@@      (done)!!!!!!
->only consist JobID that have allocate AND completed in the log file;
for particular months:
i）AllocateToCompleteANDforMonth6.txt
i）AllocateToCompleteANDforMonth7.txt
i）AllocateToCompleteANDforMonth8.txt
i）AllocateToCompleteANDforMonth9.txt
i）AllocateToCompleteANDforMonth10.txt
i）AllocateToCompleteANDforMonth11.txt
i）AllocateToCompleteANDforMonth12.txt


15. sorting.java    (done)!!!!!!
-> sort either
i) only the particular period has (by months)
a) allocate -> done   [AllocateToCompleteAND.txt && AllocateToCompleteANDforMonth?.txt]
b) submit -> done     [SubmitToCompleteANDMonth?.txt && simplified3impotantAND.txt]
c) submit -> allocate []