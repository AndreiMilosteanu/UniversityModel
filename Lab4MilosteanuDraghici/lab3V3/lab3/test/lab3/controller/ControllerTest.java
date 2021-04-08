package lab3.controller;

import lab3.model.Course;
import lab3.model.Student;
import lab3.model.Teacher;
import lab3.repository.CourseRepo;
import lab3.repository.StudentsRepo;
import lab3.repository.TeacherRepo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ControllerTest {
    @Test
    public void TestController() {
        System.out.println("Teste Controller");
        List enrolled = new ArrayList<Course>();
        List enrolled2 = new ArrayList<Course>();
        List enrolled3 = new ArrayList<Course>();

        Student s1 = new Student("Prenume1", "Nume1", 1, 28, enrolled);
        Student s2 = new Student("Prenume2", "Nume2", 2, 0, enrolled2);
        Student s3 = new Student("Prenume3", "Nume3", 3, 0, enrolled3);

        List courses = new ArrayList<Course>();
        Teacher t = new Teacher("Teacher1","Teacher1",courses,1);

        List students = new ArrayList<Student>();
        List students2 = new ArrayList<Student>();
        List students3 = new ArrayList<Student>();


        Course c1 = new Course("BD",t,1,3,students,5);
        Course c2 = new Course("Mate",t,2,1,students2,20);
        Course c3 = new Course("Info",t,3,20,students3,1);

        t.addCourse(c1);
        t.addCourse(c2);
        t.addCourse(c3);

        StudentsRepo stud = new StudentsRepo();
        TeacherRepo techer = new TeacherRepo();
        CourseRepo course = new CourseRepo();

        stud.save(s1);
        stud.save(s2);
        stud.save(s3);

        techer.save(t);

        course.save(c1);
        course.save(c2);
        course.save(c3);

        AppControler controller = new AppControler(course,stud,techer);

        //pentru functia de enroll student la un curs nou
        //verifica daca are nr de credite necesar
        Assert.assertEquals(controller.registerNewCourse(c1,s1), false);
        Assert.assertEquals(controller.registerNewCourse(c1,s2), true);
        Assert.assertEquals(controller.registerNewCourse(c1,s3), true);

        //verifica daca cursul mai are locuri
        Assert.assertEquals(controller.registerNewCourse(c2,s1), false);
        Assert.assertEquals(controller.registerNewCourse(c2,s2), true);
        Assert.assertEquals(controller.registerNewCourse(c2,s3), false);

        //verifica daca acelasi student se poate inrola de 2 ori la acelasi curs
        Assert.assertEquals(controller.registerNewCourse(c3,s1), true);
        Assert.assertEquals(controller.registerNewCourse(c3,s2), true);
        Assert.assertEquals(controller.registerNewCourse(c3,s3), true);

        Assert.assertEquals(controller.registerNewCourse(c3,s1), false);

        //pentru functia de returnare a cursurilor disponibile
        Assert.assertEquals(controller.showAvailableCourses().isEmpty(),false);
        Assert.assertEquals(controller.showAvailableCourses().size(),2);

        //pentru functia de returnare a studentilor inregistrati la un curs dat
        Assert.assertEquals(controller.showEnrolledStudents(c3).size(),3);
        Assert.assertEquals(controller.showEnrolledStudents(c3).contains(s1),true);
        Assert.assertEquals(controller.showEnrolledStudents(c3).contains(s2),true);
        Assert.assertEquals(controller.showEnrolledStudents(c3).contains(s3),true);

        Assert.assertEquals(controller.showEnrolledStudents(c2).size(),1);
        Assert.assertEquals(controller.showEnrolledStudents(c2).contains(s2),true);

        //pentru functia de update a creditelor
        controller.updateCourseCredits(c1,10);
        Assert.assertEquals(c1.getCredits(), 10);

        controller.updateCourseCredits(c1,5);
        Assert.assertEquals(c1.getCredits(), 5);

        //pentru functia de stergere a unui curs
        Assert.assertEquals(controller.deleteCourseByTeacher(t,c1),true);
        Assert.assertEquals(controller.showAvailableCourses().size(),1);

        System.out.println("\nAm trecut de toate testele!");
    }
}
