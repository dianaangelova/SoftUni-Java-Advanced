package C4_StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class L07_ListFiles {
    public static void main(String[] args) throws IOException {

        File root = new File("C:\\Users\\Diana\\IdeaProjects\\JavaAdvanced\\src\\" +
                "04.Java-Advanced-Files-and-Streams-Lab-Resources\\" +
                "Files-and-Streams");

        Arrays.stream(root.listFiles())
                .filter(File::isFile)
                .forEach(file -> System.out.println(file.getName() + ": [" + file.length()+"]"));
    }
}
