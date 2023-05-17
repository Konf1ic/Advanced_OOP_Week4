import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteExample {

    public static void main(String[] args) {
        String fileName = "example.txt";
        String contentToWrite = "Hello, world!";

        // Ghi dữ liệu vào file
        boolean writeResult = writeFile(fileName, contentToWrite);
        if (writeResult) {
            System.out.println("Ghi dữ liệu vào file thành công.");
        } else {
            System.out.println("Ghi dữ liệu vào file thất bại.");
        }

        // Đọc dữ liệu từ file
        String contentRead = readFile(fileName);
        if (contentRead != null) {
            System.out.println("Nội dung đọc từ file: " + contentRead);
        } else {
            System.out.println("Đọc dữ liệu từ file thất bại.");
        }
    }

    // Phương thức đọc dữ liệu từ file
    public static String readFile(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            StringBuilder content = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                content.append((char) character);
            }
            reader.close();
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Phương thức ghi dữ liệu vào file
    public static boolean writeFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}