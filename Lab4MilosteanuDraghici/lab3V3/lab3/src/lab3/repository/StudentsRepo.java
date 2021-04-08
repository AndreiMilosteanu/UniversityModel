//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lab3.model.Student;

public class StudentsRepo implements ICrudRepository<Student> {
    private List<Student> Students = new ArrayList();

    public StudentsRepo() {
    }

    public boolean isEmpty(){
        if(Students.isEmpty())
            return true;
        return false;
    }
    public Student findOne(Long id) {
        //se itereaza prin toata lista pana se gaseste obiectul cu id-ul cautat
        Iterator var2 = this.Students.iterator();

        Student s;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            s = (Student)var2.next();
        } while(s.getStudentID() != id);

        return s;
    }

    //returneaza lista de studenti
    public List<Student> findAll() {
        return this.Students;
    }

    //se itereaza prin toata lista si se verifica daca s-a gasit un obiect cu id-ul dat
    //daca se ajunge pana la sfarsitul listei, se adauga acolo obiectul dat
    public Student save(Student entity) {
        if (entity == null) {
            return null;
        } else {
            Iterator var2 = this.Students.iterator();

            Student s;
            do {
                if (!var2.hasNext()) {
                    this.Students.add(entity);
                    return null;
                }

                s = (Student)var2.next();
            } while(s.getStudentID() != entity.getStudentID());

            return entity;
        }
    }

    //se itereaza prin lista pana se gaseste obiectul cu id-ul dat, dupa care se sterge din lista si returneaza obiectul sters
    // daca nu returneaza null
    public Student delete(Long id) {
        Iterator var2 = this.Students.iterator();

        Student s;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            s = (Student)var2.next();
        } while(s.getStudentID() != id);

        this.Students.remove(s);
        return s;
    }

    //se da ca parametru un obiect
    //daca se gaseste un obiect din repo cu id-ul egal cu cel dat ca parametru, se suprascire cu parametrul
    public Student update(Student entity) {
        Iterator var2 = this.Students.iterator();

        Student s;
        do {
            if (!var2.hasNext()) {
                return entity;
            }

            s = (Student)var2.next();
        } while(s.getStudentID() != entity.getStudentID());

        this.Students.set(this.Students.indexOf(s), entity);
        return null;
    }
}
