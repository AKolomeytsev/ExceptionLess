package pro.sky.ExceptionLess.Services;

import org.springframework.stereotype.Service;
import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.NoFindEmployeeException;
import pro.sky.ExceptionLess.Interfaces.IEmployeeService;
import pro.sky.ExceptionLess.Interfaces.Inject;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        this.employees.put(genId(),employee);
    }

    @Override
    public Map<Integer, Employee> delete(int index) {
        this.employees.remove(index);
        return getListEmployee();

    }

    @Override
    public Employee findById(int id) {
        Employee result = employees.get(id);
        if(employees.isEmpty()){
            throw new NoFindEmployeeException();
        }else{
            return result;
        }
    }


    public Map<Integer,Employee> getListEmployee() {
        return employees;
    }
    @Override
    public Employee getMaxSalary(int otdelId) {
        return employees.values().stream().filter(employee -> employee.getOldel() == otdelId)
                .max(Comparator.comparing(employee -> employee.getSalary())).get();

    }
    @Override
    public Employee getMinSalary(int otdelId) {
        return employees.values().stream().filter(employee -> employee.getOldel() == otdelId)
                .min(Comparator.comparing(employee -> employee.getSalary())).get();
    }
    @Override
    public Stream<Employee> getEmployeesOtdel(int otdelId) {
        return employees.values().stream().filter(employee -> employee.getOldel() == otdelId);

    }

    @Inject
    public Stream<Employee> getEmployeesOtdel() {

        return (Stream<Employee>) this.employees.values().stream().sorted(Comparator.comparing(Employee::getOldel));
    }
}
