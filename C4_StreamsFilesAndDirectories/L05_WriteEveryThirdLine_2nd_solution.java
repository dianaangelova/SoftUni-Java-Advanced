package C4_StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class L05_WriteEveryThirdLine_2nd_solution {
    public static void main(String[] args) throws IOException {

        String pathInput = "src/04.Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathOutput = "src/04.Java-Advanced-Files-and-Streams-Lab-Resources/output.txt";

        List<String> stringList = Files.readAllLines(Paths.get(pathInput));

        for (int i = 2; i < stringList.size(); i+=3) {
           // System.out.println(stringList.get(i));
            Files.write(Path.of(pathOutput), stringList, StandardOpenOption.APPEND);
        }

    }
}
