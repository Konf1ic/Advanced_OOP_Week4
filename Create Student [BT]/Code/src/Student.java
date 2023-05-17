import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Student {
    private String studentCode;
    private String studentName;
    private double mathScore;
    private double physicsScore;
    private double chemistryScore;

    public Student(String studentCode, String studentName, double mathScore, double physicsScore, double chemistryScore) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.mathScore = mathScore;
        this.physicsScore = physicsScore;
        this.chemistryScore = chemistryScore;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getPhysicsScore() {
        return physicsScore;
    }

    public void setPhysicsScore(double physicsScore) {
        this.physicsScore = physicsScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(double chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    @Override
    public String toString() {
        return "Mã SV: " + studentCode +
                ", Tên SV: " + studentName +
                ", Toán: " + mathScore +
                ", Lý: " + physicsScore +
                ", Hóa: " + chemistryScore;
    }

    public static boolean saveStudentToFile(Student student, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(student.getStudentCode() + "," +
                    student.getStudentName() + "," +
                    student.getMathScore() + "," +
                    student.getPhysicsScore() + "," +
                    student.getChemistryScore());
            writer.newLine();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Student[] readStudentsFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int studentCount = 0;
            while (reader.readLine() != null) {
                studentCount++;
            }
            reader.close();

            if (studentCount == 0) {
                return null;
            }

            Student[] students = new Student[studentCount];
            BufferedReader newReader = new BufferedReader(new FileReader(fileName));
            String line;
            int index = 0;
            while ((line = newReader.readLine()) != null) {
                String[] info = line.split(",");
                String studentCode = info[0];
                String studentName = info[1];
                double mathScore = Double.parseDouble(info[2]);
                double physicsScore = Double.parseDouble(info[3]);
                double chemistryScore = Double.parseDouble(info[4]);
                Student student = new Student(studentCode, studentName, mathScore, physicsScore, chemistryScore);
                students[index] = student;
                index++;
            }
            newReader.close();
            return students;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        Student student1 = new Student("SV001", "Nguyễn Văn A", 8.5, 7.5, 9.0);
        Student student2 = new Student("SV002", "Nguyễn Thị B", 7.0, 8.0, 8.5);
        String fileName = "students.txt";

        boolean saveResult1 = saveStudentToFile(student1, fileName);
        boolean saveResult2 = saveStudentToFile(student2, fileName);

        if (saveResult1 && saveResult2) {
            System.out.println("Lưu thông tin sinh viên vào file thành công.");
        } else {
            System.out.println("Lưu thông tin sinh viên vào file thất bại.");
        }

        Student[] students = readStudentsFromFile(fileName);

        if (students != null) {
            System.out.println("Danh sách sinh viên:");
            for (Student student : students) {
                System.out.println(student.toString());
            }
        } else {
            System.out.println("File không có sinh viên.");
        }
    }
}