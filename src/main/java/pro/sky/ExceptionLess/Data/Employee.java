package pro.sky.ExceptionLess.Data;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int oldel;
    private double  salary;

    public Employee(String firstName, String lastName, int otdel, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.oldel = otdel;
        this.salary = salary;
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

    public int getOtdel() {
        return this.oldel;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setOldel(int oldel) {
        this.oldel = oldel;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int hashCode() {
        return Objects.hash(this.getFirstName(), this.getLastName());
    }

    public String toString(){
        return this.getFirstName() + " " + this.getLastName() + " " + this.getOtdel() + " " + this.getSalary();
    }



}
