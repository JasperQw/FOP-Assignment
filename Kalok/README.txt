//
1. detailsofjob.java
->read from extracted_log
->select and print the jobs allocated into "jobsallocatedfull.txt" [all months]
->select and print the jobs completed into "jobscompletedfull.txt" [all months]
->select and print the jobs submitted successfully into "jobssubmittedfull.txt" [all months]
//
2. submittedfailed.java  (total 468 cases)
->read from extracted_log
->select and print the jobs submitted failure into "jobssubmittedfailed.txt")  [all months]


//
3. timefromSubmitToDone



//
4. timefromSubmitToAllocate



//
5. timefromAllocateToDone



//
6. submitfailreasons.java
->read from jobssubmittedfailed.txt
->filter out all possible types of failure reasons.
->print into reasontypes.txt


//
7.timeintervalbetweennewsubmission
->read from simplified3importantall.txt
->find out the time interval between every new submission (organized in months)
->print it into timeintervalbetweennewsubmission.txt


//
8.all.java
->read from extracted_log
->select and print the jobs allocated ,completed and submitted without arranging into "jobssubmitted&allocated&completedfull.txt"


//
9. reasontypes.txt
->read from jobssubmittedfailed.txt
->print all types of reasontypes 


//
10. submittedfailreasonsnumber.java
->read from jobssubmittedfailed.txt
->count the total number of each submit failed reason types (total 936)

//
11.jobssubmitted&allocated&completedfull.txt
->read from extracted_log
->select and print all JobId that containt the word " submit" , "allocate " and "completed".


//
12.simplified3importantall.txt
-> simplified version of 11.jobssubmitted&allocated&completedfull.txt, where consist of JobId and numbers of allocate OR completed OR submitted


//
13.simplified3importantAND.txt
-> simplified version of 11.jobssubmitted&allocated&completedfull.txt, where consist of JobId and numbers of allocate AND completed AND submitted