package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student("Alex");
        student.rate("Math", 5);
        Student student2 = new Student("Nikita");
        student.rate("Math", 7);
        studentList.add(student);
        studentList.add(student2);
        System.out.println(avgMark(studentList, "Math"));
    }

    public static double avgMark(List<Student> students, String subject) {
        int k = 0;
        return students.stream().filter(student -> student.rating.get(subject) != null).collect(Collectors.averagingDouble(student -> student.rating.get(subject)));
    }
}