package pro.sky.CollectionsHomework.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.CollectionsHomework.Employee;
import pro.sky.CollectionsHomework.exceptions.EmployeeAlreadyAddedException;
import pro.sky.CollectionsHomework.exceptions.EmployeeNotFoundException;
import pro.sky.CollectionsHomework.exceptions.EmployeeStorageIsFullException;
import pro.sky.CollectionsHomework.exceptions.NameIsNotCorrectException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public static Map<String, Employee> employees;
    protected EmployeeServiceImpl() {
        employees = new HashMap<>();}

    @Override
    public Employee removeEmployee(String firstName, String lastName, int salary, int department) {
        if (StringUtils.containsOnly(firstName, "[a-zA-Z]+") && StringUtils.containsOnly(lastName, "[a-zA-Z]+")) {
            firstName = StringUtils.capitalize(firstName);
            lastName = StringUtils.capitalize(lastName);
            Employee employee = new Employee(firstName, lastName, salary, department);
            if (employees.containsKey(employee.getFullName())) {
                return employees.remove(employee);
            }
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        else {
            throw new NameIsNotCorrectException("Имя или фамилия не верны!");
        }
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
