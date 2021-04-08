//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3;

import lab3.controller.Controller2;
import java.util.Scanner;

/*
interfata propriu-zisa a aplicatiei; Se foloseste de controllerul principal si implementeaza un meniu interactiv cu useul
 */
public class StartApp {
    public StartApp() {
    }

    public static void main(String[] args) {
        Controller2 c2 = new Controller2();
        Scanner keyboard = new Scanner(System.in);
        c2.ReadEntries();
        c2.showMenu();
        int actionNr = 1;
        while(actionNr !=0){
            actionNr = keyboard.nextInt();
            System.out.println(actionNr);
            if(actionNr == 1){
                c2.createStudent();
            }
            else if(actionNr == 2){
                c2.createTeacher();
            }
            else if(actionNr == 3){
                c2.createCourse();
            }
            else if(actionNr == 4){
                c2.register();
            }
            else if(actionNr == 5){
                c2.showAvalibleCourses();
            }
            else if(actionNr == 6){
                c2.showEnrolled();
            }
            else if(actionNr == 7){
                c2.newCredits();
            }
            else if(actionNr == 8){
                c2.deleteCourse();
            }
            else if(actionNr == 9){
                c2.showStudents();
            }
            else if(actionNr == 10){
                c2.showTeachers();
            }
            else if(actionNr == 11){
                c2.showCourses();
            }
            else if(actionNr == 12){
                c2.sortStudentsAlphabeticallyAfterLastName();
            }
            else if(actionNr == 13){
                System.out.println("Parametrul dat: ");
                int param = keyboard.nextInt();
                c2.filterStudentsAfterGivenNrOfCourses(param);
            }
        }
    }

}
