package pro.sky.ExceptionLess.Interfaces;

import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.ArrayFullException;
import pro.sky.ExceptionLess.Exceptions.NoFindEmployeeException;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    void add(String firstName,String lastName,int otdel,double salary) throws ArrayFullException;
    Map<Integer, Employee> delete(int index);
    Employee findById(int index) throws NoFindEmployeeException;
    List<Employee> getMaxSalary(int otdelId);
    List<Employee> getMinSalary(int otdelId);
    List<Employee> getEmployeesOtdel(int otdelId);

    List<Employee> getEmployeesOtdel();
}
