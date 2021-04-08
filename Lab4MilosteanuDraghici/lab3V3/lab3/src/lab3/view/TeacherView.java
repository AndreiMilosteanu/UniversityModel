//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3.view;

import lab3.model.Teacher;

public class TeacherView {
    public TeacherView() {
    }

    public void printTeacher(Teacher t) {
        System.out.println("Teacher: ");
        System.out.println("Name: " + t.getLastName());
        System.out.println("Vorname: " + t.getFirstName());
        System.out.println("ID: " + t.getTeacherID());
        System.out.println("Courses: " + t.getCourses());
    }
}
