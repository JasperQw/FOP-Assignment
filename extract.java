
import java.io.*;

public class extract {

public static void main(String a[])

{

try{

FileInputStream fstream = new FileInputStream("extracted_log");

BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

String strLine;

/* read log line by line */

int counter=0;
while ((strLine = br.readLine()) != null) {

/* parse strLine to obtain what you want */
    
        if(strLine.contains("cpu-epyc")& (strLine.contains("cpu12")| (strLine.contains("cpu13"))|(strLine.contains("cpu14"))|(strLine.contains("cpu15")))){
            System.out.println(strLine);
            counter++;
        }
}
System.out.println(counter);

fstream.close();

} catch (Exception e) {

System.err.println("Error: " + e.getMessage());

}

}

}