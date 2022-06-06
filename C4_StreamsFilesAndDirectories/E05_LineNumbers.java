package C4_StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class E05_LineNumbers {
    public static void main(String[] args) {

        try (PrintWriter printWriter = new PrintWriter("src/04.Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt")) {
            Path inputFile = Paths.get("src/04.Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt");

            List<String> lines = Files.readAllLines(inputFile);

            for (int i = 0; i < lines.size(); i++) {

                printWriter.println((i + 1) + ". " + lines.get(i));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
