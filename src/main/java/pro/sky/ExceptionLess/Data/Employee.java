package pro.sky.ExceptionLess.Data;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean equals(Employee obj){
        return this.firstName.equals(obj.getFirstName()) && this.lastName.equals(obj.getLastName());
    }

    public int hashCode() {
        return Objects.hash(this.getFirstName(), this.getLastName());
    }
    public String toString(){
        return this.getFirstName() + " " +this.getLastName();
    }



}
