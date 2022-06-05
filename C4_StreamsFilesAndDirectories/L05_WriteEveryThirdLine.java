package C4_StreamsFilesAndDirectories;

import java.io.*;

public class L05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String pathInput = "src/04.Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathOutput = "src/04.Java-Advanced-Files-and-Streams-Lab-Resources/output.txt";

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathInput)));

        BufferedWriter writer = new BufferedWriter(new FileWriter(pathOutput));

        String line = reader.readLine();
        int counter = 0;
        while (line != null) {
            counter++;

            if (counter%3==0){
                writer.write(line);
                writer.newLine();
            }

            line = reader.readLine();
        }
        reader.close();
        writer.close();
    }
}
