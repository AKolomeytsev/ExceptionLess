package pro.sky.ExceptionLess;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping(path = "/add")
    public String add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws ArrayFullException{
        Employee employee = new Employee(firstName,lastName);
        try {
            employeeService.add(employee);
            return "<div> Сотрудник: "+firstName+" "+lastName+" успешно добавлен!</div>"+"<div>"+employeeService.getLstEmployee()+"</div>";
        }catch (ArrayFullException exception){
            return "500 Internal Server ";
        }
    }
    @GetMapping(path = "/find")
    public String find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws NoFindEmployeeException {
        try {
            return employeeService.getEmployee(employeeService.findByName(firstName, lastName)).toString();
        }catch (NoFindEmployeeException exception){
            return "404 Not Found";
        }
    }
    @GetMapping(path = "/delete")
    public String delete(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws NoFindEmployeeException {
        try {
            employeeService.delete(employeeService.findByName(firstName, lastName));
            return  "<div>Сотрудник: " + firstName + " " + lastName + ", удален!</div>"+"<div>"+employeeService.getLstEmployee()+"</div>";
        }catch (NoFindEmployeeException exception){
            return "404 Not Found";
        }
    }

}
