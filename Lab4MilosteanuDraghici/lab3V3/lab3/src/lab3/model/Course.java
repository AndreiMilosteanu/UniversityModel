//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3.model;

import java.util.List;

public class Course {
    private String Name;
    private Person teacher;
    private long courseID;
    private int maxEnorllment;
    private List<Student> studentsEnrolled;
    private int credits;

    public Course(String name, Person teacher, long courseID, int maxEnorllment, List<Student> studentsEnrolled, int credits) {
        this.Name = name;
        this.teacher = teacher;
        this.courseID = courseID;
        this.maxEnorllment = maxEnorllment;
        this.studentsEnrolled = studentsEnrolled;
        this.credits = credits;
    }

    public Course(String word, Teacher t, long parseLong, int parseInt, int parseInt1) {
    }

    public long getCourseID() {
        return this.courseID;
    }

    public void setCourseID(long courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Person getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public int getMaxEnorllment() {
        return this.maxEnorllment;
    }

    public void setMaxEnorllment(int maxEnorllment) {
        this.maxEnorllment = maxEnorllment;
    }

    public List<Student> getStudentsEnrolled() {
        return this.studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String toString() {
        return "Course{Name='" + this.Name + "', courseID=" + this.courseID + "}";
    }
}
