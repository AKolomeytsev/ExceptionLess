package pro.sky.ExceptionLess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.NoFindEmployeeException;
import pro.sky.ExceptionLess.Exceptions.TheEntryIsDuplicatedExeption;
import pro.sky.ExceptionLess.Services.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

//import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private final Employee employee = new Employee("Коломейцев","Артем",1,1432361);
    private final int[] ArrayId = {0,1,2,3};
    //private final Employee employee = mock(Employee.class);
    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void TestAddEmployee(){
        assertDoesNotThrow(TheEntryIsDuplicatedExeption::new,employeeService.add(employee)) ;
    }

    @Test
    public void TestFindEmployeeById(){
        employeeService.add(employee);
        for(int i = 0;i<ArrayId.length;i++) {
            assertDoesNotThrow(NoFindEmployeeException::new, String.valueOf(employeeService.findById(i)));
        }
    }

    @Test
    public void TestDeleteEmployeeById(){
        employeeService.add(employee);
        for(int i = 0;i<ArrayId.length;i++) {
            assertDoesNotThrow(NoFindEmployeeException::new, String.valueOf(employeeService.delete(i)));
        }
    }
}
