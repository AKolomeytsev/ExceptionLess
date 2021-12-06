package pro.sky.ExceptionLess;

public interface IEmployeeService {
    public void add(Employee employee) throws ArrayFullException;
    public void delete(int index);
    public int findByName(Employee employee) throws NoFindEmployeeException;
}
