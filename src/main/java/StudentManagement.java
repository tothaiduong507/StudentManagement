import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentManagement {
    ArrayList<Student> students = new ArrayList<>();
    public void addStudent(Student student){
        students.add(student);
    }

    public void deleteById(int id){
        for (Student student : students) {
            if(student.getId() == id){
                students.remove(student);
            }
        }
    }

    public void searchByName(String name){
        for (Student student : students) {
            if(student.getName().equals(name)){
                printStudent(student);
            }
        }
    }

    public void sortByGPA(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAverageScore() >= o2.getAverageScore() ? 1 : -1;
            }
        });
        printStudentList();
    }
    public void sortByName(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        printStudentList();
    }

    public void printStudent(Student student){
        System.out.println(student.getId() + "\t"
                + student.getName() +"\t"
                + student.getGender() +"\t"
                + student.getAge() +"\t"
                + student.getMathScore() +"\t"
                + student.getPhysicsScore() +"\t"
                + student.getChemistryScore() +"\t"
                + student.getAverageScore() +"\t"
                + student.getRank()
        );
    }

    public void printStudentList(){
        for (Student student : students) {
            printStudent(student);
        }
    }

    public void writeFile(String filename) throws IOException {
        try {
            FileWriter fw = new FileWriter(filename);
            for (Student student : students) {
                fw.write(student.getName() +";"
                        + student.getGender() +";"
                        + student.getAge() +";"
                        + student.getMathScore() +";"
                        + student.getPhysicsScore() +";"
                        + student.getChemistryScore() + "\n");
            }
            fw.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found" + e.getMessage());
        }
    }
}
