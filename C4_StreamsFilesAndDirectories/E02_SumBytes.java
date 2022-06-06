package C4_StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E02_SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "src/04.Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int sum = 0;

        while (line!=null) {

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                int asci = (int) c;
                sum = sum + asci;
            }
            line = br.readLine();
        }
        System.out.println(sum);

        fr.close();
        br.close();
    }
}
