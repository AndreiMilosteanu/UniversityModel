//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lab3.model.Course;
import lab3.model.Student;
import lab3.model.Teacher;
import lab3.repository.CourseRepo;
import lab3.repository.StudentsRepo;
import lab3.repository.TeacherRepo;

/*
controllerul care implementeaza functiile din cerinta; se foloste de Repo-uri si de modele
 */
public class AppControler {
    CourseRepo courseRepo;
    StudentsRepo studentsRepo;
    TeacherRepo teacherRepo;

    public AppControler(CourseRepo courseRepo, StudentsRepo studentsRepo, TeacherRepo teacherRepo) {
        this.courseRepo = courseRepo;
        this.studentsRepo = studentsRepo;
        this.teacherRepo = teacherRepo;
    }

    public boolean registerNewCourse(Course course, Student student) {
        /*
        se verfica daca studentul si cursul exista
            daca da, se verifica daca studentul este deja inscris la curs
                daca da, se verifica daca studentul ar depasi nr de credite in cazul in care se inscrie la curs
                    daca nu se adauga cursul in lista studentului si stundentul in lista cursului
        daca nu, se returneaza false impreuna cu eroarea aferenta
         */
        if (this.studentsRepo.findOne(student.getStudentID()) != null && this.courseRepo.findOne(course.getCourseID()) != null) {
            if (!student.getEnrolledCourses().contains(course)) {
                if (course.getStudentsEnrolled().size() < course.getMaxEnorllment()) {
                    if (student.getTotalCredits() + course.getCredits() <= 30) {
                        List<Course> newCrs = student.getEnrolledCourses();
                        newCrs.add(course);
                        student.setEnrolledCourses(newCrs);
                        student.setTotalCredits(student.getTotalCredits() + course.getCredits());
                        List<Student> newStd = course.getStudentsEnrolled();
                        newStd.add(student);
                        course.setStudentsEnrolled(newStd);
                        return true;
                    } else {
                        System.out.println("Student will have too many credits (>30)");
                        return false;
                    }
                } else {
                    System.out.println("Chosen course is already full");
                    return false;
                }
            } else {
                System.out.println("Student is already enrolled");
                return false;
            }
        } else {
            System.out.println("Student or Course are not found");
            return false;
        }
    }

    // se itereaza prin lista cu toate cursurile si se adauga doar cele in care mai sunt locuri in lista finala, care se returneaza
    public List<Course> showAvailableCourses() {
        List<Course> rezCrs = new ArrayList();
        Iterator var2 = this.courseRepo.findAll().iterator();

        while(var2.hasNext()) {
            Course course = (Course)var2.next();
            if (course.getStudentsEnrolled().size() < course.getMaxEnorllment()) {
                rezCrs.add(course);
            }
        }

        return rezCrs;
    }

    //se itereaza prin studentii cursului dat si se returneaza lista cu acestia
    //eroare daca se da un curs care nu exista
    public List<Student> showEnrolledStudents(Course course) {
        if (this.courseRepo.findOne(course.getCourseID()) != null) {
            List<Student> rezStd = new ArrayList();
            rezStd.addAll(course.getStudentsEnrolled());
            return rezStd;
        } else {
            System.out.println("Course is not found");
            return null;
        }
    }

    // daca cursul exista, i se modifica numarul de credite, iar diferenta se scade la numarul de credite de la fiecare student
    // eroare daca nu exista
    public void updateCourseCredits(Course course, int newCredits) {
        if (this.courseRepo.findOne(course.getCourseID()) != null) {
            int dif = course.getCredits() - newCredits;
            this.courseRepo.findOne(course.getCourseID()).setCredits(newCredits);
            Iterator var4 = course.getStudentsEnrolled().iterator();

            while(var4.hasNext()) {
                Student student = (Student)var4.next();
                student.setTotalCredits(student.getTotalCredits() - dif);
            }

            System.out.println("Course was updated!");
        } else {
            System.out.println("Course is not found");
        }

    }

    /*
    se verifica daca exista profesorul si daca cursul dat este predat de el
    daca da, se itereaza prin cursurile studentilor si se sterge cel dat. Se procedeaza la fel si la profesor
    la final se modifica creditele studentilor afectati
     */
    public boolean deleteCourseByTeacher(Teacher teacher, Course course) {
        if (this.teacherRepo.findOne(teacher.getTeacherID()) == null) {
            System.out.println("Teacher is not found");
            return false;
        } else if (!teacher.getCourses().contains(course)) {
            System.out.println("Course is not assigned to the teacher");
            return false;
        } else {
            Iterator var3 = this.studentsRepo.findAll().iterator();

            while(true) {
                Student student;
                do {
                    if (!var3.hasNext()) {
                        List<Course> rezCrs = new ArrayList();
                        Iterator var9 = teacher.getCourses().iterator();

                        while(var9.hasNext()) {
                            Course c = (Course)var9.next();
                            if (c != course) {
                                rezCrs.add(c);
                            }
                        }

                        teacher.setCourses(rezCrs);
                        this.courseRepo.delete(course.getCourseID());
                        return true;
                    }

                    student = (Student)var3.next();
                } while(!student.getEnrolledCourses().contains(course));

                List<Course> rezCrs1 = new ArrayList();
                Iterator var6 = student.getEnrolledCourses().iterator();

                while(var6.hasNext()) {
                    Course c = (Course)var6.next();
                    if (c != course) {
                        rezCrs1.add(c);
                    }
                }

                student.setEnrolledCourses(rezCrs1);
                student.setTotalCredits(student.getTotalCredits() - course.getCredits());
            }
        }
    }
}
