package lab3.repository;

import lab3.model.Course;
import lab3.model.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RepTest {
    @Test
    public void TestRepoStudents(){

        System.out.println("Teste Repo");

        //testele sunt create doar pentru Repository-ul de studenti, deoarece celalalte repository-uri sunt asemanatoare

        List enrolled = new ArrayList<Course>();
        List enrolled2 = new ArrayList<Course>();
        List enrolled3 = new ArrayList<Course>();

        StudentsRepo RepoS = new StudentsRepo();
        Student s1 = new Student("Prenume1","Nume1",1,28,enrolled);
        Student s2 = new Student("Prenume1","Nume1",2,0,enrolled2);
        Student s3 = new Student("Prenume3","Nume3",1,0,enrolled3);

        Assert.assertEquals(RepoS.save(s1),null);
        Assert.assertEquals(RepoS.save(s3),s3);

        Assert.assertEquals(RepoS.findOne(s2.getStudentID()),null);
        Assert.assertEquals(RepoS.findOne(s1.getStudentID()),s1);

        Assert.assertEquals(RepoS.delete(s1.getStudentID()),s1);
        Assert.assertEquals(RepoS.delete(s2.getStudentID()),null);

        RepoS.save(s1);
        Assert.assertEquals(RepoS.update(s3),null);

        Assert.assertEquals(RepoS.delete(s3.getStudentID()),s3);
        Assert.assertEquals(RepoS.isEmpty(),true);


    }
}
