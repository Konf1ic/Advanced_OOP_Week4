package B7andB8;

import java.io.FileReader;
import java.io.IOException;

public class ReadFileAndSkipChar {

    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("D:\\IBSK1D1\\OOP2\\Week 14\\Build instruction to read FileReader in java [BT]\\Code\\src\\B7andB8\\data.txt");
            long numCharsSkipped = reader.skip(10);
            System.out.println("Skipped " + numCharsSkipped + " kí tự.");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}