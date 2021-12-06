package pro.sky.ExceptionLess;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping(path = "Post/add")
    public String add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        employeeService.add(new Employee(firstName,lastName));
        return "<div> Сотрудник: "+firstName+" "+lastName+" успешно добавлен!</div>"+"<div>"+employeeService.getListEmployee()+"</div>";
    }

    @GetMapping(path = "Get/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
       return employeeService.getEmployee(employeeService.findByName(new Employee(firstName,lastName)));
    }

    @GetMapping(path = "Delete/remove")
    public String delete(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
       employeeService.delete(employeeService.findByName(new Employee(firstName,lastName)));
       return  "<div>Сотрудник: " + firstName + " " + lastName + ", удален!</div>"+"<div>"+employeeService.getListEmployee()+"</div>";
    }

}
