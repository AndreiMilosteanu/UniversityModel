//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

import lab3.model.Course;
import lab3.model.Student;
import lab3.model.Teacher;
import lab3.repository.CourseRepo;
import lab3.repository.StudentsRepo;
import lab3.repository.TeacherRepo;
import lab3.view.CourseView;
import lab3.view.StudentView;
import lab3.view.TeacherView;
/*
controller-ul principal, se foloseste de AppController si mai are in plus functiile de add student,teacher si course
pentru a fi mai usor de folosit in interfata
 */
public class Controller2 {


    Scanner keyboard;
    StudentView viewStudent;
    TeacherView viewTeacher;
    CourseView viewCourse;
    StudentsRepo RepoStudents;
    CourseRepo RepoCourse;
    TeacherRepo RepoTeacher;
    AppControler controler;

    public Controller2() {
        this.keyboard = new Scanner(System.in);

        this.viewStudent = new StudentView();
        this.viewTeacher = new TeacherView();
        this.viewCourse = new CourseView();

        this.RepoStudents = new StudentsRepo();
        this.RepoCourse = new CourseRepo();
        this.RepoTeacher = new TeacherRepo();

        this.controler = new AppControler(this.RepoCourse, this.RepoStudents, this.RepoTeacher);
    }
    public void ReadEntries(){
        try {
            File myObj = new File("Lab4MilosteanuDraghici/lab3V3/lab3/src/lab3/Entries.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] words = line.split(" ");
                if(words.length == 3){
                    Teacher teacher = new Teacher(words[0], words[1], Long.parseLong(words[2]));
                    RepoTeacher.save(teacher);
                }
                else if(words.length == 4){
                    Student student = new Student(words[0], words[1], Long.parseLong(words[2]), Integer.parseInt(words[3]));
                    RepoStudents.save(student);
                }
                else{
                    boolean found = false;
                    for(Teacher t : RepoTeacher.findAll()){
                        if(t.getTeacherID() == Integer.parseInt(words[1])){
                            Course course = new Course(words[0], t, Long.parseLong(words[2]), Integer.parseInt(words[3]), Integer.parseInt(words[4]));
                            RepoCourse.save(course);
                            found = true;
                            t.addCourse(course);
                        }
                    }

                    if(!found){
                        System.out.println("Could not add Course");
                    }

                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void createStudent() {
        try {
            System.out.println("First Name: ");
            String fname = this.keyboard.nextLine();
            System.out.println("Last Name: ");
            String lname = this.keyboard.nextLine();
            System.out.println("ID: ");
            long id = (long) this.keyboard.nextInt();
            List<Course> listCourse = new ArrayList();
            Student s = new Student(fname, lname, id, 0, listCourse);
            this.RepoStudents.save(s);
            this.viewStudent.printStudent(s);
        }
        catch(Exception e){
            System.out.println("datele introduse nu sunt corecte!");
            }
    }

    public void createTeacher() {
        try {
            System.out.println("First Name: ");
            String fname = this.keyboard.nextLine();
            System.out.println("Last Name: ");
            String lname = this.keyboard.nextLine();
            System.out.println("ID: ");
            long id = this.keyboard.nextLong();
            List<Course> listCourse = new ArrayList();
            Teacher t = new Teacher(fname, lname, listCourse, id);
            this.RepoTeacher.save(t);
            this.viewTeacher.printTeacher(t);
        }
        catch (Exception e){
            System.out.println("datele introduse nu sunt corecte!");
        }
    }

    public void createCourse() {
        if (this.RepoTeacher.isEmpty()) {
            System.out.println("Nu se poate deoarece inca nu exista niciun profesor");
        } else {
            try {
                System.out.println("Name: ");
                String name = this.keyboard.nextLine();
                System.out.println("ID: ");
                long id = (long) this.keyboard.nextInt();
                System.out.println("MAx Students: ");
                int max = this.keyboard.nextInt();
                System.out.println("Credits nr: ");
                int credits = this.keyboard.nextInt();
                System.out.println("ID of the teacher: ");
                long teacher = (long) this.keyboard.nextInt();
                List<Student> listStudents = new ArrayList();
                Course c = new Course(name, this.RepoTeacher.findOne(teacher), id, max, listStudents, credits);
                this.RepoCourse.save(c);
                this.viewCourse.printCourse(c);
            }
            catch (Exception e){
                System.out.println("datele introduse nu sunt corecte!");
            }
        }

    }

    public void register() {
        System.out.println("ID-ul studentului pe care il inregistrati: ");
        long idStud = (long) this.keyboard.nextInt();
        System.out.println("ID-ul cursului: ");
        long idCourse = (long) this.keyboard.nextInt();
        if (this.controler.registerNewCourse(this.RepoCourse.findOne(idCourse), this.RepoStudents.findOne(idStud))) {
            System.out.println("Studentul a fost inregistrat cu succes!");
        }

    }

    public void showAvalibleCourses() {
        if (this.controler.showAvailableCourses().isEmpty()) {
            System.out.println("Niciun curs disponibil");
        } else {
            System.out.println("Lista Cursurilor Disponibile: ");
            Iterator var1 = this.controler.showAvailableCourses().iterator();

            while (var1.hasNext()) {
                Course c = (Course) var1.next();
                this.viewCourse.printCourse(c);
            }
        }

    }

    public void showEnrolled() {
        System.out.println("ID-ul cursului: ");
        long idCourse = (long) this.keyboard.nextInt();
        if (this.RepoCourse.findOne(idCourse) == null) {
            System.out.println("Cursul dat nu exista");
        } else if (this.controler.showEnrolledStudents(this.RepoCourse.findOne(idCourse)).isEmpty()) {
            System.out.println("Niciun Student nu s-a inregistrat la cursul dat");
        } else {
            Iterator var3 = this.controler.showEnrolledStudents(this.RepoCourse.findOne(idCourse)).iterator();

            while (var3.hasNext()) {
                Student s = (Student) var3.next();
                this.viewStudent.printStudent(s);
            }
        }

    }

    public void newCredits() {
        System.out.println("ID-ul cursului: ");
        long idCourse = (long) this.keyboard.nextInt();
        System.out.println("nr de credite: ");
        int credtis = this.keyboard.nextInt();
        this.controler.updateCourseCredits(this.RepoCourse.findOne(idCourse), credtis);
        this.viewCourse.printCourse(this.RepoCourse.findOne(idCourse));
    }

    public void deleteCourse() {
        System.out.println("ID-ul cursului: ");
        long idCourse = (long) this.keyboard.nextInt();
        System.out.println("ID-ul profesorului: ");
        long idTeacher = (long) this.keyboard.nextInt();
        this.controler.deleteCourseByTeacher(this.RepoTeacher.findOne(idTeacher), this.RepoCourse.findOne(idCourse));
        this.viewTeacher.printTeacher(this.RepoTeacher.findOne(idTeacher));
    }

    public void showStudents(){
        for(Student s : this.RepoStudents.findAll()){
            this.viewStudent.printStudent(s);
        }
    }

    public void showTeachers(){
        for(Teacher t : this.RepoTeacher.findAll()){
            this.viewTeacher.printTeacher(t);
        }
    }

    public void showCourses(){
        for(Course c : this.RepoCourse.findAll()){
            this.viewCourse.printCourse(c);
        }
    }

    public void showMenu() {
        System.out.println("\n");
        System.out.println("Meniu Activitati");
        System.out.println("Adaugare student: 1");
        System.out.println("Adaugare profesor: 2");
        System.out.println("Adaugare curs: 3");
        System.out.println("Inregistrare student la curs: 4");
        System.out.println("Lista cursuri disponibile: 5");
        System.out.println("Lista elevi inregistrati la curs: 6");
        System.out.println("Modificare credite curs: 7");
        System.out.println("Stergere curs: 8");
        System.out.println("Afisare studenti: 9");
        System.out.println("Afisare profesori: 10");
        System.out.println("Afisare cursuri: 11");
        System.out.println("Afisare lista studenti ordonati dupa Last Name: 12");
        System.out.println("Afisare liste studenti cu cursuri mai multe decat un parametru: 13");
        System.out.println("Iesire: 0");
        System.out.println("NR dumneavoastra: ");
    }


    public void sortStudentsAlphabeticallyAfterLastName() {
        List<Student> rez = new ArrayList<Student>();
        List<String> LastName = new ArrayList<String>();
        for(Student s : RepoStudents.findAll()){
            LastName.add(s.getLastName());
        }
        Collections.sort(LastName);
        for(String name : LastName){
            for(Student s : RepoStudents.findAll()){
                if(name.equals(s.getLastName())){
                    rez.add(s);
                }
            }
        }

        for(Student s : rez){
            this.viewStudent.printStudent(s);
        }
    }

    public void filterStudentsAfterGivenNrOfCourses(int minCourseNr){
        List<Student> rez = new ArrayList<Student>();
        for(Student s : RepoStudents.findAll()){
            if(s.getEnrolledCourses().size() >= minCourseNr){
                rez.add(s);
            }
        }

        for(Student s : rez){
            this.viewStudent.printStudent(s);
        }
    }
}