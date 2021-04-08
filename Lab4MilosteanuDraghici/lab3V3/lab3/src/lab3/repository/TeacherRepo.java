//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lab3.model.Teacher;

public class TeacherRepo implements ICrudRepository<Teacher> {

    //explicatiile sunt in repo-ul de studenti deoarece celalate repo-uri sunt asemanatoare (implementeaza aceasi interfata)

    private List<Teacher> Teachers = new ArrayList();

    public TeacherRepo() {
    }

    public boolean isEmpty() {
        return this.Teachers.isEmpty();
    }

    public Teacher findOne(Long id) {
        Iterator var2 = this.Teachers.iterator();

        Teacher t;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            t = (Teacher)var2.next();
        } while(t.getTeacherID() != id);

        return t;
    }

    public List<Teacher> findAll() {
        return this.Teachers;
    }

    public Teacher save(Teacher entity) {
        Iterator var2 = this.Teachers.iterator();

        Teacher t;
        do {
            if (!var2.hasNext()) {
                this.Teachers.add(entity);
                return null;
            }

            t = (Teacher)var2.next();
        } while(t.getTeacherID() != entity.getTeacherID());

        return entity;
    }

    public Teacher delete(Long id) {
        Iterator var2 = this.Teachers.iterator();

        Teacher t;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            t = (Teacher)var2.next();
        } while(t.getTeacherID() != id);

        this.Teachers.remove(t);
        return t;
    }

    public Teacher update(Teacher entity) {
        Iterator var2 = this.Teachers.iterator();

        Teacher t;
        do {
            if (!var2.hasNext()) {
                return entity;
            }

            t = (Teacher)var2.next();
        } while(t.getTeacherID() != entity.getTeacherID());

        this.Teachers.set(this.Teachers.indexOf(t), entity);
        return null;
    }
}
