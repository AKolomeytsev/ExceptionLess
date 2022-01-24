package pro.sky.ExceptionLess.Interfaces;

import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.ArrayFullException;
import pro.sky.ExceptionLess.Exceptions.NoFindEmployeeException;
import pro.sky.ExceptionLess.Exceptions.TheEntryIsDuplicatedExeption;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    void add(String firstName,String lastName,int otdel,double salary) throws TheEntryIsDuplicatedExeption;

    private boolean isEmployee(Employee obj) {
        return false;
    }

    Map<Integer, Employee> delete(int index);
    Employee findById(int index) throws NoFindEmployeeException;
    List<Employee> getMaxSalary(int otdelId);
    List<Employee> getMinSalary(int otdelId);
    List<Employee> getEmployeesOtdel(int otdelId);

    List<Employee> getEmployeesOtdel();
}
