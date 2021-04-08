//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3.view;

import lab3.model.Student;

public class StudentView {
    public StudentView() {
    }

    public void printStudent(Student s) {
        System.out.println("Student: ");
        System.out.println("Name: " + s.getLastName());
        System.out.println("Vorname: " + s.getFirstName());
        System.out.println("ID: " + s.getStudentID());
        System.out.println("Credits: " + s.getTotalCredits());
        System.out.println("Lista de cursuri: " + s.getEnrolledCourses());
    }
}
