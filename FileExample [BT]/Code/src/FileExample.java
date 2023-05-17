import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        String fileName = "example.txt";
        File file = new File(fileName);

        try {
            // Tạo file mới
            if (file.createNewFile()) {
                System.out.println("File " + fileName + " đã được tạo mới thành công.");
            } else {
                System.out.println("File " + fileName + " đã tồn tại.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Kiểm tra xem file có phải là thư mục hay không
        if (file.isDirectory()) {
            System.out.println("File " + fileName + " là một thư mục.");
        } else {
            System.out.println("File " + fileName + " không phải là một thư mục.");
        }

        // Hiển thị đường dẫn của file
        System.out.println("Đường dẫn đến file " + fileName + " là: " + file.getAbsolutePath());
    }
}