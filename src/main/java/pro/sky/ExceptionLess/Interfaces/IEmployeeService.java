package pro.sky.ExceptionLess.Interfaces;

import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.ArrayFullException;
import pro.sky.ExceptionLess.Exceptions.NoFindEmployeeException;

import java.util.Map;

public interface IEmployeeService {
    public void add(String firstName,String lastName) throws ArrayFullException;
    public Map<Integer, Employee> delete(int index);
    public Employee findById(int index) throws NoFindEmployeeException;
}
