package C4_StreamsFilesAndDirectories.Exercise;

import java.io.*;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public class E03_ALLCAPITALS {

    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "src/04.Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outputPath = "src/04.Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath))) {
            br.lines().forEach(line -> printWriter.println(line.toUpperCase()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
