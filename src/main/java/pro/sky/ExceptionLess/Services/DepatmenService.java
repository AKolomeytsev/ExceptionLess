package pro.sky.ExceptionLess.Services;

import com.google.inject.Inject;
import org.springframework.stereotype.Service;
import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.NotFoundDepartmentException;
import pro.sky.ExceptionLess.Interfaces.IDepartmentService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class DepatmenService implements IDepartmentService {
    private final EmployeeService employeeService;

    public DepatmenService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public List<Employee> getMaxSalary(int departmentId) {
        List<Employee> returnList = employeeService.getListEmployee().stream().filter(employee -> employee.getOtdel() == departmentId)
                .max(Comparator.comparing(Employee::getSalary)).stream().toList();
        if(returnList.size() == 0){
            throw new NotFoundDepartmentException();
        }
        return returnList;

    }
    @Override
    public List<Employee> getMinSalary(int departmentId) {
        List<Employee> returnList = employeeService.getListEmployee().stream().filter(employee -> employee.getOtdel() == departmentId)
                .min(Comparator.comparing(Employee::getSalary)).stream().toList();
        if(returnList.size() == 0){
            throw new NotFoundDepartmentException();
        }
        return returnList;
    }
    @Override
    public List<Employee> getEmployeesOtdel(int departmentId) {
        List<Employee> returnList = employeeService.getListEmployee().stream().filter(employee -> employee.getOtdel() == departmentId).toList();
        if(returnList.size() == 0){
            throw new NotFoundDepartmentException();
        }
        return returnList;

    }

    @Inject
    public List<Employee> getEmployeesOtdel() {
        return this.employeeService.getListEmployee().stream().sorted(Comparator.comparing(employee -> employee.getOtdel())).toList();
    }
}
