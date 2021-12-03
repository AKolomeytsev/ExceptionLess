package pro.sky.ExceptionLess;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmployeeService implements IEmployeeService {
    private Employee[] employees;

    public EmployeeService() {
        this.employees = new Employee[10];
    }

    public String getWelcome(){
        return "Welcome";
    }
    @Override
    public void add(Employee employee){
        boolean flag = false;
        for (int i = 0; i < this.employees.length; i++) {
            if(this.employees[i] == null){
                this.employees[i] = employee;
                flag = true;
                break;
            }
        }
        if(!flag)
            throw new ArrayFullException();
    }

    @Override
    public void delete(int index) {
        this.employees[index] = null;
    }

    @Override
    public int findByName(String firstName, String lastName) {
        int index = -1;
        for (int i = 0; i < this.employees.length; i++) {
            if(this.employees[i]!=null) {
                if (this.employees[i].getFirstName().equals(firstName) && this.employees[i].getLastName().equals(lastName)) {
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

    public String getLstEmployee(){
        return Arrays.toString(this.employees);
    }
    public Employee getEmployee(int index){
        return this.employees[index];
    }
}
