package pro.sky.ExceptionLess.Interfaces;

import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.ArrayFullException;
import pro.sky.ExceptionLess.Exceptions.NoFindEmployeeException;

import java.util.Map;
import java.util.stream.Stream;

public interface IEmployeeService {
    void add(String firstName,String lastName,int otdel,double salary) throws ArrayFullException;
    Map<Integer, Employee> delete(int index);
    Employee findById(int index) throws NoFindEmployeeException;
    Employee getMaxSalary(int otdelId);
    Employee getMinSalary(int otdelId);
    Stream<Employee> getEmployeesOtdel(int otdelId);
    Stream<Employee> getEmployeesOtdel();
}
