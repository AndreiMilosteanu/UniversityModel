//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3.model;

import java.util.Iterator;
import java.util.List;

public class Teacher extends Person {
    private List<Course> courses;
    private long teacherID;

    public Teacher(String firstName, String lastName, List<Course> courses, long ID) {
        super(firstName, lastName);
        this.courses = courses;
        this.teacherID = ID;
    }

    public Teacher(String word, String word1, long parseLong) {
    }

    public boolean addCourse(Course c) {
        Iterator var2 = this.courses.iterator();

        Course x;
        do {
            if (!var2.hasNext()) {
                this.courses.add(c);
                return true;
            }

            x = (Course)var2.next();
        } while(x.getCourseID() != c.getCourseID());

        return false;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public long getTeacherID() {
        return this.teacherID;
    }

    public void setTeacherID(long teacherID) {
        this.teacherID = teacherID;
    }
}
