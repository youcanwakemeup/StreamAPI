package pro.sky.CollectionsHomework.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.CollectionsHomework.Employee;
import pro.sky.CollectionsHomework.exceptions.EmployeeAlreadyAddedException;
import pro.sky.CollectionsHomework.exceptions.EmployeeNotFoundException;
import pro.sky.CollectionsHomework.exceptions.NameIsNotCorrectException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employees;

    public EmployeeServiceImpl(Map<String, Employee> employees) {
        this.employees = employees;
    }


    @Override
    public Employee removeEmployee(String firstName, String lastName, int salary, int department) {
        if (validateInput(firstName, lastName)) {
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
        if (validateInput(firstName, lastName)) {
            firstName = StringUtils.capitalize(firstName);
            lastName = StringUtils.capitalize(lastName);
            Employee employee = new Employee(firstName, lastName, salary, department);
            if (employees.containsKey(employee.getFullName())) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже добавлен");
            }
            employees.put(employee.getFullName(), employee);
            return employee;
        }
        else {
            throw new NameIsNotCorrectException("Имя или фамилия не верны!");
        }
    }

        @Override
        public Employee findEmployee(String firstName, String lastName,  int salary, int department) {
            if (validateInput(firstName, lastName)) {
                firstName = StringUtils.capitalize(firstName);
                lastName = StringUtils.capitalize(lastName);
                Employee employee = new Employee(firstName, lastName, salary, department);
                if (employees.containsKey(employee.getFullName())) {
                    return employee;
                }
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
            else {
                throw new NameIsNotCorrectException("Имя или фамилия не верны!");
            }
        }
    @Override
    public Map<String, Employee> getEmployees() {
        return employees;
    }
    @Override
    public Boolean validateInput(String firstName, String lastName) {
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
    }

}
