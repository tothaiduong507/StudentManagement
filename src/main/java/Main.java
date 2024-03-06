import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//        Yêu cầu: tạo ra một menu với các chức năng sau:
//
//        1. Thêm sinh viên.
//        2. Cập nhật thông tin sinh viên bởi ID.
//        3. Xóa sinh viên bởi ID.
//        4. Tìm kiếm sinh viên theo tên.
//        5. Sắp xếp sinh viên theo điểm trung bình (GPA).
//        6. Sắp xếp sinh viên theo tên.
//        7. Hiển thị danh sách sinh vien.
//        8. Ghi danh sách sinh viên vào file "student.txt" .
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();

        int age = 0;
        String name = "";
        String gender = "";
        double mathScore = 0.0;
        double physicsScore = 0.0;
        double chemistryScore = 0.0;

        // input
        try {
            File studentList = new File("student.txt");
            Scanner myReader = new Scanner(studentList);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(";");
                name = data[0];
                gender = data[1];
                age = Integer.parseInt(data[2]);
                mathScore = Double.parseDouble(data[3]);
                physicsScore = Double.parseDouble(data[4]);
                chemistryScore = Double.parseDouble(data[5]);
                studentManagement.addStudent(new Student(name, gender, age, mathScore, physicsScore, chemistryScore));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        // menu
        while (true) {
            System.out.println("Choose one option below: ");
            System.out.println("1. Add a new student. ");
            System.out.println("2. Update a student's info by id. ");
            System.out.println("3. Delete a student by id. ");
            System.out.println("4. Search student by name. ");
            System.out.println("5. Order by GPA (average score).");
            System.out.println("6. Order by name.");
            System.out.println("7. List all students.");
            System.out.println("8. Enroll the list of students into the file 'student.txt'");
            System.out.println("9. Exit.");
            int entry = Integer.parseInt(scanner.nextLine());
            switch (entry) {
                case 1:
                    System.out.print("Please enter the student's name: ");
                    name = scanner.nextLine();
                    System.out.print("Please enter the student's gender: ");
                    gender = scanner.nextLine();
                    System.out.print("Please enter the student's age: ");
                    age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Please enter the student's math score: ");
                    mathScore = Double.parseDouble(scanner.nextLine());
                    System.out.print("Please enter the student's physics score: ");
                    physicsScore = Double.parseDouble(scanner.nextLine());
                    System.out.print("Please enter the student's chemistry score: ");
                    chemistryScore = Double.parseDouble(scanner.nextLine());
                    studentManagement.addStudent(new Student(name, gender, age, mathScore, physicsScore, chemistryScore));
                    break;
                case 2:
                    System.out.print("Please enter the student's id: ");
                    int updateID = Integer.parseInt(scanner.nextLine());
                    studentManagement.deleteById(updateID);

                    System.out.print("Please enter the student's name: ");
                    name = scanner.nextLine();
                    System.out.print("Please enter the student's gender: ");
                    gender = scanner.nextLine();
                    System.out.print("Please enter the student's age: ");
                    age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Please enter the student's math score: ");
                    mathScore = Double.parseDouble(scanner.nextLine());
                    System.out.print("Please enter the student's physics score: ");
                    physicsScore = Double.parseDouble(scanner.nextLine());
                    System.out.print("Please enter the student's chemistry score: ");
                    chemistryScore = Double.parseDouble(scanner.nextLine());
                    studentManagement.addStudent(new Student(updateID, name, gender, age, mathScore, physicsScore, chemistryScore));
                    break;

                case 3:
                    System.out.print("Please enter the student's id: ");
                    int deleteID = Integer.parseInt(scanner.nextLine());
                    studentManagement.deleteById(deleteID);
                    break;

                case 4:
                    System.out.print("Please enter the student's name: ");
                    String searchName = scanner.nextLine();
                    studentManagement.searchByName(searchName);
                    break;
                case 5:
                    studentManagement.sortByGPA();
                    break;
                case 6:
                    studentManagement.sortByName();
                    break;
                case 7:
                    studentManagement.printStudentList();
                    break;
                case 8:
                    try {
                        studentManagement.writeFile("student.txt");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Please enter a provided option: ");
                    break;
            }
        }
    }
}
