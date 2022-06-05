package C4_StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class L06_SortLines {
    public static void main(String[] args) throws IOException {

        String pathInput = "src/04.Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathOutput = "src/04.Java-Advanced-Files-and-Streams-Lab-Resources/output.txt";

        List<String> sortedLines = Files.readAllLines(Paths.get(pathInput))
                .stream()
                .sorted()
                .collect(Collectors.toList());

        Files.write(Path.of(pathOutput), sortedLines, StandardOpenOption.WRITE);
    }
}
