package C4_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class L01_ReadFile {
    public static void main(String[] args) {

        String path = "src/04.Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            int read = fileInputStream.read();

            while (read != -1) {
                System.out.print(Integer.toBinaryString(read)+" ");
                read = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException io) {
        }
    }
}
