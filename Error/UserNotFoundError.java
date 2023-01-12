import Data.Table;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.*;


public class UserNotFoundError {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("Error.txt"));

        String regex = "User (\\d+) not found";
        Pattern pattern = Pattern.compile(regex);
        Set<String> userId = new HashSet<String>();

        int i = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                userId.add(matcher.group(1));
                i++;
            }
        }
            String title = "User Not Found Error";
            String [] columns = {"User ID","Numbers of Error"};
            Object data [][] = {{userId,i}};
            Table tb = new Table(title, columns, data);

            System.out.println("User id which are not found: " + userId);
            System.out.println("Numbers of User Not Found Error: " + i);

    }
}
