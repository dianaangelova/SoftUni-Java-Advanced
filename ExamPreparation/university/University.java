package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        int countStudents = 0;
        for (Student s : students) {
            countStudents++;
        }
        return countStudents;
    }

    public String registerStudent(Student student) {
        String text = "";
        if (students.contains(student)) {
            text = "Student is already in the university";
        } else if (getStudentCount() < getCapacity()) {
            students.add(student);
            text = "Added student " + student.firstName + " " + student.lastName;
        } else if (getStudentCount() >= getCapacity()) {
            text = "No seats in the university";
        }
        return text;
    }

    public String dismissStudent(Student student) {

        String dismiss;

        if (students.contains(student)) {
            students.remove(student);
            dismiss = "Removed student " + student.firstName + " " + student.lastName;
        } else dismiss = "Student not found";

        return dismiss;

    }

    public String getStudent(String firstName, String lastName) {
        String bestSubject = "";
        for (Student s : students) {
            if (s.firstName.equals(firstName) && s.lastName.equals(lastName)) {
                bestSubject = s.getBestSubject();
            }
        }
        return "Student: " + firstName + " " + lastName + ", " + bestSubject;
    }

    public String getStatistics() {
        List<String> outputList = new ArrayList<>();
        String outputMessage;
        for (Student s : students) {
            outputMessage = ("==Student: First Name = " + s.firstName
                    + ", Last Name = " + s.lastName
                    + ", Best Subject = " + s.bestSubject);
            outputList.add(outputMessage);
        }
        return (String.join(System.lineSeparator(), outputList));
    }
}