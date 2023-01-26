import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GresError {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("Error.txt"));

        String regex = "gres/gpu";
        Pattern pattern = Pattern.compile(regex);
        Set<String> error = new HashSet<String>();

        int i=0;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                error.add(matcher.group());
                i++;
            }
        }

        System.out.println("\"The total number for error type [gres/gpu: job 49534 dealloc node gpu02 type titanxp gres count underflow (0 1)] is "+ i);

    }
}
