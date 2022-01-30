package pro.sky.ExceptionLess.Interfaces;

import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.NoFindEmployeeException;
import pro.sky.ExceptionLess.Exceptions.TheEntryIsDuplicatedExeption;

import java.util.List;

public interface IEmployeeService {
    void add(String firstName,String lastName,int otdel,double salary) throws TheEntryIsDuplicatedExeption;

    //private boolean isEmployee(Employee obj) {
    //    return false;
    //}
    List<Employee> delete(int index) throws NoFindEmployeeException;
    Employee findById(int index) throws NoFindEmployeeException;
    List<Employee> getListEmployee();

}
