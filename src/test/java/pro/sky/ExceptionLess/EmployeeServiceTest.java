package pro.sky.ExceptionLess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.ExceptionLess.Data.Employee;
import pro.sky.ExceptionLess.Exceptions.NoFindEmployeeException;
import pro.sky.ExceptionLess.Exceptions.TheEntryIsDuplicatedExeption;
import pro.sky.ExceptionLess.Services.EmployeeService;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;



public class EmployeeServiceTest {

    static final EmployeeService employeeService = new EmployeeService();
    private Employee[] employees = new Employee[3];



    public static Stream<Employee> providerParamsForTestAddEmployeeDuplicatedExeption(){
        return Stream.of(
                new Employee("Коломейцев", "Артем", 1, 1432361)
                , new Employee("Иванов", "Иван", 1, 1432361)
                , new Employee("Петров", "Федор", 1, 1432361)
                , new Employee("Петров", "Федор", 1, 1432361)
        );
    }

    public static Stream<Employee> providerParamsForTestAddEmployeeEquals(){
        return Stream.of(
                new Employee("Адзинов", "Алексей", 2, 564)
                , new Employee("Иванов", "Иван", 2, 123)
                , new Employee("Федоров", "Иван", 1, 1432361)
        );
    }

    public static Stream<Integer> providerParamsForTestFindEmployee(){
        return Stream.of(
                0,1,2,3,4,5,6,7
        );
    }

    public static Stream<Integer> providerParamsForTestDeleteEmployee(){
        return Stream.of(
                0,1,2,3,4,5,6,7
        );
    }

    @ParameterizedTest
    @MethodSource("providerParamsForTestAddEmployeeDuplicatedExeption")
    public void TestAddEmployeeDuplicatedExeption(Employee employee){
        assertDoesNotThrow(TheEntryIsDuplicatedExeption::new, String.valueOf(employeeService.add(employee))) ;
    }

    @ParameterizedTest
    @MethodSource("providerParamsForTestAddEmployeeEquals")
    public void TestAddEmployeeEquals(Employee employee){
        Assertions.assertEquals(employee,employeeService.add(employee));
    }

    @ParameterizedTest
    @MethodSource("providerParamsForTestFindEmployee")
    public void TestEmployeeFind(int i){
        assertDoesNotThrow(NoFindEmployeeException::new, String.valueOf((Employee) employeeService.findById(i))) ;
    }

    @ParameterizedTest
    @MethodSource("providerParamsForTestDeleteEmployee")
    public void TestEmployeeDelete(int i){
        assertDoesNotThrow(NoFindEmployeeException::new, String.valueOf((Employee) employeeService.findById(i))) ;
    }
}
