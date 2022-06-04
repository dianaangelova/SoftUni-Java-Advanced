package C4_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class L02_WriteToFile {
    public static void main(String[] args) {

        String path = "src/04.Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        Set<Character> punctuation = Set.of(',', '.', '!', '?');
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("src/04.Java-Advanced-Files-and-Streams-Lab-Resources/output.txt");
            int read = fileInputStream.read();

            while (read != -1) {

                if (!punctuation.contains((char) read)) {
                    fileOutputStream.write(read);
                }
                read = fileInputStream.read();

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException io) {
        }
    }
}
