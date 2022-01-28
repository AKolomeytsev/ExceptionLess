package pro.sky.ExceptionLess.Services;

import com.google.inject.Inject;
import org.springframework.stereotype.Service;
import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.IsNotNullEmploeeObjectException;
import pro.sky.ExceptionLess.Exceptions.NoFindEmployeeException;
import pro.sky.ExceptionLess.Exceptions.TheEntryIsDuplicatedExeption;
import pro.sky.ExceptionLess.Interfaces.IEmployeeService;

import java.util.*;

@Service
public class EmployeeService implements IEmployeeService {
    private final Map<Integer,Employee> employees;
    private int id;
    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    private int genId(){
            return id++;
    }

    public String getWelcome(){
        return "Welcome";
    }
    @Override
    public void add(String firstName,String lastName,int otdel,double salary){
        Employee employee = new Employee(firstName,lastName,otdel,salary);
        if(!isEmployee(employee)){
            employees.put(genId(),employee);

        }else{
            throw new TheEntryIsDuplicatedExeption();
        }
    }

    private boolean isEmployee(Employee employee){
        boolean isFind = false;
        int i = 0;
        while (i<employees.size() && !isFind) {
            isFind = employees.get(i).equals(employee);
            i++;
        }
        return isFind;

    }


    @Inject
    public String add(Employee employee){
        if(employee!=null){
            if(!isEmployee(employee)){
                employees.put(genId(),employee);
            }else{
                throw new TheEntryIsDuplicatedExeption();
            }
        }else {
            throw new IsNotNullEmploeeObjectException();
        }

        return "Ok";
    }

    @Override
    public Map<Integer, Employee> delete(int index) {
        Employee result = employees.get(index);
        if(result == null){
            throw new NoFindEmployeeException();
        }else{
            employees.remove(index);
        }

        return getListEmployee();

    }

    @Override
    public Employee findById(int id) {
        Employee result = employees.get(id);
        if(employees.isEmpty() || result == null){
            throw new NoFindEmployeeException();
        }else{
            return result;
        }
    }


    public Map<Integer,Employee> getListEmployee() {
        return employees;
    }
    @Override
    public List<Employee> getMaxSalary(int departmentId) {
        return employees.values().stream().filter(employee -> employee.getOtdel() == departmentId)
                .max(Comparator.comparing(Employee::getSalary)).stream().toList();

    }
    @Override
    public List<Employee> getMinSalary(int departmentId) {
        return employees.values().stream().filter(employee -> employee.getOtdel() == departmentId)
                .min(Comparator.comparing(Employee::getSalary)).stream().toList();
    }
    @Override
    public List<Employee> getEmployeesOtdel(int departmentId) {
        return employees.values().stream().filter(employee -> employee.getOtdel() == departmentId).toList();

    }

    @Inject
    public List<Employee> getEmployeesOtdel() {
        return this.employees.values().stream().sorted(Comparator.comparing(employee -> employee.getOtdel())).toList();
    }
}
