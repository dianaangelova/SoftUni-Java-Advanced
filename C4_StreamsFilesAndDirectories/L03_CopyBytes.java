package C4_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class L03_CopyBytes {
    public static void main(String[] args) throws InterruptedException {

        String path = "src/04.Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("src/04.Java-Advanced-Files-and-Streams-Lab-Resources/output.txt");

            int read = (fileInputStream.read());
            while (read != -1) {
                byte oneByte = (byte) read;
                String digits = String.valueOf(oneByte);
                if (digits.equals("32")||digits.equals("10")){
                    fileOutputStream.write(Integer.parseInt(digits));
                } else{
                    for (int i = 0; i < digits.length(); i++) {
                        fileOutputStream.write(digits.charAt(i));
                    }
                }
                read = fileInputStream.read();
            }

        } catch (
                IOException io) {
        }
    }
}
