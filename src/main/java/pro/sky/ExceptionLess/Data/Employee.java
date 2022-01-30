package pro.sky.ExceptionLess.Data;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import pro.sky.ExceptionLess.Exceptions.NotIsAlphaString;

import java.util.Objects;
@Repository
public class Employee {
    private String firstName;
    private String lastName;
    private int oldel;
    private double  salary;

    public Employee(String firstName, String lastName, int otdel, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.oldel = otdel;
        this.salary = salary;
    }
    public Employee(){}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(StringUtils.isEmpty(lastName) || !StringUtils.isAlpha(lastName)) {
            throw new NotIsAlphaString();
        }else{
            this.lastName = StringUtils.capitalize(lastName);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (StringUtils.isEmpty(firstName) || !StringUtils.isAlpha(firstName)) {
            throw new NotIsAlphaString();
        } else {
            this.firstName = StringUtils.capitalize(firstName);
        }
    }

    public boolean equals(Employee obj){
        return this.firstName.equals(obj.getFirstName()) && this.lastName.equals(obj.getLastName()) && this.oldel == obj.getOtdel() & this.salary == obj.getSalary();
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
