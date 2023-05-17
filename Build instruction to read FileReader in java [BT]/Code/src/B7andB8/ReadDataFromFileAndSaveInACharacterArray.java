package B7andB8;

import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromFileAndSaveInACharacterArray {

    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("D:\\IBSK1D1\\OOP2\\Week 14\\Build instruction to read FileReader in java [BT]\\Code\\src\\B7andB8\\data.txt");
            char[] buffer = new char[1024];
            int numCharsRead;
            while ((numCharsRead = reader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, numCharsRead));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}