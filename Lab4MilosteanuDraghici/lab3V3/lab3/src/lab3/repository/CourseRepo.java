//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lab3.model.Course;

public class CourseRepo implements ICrudRepository<Course> {

    //explicatiile sunt in repo-ul de studenti deoarece celalate repo-uri sunt asemanatoare (implementeaza aceasi interfata)

    private List<Course> Courses = new ArrayList();

    public CourseRepo() {
    }

    public boolean isEmpty() {
        return this.Courses.size() == 0;
    }

    public Course findOne(Long id) {
        Iterator var2 = this.Courses.iterator();

        Course c;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            c = (Course)var2.next();
        } while(c.getCourseID() != id);

        return c;
    }

    public List<Course> findAll() {
        return this.Courses;
    }

    public Course save(Course entity) {
        Iterator var2 = this.Courses.iterator();

        Course c;
        do {
            if (!var2.hasNext()) {
                this.Courses.add(entity);
                return null;
            }

            c = (Course)var2.next();
        } while(c.getCourseID() != entity.getCourseID());

        return entity;
    }

    public Course delete(Long id) {
        Iterator var2 = this.Courses.iterator();

        Course c;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            c = (Course)var2.next();
        } while(c.getCourseID() != id);

        this.Courses.remove(c);
        return c;
    }

    public Course update(Course entity) {
        Iterator var2 = this.Courses.iterator();

        Course c;
        do {
            if (!var2.hasNext()) {
                return entity;
            }

            c = (Course)var2.next();
        } while(c.getCourseID() != entity.getCourseID());

        this.Courses.set(this.Courses.indexOf(c), entity);
        return null;
    }
}
