package pro.sky.CollectionsHomework.services;

import org.springframework.stereotype.Service;
import pro.sky.CollectionsHomework.Employee;
import pro.sky.CollectionsHomework.exceptions.EmployeeAlreadyAddedException;
import pro.sky.CollectionsHomework.exceptions.EmployeeNotFoundException;
import pro.sky.CollectionsHomework.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public static Map<String, Employee> employees;
    protected EmployeeServiceImpl() {
        employees = new HashMap<>();}

    @Override
    public Employee removeEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
                if (employees.containsKey(employee.getFullName())) {
                    return employees.remove(employee);

                }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже добавлен");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }
    @Override
    public Employee findEmployee(String firstName, String lastName,  int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
    @Override
    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
