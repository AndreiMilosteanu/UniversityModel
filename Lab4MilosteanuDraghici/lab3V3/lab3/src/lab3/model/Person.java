//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3.model;

public class Person {
    private String FirstName;
    private String LastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.FirstName = firstName;
        this.LastName = lastName;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String toString() {
        return "Person{FirstName='" + this.FirstName + "', LastName='" + this.LastName + "'}";
    }
}
