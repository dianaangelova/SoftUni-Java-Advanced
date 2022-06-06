package C4_StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E01_SumLines {
    public static void main(String[] args) throws IOException {

        String path = "src/04.Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        while (line!=null) {

            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                int asci = (int) c;
                sum = sum + asci;
            }
            System.out.println(sum);
            line = br.readLine();
        }
        fr.close();
        br.close();
    }
}
