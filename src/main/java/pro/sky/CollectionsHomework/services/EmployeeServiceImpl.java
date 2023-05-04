package pro.sky.CollectionsHomework.services;

import org.springframework.stereotype.Service;
import pro.sky.CollectionsHomework.Employee;
import pro.sky.CollectionsHomework.exceptions.EmployeeAlreadyAddedException;
import pro.sky.CollectionsHomework.exceptions.EmployeeNotFoundException;
import pro.sky.CollectionsHomework.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private final int maxEmployees = 5;

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
                for (Employee employee : employees) {
                    if (employee.equals(temp)) {
                        employees.remove(temp);
                        return temp;
                    }
                }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("Нельзя добавлять больше сотрудников");
        }
        Employee temp = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employee.equals(temp)) {
                throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
            }
        }
        employees.add(temp);
        return temp;
    }
    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employee.equals(temp)) {
                return temp;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
    @Override
    public List<Employee> getEmployees() {
        return employees;
    }
}
