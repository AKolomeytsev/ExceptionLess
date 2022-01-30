package pro.sky.ExceptionLess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.NotFoundDepartmentException;
import pro.sky.ExceptionLess.Services.DepatmenService;
import pro.sky.ExceptionLess.Services.EmployeeService;


import java.util.List;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepatmenService depatmenService;

    @BeforeEach
    void setUp(){
        Mockito.when(employeeService.getListEmployee()).thenReturn(List.of(
                new Employee("Коломейцев", "Артем", 1, 1432361)
                ,new Employee("Иванов", "Иван", 1, 143)
                ,new Employee("Петров", "Петр", 2, 500)
                ,new Employee("Адзинов", "Алексей", 2, 800)
        ));


    }

    @Test
    void getMinSalaryTest(){
        List<Employee> employeeMethodReturn = depatmenService.getMinSalary(1);
        Employee employeeHand =  new Employee("Иванов", "Иван", 1, 143);
        Assertions.assertEquals(employeeHand,employeeMethodReturn.get(employeeMethodReturn.size()-1));
        employeeMethodReturn = depatmenService.getMinSalary(2);
        employeeHand =  new Employee("Петров", "Петр", 2, 500);
        Assertions.assertEquals(employeeHand,employeeMethodReturn.get(employeeMethodReturn.size()-1));
    }

    @Test
    void getMaxSalaryTest(){
        List<Employee> employeeMethodReturn = depatmenService.getMaxSalary(1);
        Employee employeeHand =  new Employee("Коломейцев", "Артем", 1, 1432361);
        Assertions.assertEquals(employeeHand,employeeMethodReturn.get(employeeMethodReturn.size()-1));
        employeeMethodReturn = depatmenService.getMaxSalary(2);
        employeeHand =  new Employee("Адзинов", "Алексей", 2, 800);
        Assertions.assertEquals(employeeHand,employeeMethodReturn.get(employeeMethodReturn.size()-1));
    }

    @Test
    void getMaxSalaryForEmptyDepartmentTest(){
        Assertions.assertThrows(NotFoundDepartmentException.class,()->depatmenService.getMaxSalary(3));
    }

    @Test
    void getMinSalaryForEmptyDepartmentTest(){
        Assertions.assertThrows(NotFoundDepartmentException.class,()->depatmenService.getMinSalary(3));
    }

    @Test
    void getOtdelTest(){
        Assertions.assertThrows(NotFoundDepartmentException.class,()->depatmenService.getEmployeesOtdel(3));
    }
}
