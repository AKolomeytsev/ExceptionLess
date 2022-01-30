package pro.sky.ExceptionLess.Interfaces;

import pro.sky.ExceptionLess.Data.Employee;

import java.util.List;

public interface IDepartmentService {
    List<Employee> getMaxSalary(int otdelId);
    List<Employee> getMinSalary(int otdelId);
    List<Employee> getEmployeesOtdel(int otdelId);

    List<Employee> getEmployeesOtdel();
}
