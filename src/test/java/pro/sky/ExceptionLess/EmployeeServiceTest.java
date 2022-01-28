package pro.sky.ExceptionLess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.NoFindEmployeeException;
import pro.sky.ExceptionLess.Exceptions.NotIsAlphaString;
import pro.sky.ExceptionLess.Exceptions.TheEntryIsDuplicatedExeption;
import pro.sky.ExceptionLess.Services.EmployeeService;


import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class EmployeeServiceTest {

    private EmployeeService employeeService = new EmployeeService();
    private Employee[] employees = new Employee[3];

    @BeforeEach
    public void setting(){
        employees[0] = new Employee("Коломейцев", "Артем", 1, 1432361);
        employees[1] = new Employee("Иванов", "Иван", 1, 1432361);
        employees[2] = new Employee("Петров", "Федор", 1, 1432361);
    }

    public static Stream<Employee> providerParamsForTestAddEmployee(){
        return Stream.of(
                new Employee("Коломейцев", "Артем", 1, 1432361)
                , new Employee("Иванов", "Иван", 1, 1432361)
                , new Employee("Петров", "Федор", 1, 1432361)
                , new Employee("Петров", "Федор", 1, 1432361)
        );
    }

    public static Stream<Employee> providerParamsForTestAddEmployeeIsAlphaString(){
        return Stream.of(
                new Employee("Коломейцева", "Анна", 1, 1432361)
                ,new Employee("Иванова", "Наталья", 1, 1432361)
                ,new Employee("5етров", "иван", 1, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("providerParamsForTestAddEmployee")
    public void TestAddEmployee(Employee employee){
        assertDoesNotThrow(TheEntryIsDuplicatedExeption::new,employeeService.add(employee)) ;
    }

    @ParameterizedTest
    @MethodSource("providerParamsForTestAddEmployeeIsAlphaString")
    public void TestAddEmployeeIsAlphaString(Employee employee){
        assertDoesNotThrow(NotIsAlphaString::new, employeeService.add(employee)) ;

    }

    @Test
    public void TestFind(){
        for (int i = 0;i<employees.length;i++) {
            assertDoesNotThrow(NoFindEmployeeException::new, String.valueOf((Employee) employeeService.findById(i))) ;
        }
    }
    @Test
    public void TestDelete(){
        for (int i = 0;i<employees.length;i++) {
            assertDoesNotThrow(NoFindEmployeeException::new, String.valueOf((Employee) employeeService.delete(i))) ;
        }
    }
}
