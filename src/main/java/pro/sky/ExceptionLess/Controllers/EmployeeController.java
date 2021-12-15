package pro.sky.ExceptionLess.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Services.EmployeeService;

import java.util.Map;
import java.util.stream.Stream;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping

    public String employee(){
        return employeeService.getWelcome();
    }

    @GetMapping(path = "add")
    public String add(String firstName,  String lastName, int otdel, double salary){
        employeeService.add(firstName,lastName,otdel,salary);
        return "<div> Сотрудник: "+firstName+" "+lastName+" успешно добавлен!</div>"+"<div>"+employeeService.getListEmployee()+"</div>";
    }

    @GetMapping(path = "find")
    public Employee find(int id) {
       return employeeService.findById(id);
    }

    @GetMapping(path = "remove")
    public Map<Integer, Employee> delete(int id) {
       return  employeeService.delete(id);
    }

    @GetMapping(path = "departments/max-salary")
    public Employee getEmploeesMaxSalary(int otdelId){
        return employeeService.getMaxSalary(otdelId);
    }

    @GetMapping(path = "departments/min-salary")
    public Employee getEmploeeysMinSalary(int otdelId){
        return employeeService.getMinSalary(otdelId);
    }

    @GetMapping(path = "departments/all")
    public Stream<Employee> getEmploeeysOtdel(int otdelId){
        return employeeService.getEmployeesOtdel(otdelId);
    }


}
