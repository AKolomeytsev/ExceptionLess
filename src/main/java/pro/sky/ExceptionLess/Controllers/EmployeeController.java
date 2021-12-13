package pro.sky.ExceptionLess.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Services.EmployeeService;

import java.util.Map;

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
    public String add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        employeeService.add(firstName,lastName);
        return "<div> Сотрудник: "+firstName+" "+lastName+" успешно добавлен!</div>"+"<div>"+employeeService.getListEmployee()+"</div>";
    }

    @GetMapping(path = "find")
    public Employee find(@RequestParam("id") int id) {
       return employeeService.findById(id);
    }

    @GetMapping(path = "remove")
    public Map<Integer, Employee> delete(@RequestParam("id") int id) {
       employeeService.delete(id);
        return  employeeService.delete(id);
    }

}
