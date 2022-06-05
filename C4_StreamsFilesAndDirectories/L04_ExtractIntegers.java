package C4_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class L04_ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "src/04.Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        FileOutputStream fileOutputStream = new FileOutputStream("src/04.Java-Advanced-Files-and-Streams-Lab-Resources/output.txt");

        Scanner scanner = new Scanner(fileInputStream);

        PrintWriter writer = new PrintWriter(fileOutputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                writer.println(scanner.next());
            } else {
                scanner.next();
            }
        }
        writer.close();
    }
}