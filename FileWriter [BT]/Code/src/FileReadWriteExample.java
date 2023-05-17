import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReadWriteExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên file: ");
        String filename = scanner.nextLine();

        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File mới đc tạo ở: " + file.getAbsolutePath());
            }

            FileWriter writer = new FileWriter(file);
            System.out.print("Nhập nội dung file: ");
            String content = scanner.nextLine();
            writer.write(content);
            writer.close();

            FileReader reader = new FileReader(file);
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();

    }
}