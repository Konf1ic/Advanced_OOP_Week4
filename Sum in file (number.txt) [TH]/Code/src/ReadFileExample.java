import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileText(String filePath) {
        try {
            // Đọc file theo đường dẫn
            File file = new File(filePath);
            // Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ.
            boolean exist = file.exists();
            if (!exist) {
                throw new FileNotFoundException();
            }

            // Đọc từng dòng của file và tiến hành cộng tổng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                try {
                    int num = Integer.parseInt(line);
                    sum += num;
                } catch (NumberFormatException e) {
                    // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
                    System.err.println("Fie không tồn tại or nội dung có lỗi!");
                }
            }
            br.close();

            // Hiển thị ra màn hình tổng các số nguyên trong file
            System.out.println("Tổng = " + sum);
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại!");
        } catch (Exception e) {
            System.err.println("Nội dung file có lỗi!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readfileEx = new ReadFileExample();
        readfileEx.readFileText(path);
    }
}
