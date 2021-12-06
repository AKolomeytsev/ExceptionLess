package pro.sky.ExceptionLess;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private List<Employee> employees;

    public EmployeeService(List<Employee> employees) {
        this.employees = employees;
    }


    public String getWelcome(){
        return "Welcome";
    }
    @Override
    public void add(Employee employee){
        this.employees.add(employee);
    }

    @Override
    public void delete(int index) {
        this.employees.remove(index);
    }

    @Override
    public int findByName(Employee employee) {
        int index = -1;
        for (int i = 0; i < this.employees.size(); i++) {
            if(this.employees.get(i)!=null) {
                if (this.employees.get(i).equals(employee)) {
                    index = i;
                    break;
                }
            }
        }
        if(index!=-1){
            return index;
        }else{
            throw new NoFindEmployeeException();
        }
    }

    public List<Employee> getListEmployee(){
        return this.employees;
    }
    public Employee getEmployee(int index){
        return this.employees.get(index);
    }


}
