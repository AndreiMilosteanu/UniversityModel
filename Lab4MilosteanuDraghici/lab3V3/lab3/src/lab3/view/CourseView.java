//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3.view;

import java.io.PrintStream;
import lab3.model.Course;

public class CourseView {
    public CourseView() {
    }

    public void printCourse(Course c) {
        System.out.println("Course: ");
        System.out.println("Name: " + c.getName());
        PrintStream var10000 = System.out;
        String var10001 = c.getTeacher().getLastName();
        var10000.println("Teacher " + var10001 + " " + c.getTeacher().getFirstName());
        System.out.println("ID: " + c.getCourseID());
        System.out.println("Max Enorllment: " + c.getMaxEnorllment());
        System.out.println("Credits " + c.getCredits());
        System.out.println("Enrolled Students: " + c.getStudentsEnrolled());
    }
}
