package C4_StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class E04_CountCharacterTypes {
    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "src/04.Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outputPath = "src/04.Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";


        try (FileReader fileReader = new FileReader(inputPath);
             PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath));) {

            int oneElem = fileReader.read();

            int sumVol = 0;
            int sumCons = 0;
            int sumPunct = 0;

            while (oneElem != -1) {
                char oneChar = (char) oneElem;
                if (oneChar == 'a' || oneChar == 'e' || oneChar == 'i' || oneChar == 'o' || oneChar == 'u') {
                    sumVol++;
                } else if (oneChar == '!' || oneChar == ',' || oneChar == '.' || oneChar == '?') {
                    sumPunct++;
                } else if (!Character.isWhitespace(oneChar)) {
                    sumCons++;
                }
                oneElem = fileReader.read();
            }
            printWriter.println("Vowels: " + sumVol);
            printWriter.println("Consonants: " + sumCons);
            printWriter.println("Punctuation: " + sumPunct);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
