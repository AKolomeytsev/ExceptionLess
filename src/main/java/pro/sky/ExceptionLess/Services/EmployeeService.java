package pro.sky.ExceptionLess.Services;

import org.springframework.stereotype.Service;
import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.NoFindEmployeeException;
import pro.sky.ExceptionLess.Interfaces.IEmployeeService;

import java.util.HashMap;
import java.util.Map;

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
    public void add(String firstName,String lastName){
        Employee employee = new Employee(firstName,lastName);
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
}
