package pro.sky.CollectionsHomework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.CollectionsHomework.exceptions.EmployeeAlreadyAddedException;
import pro.sky.CollectionsHomework.exceptions.EmployeeNotFoundException;
import pro.sky.CollectionsHomework.exceptions.NameIsNotCorrectException;
import pro.sky.CollectionsHomework.services.EmployeeService;
import pro.sky.CollectionsHomework.services.EmployeeServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeServiceTest {
    Employee testEmployee = new Employee("Artur", "Pirozhkov", 30000, 2);
    private EmployeeService employeeService;
    private Map<String, Employee> employees = new HashMap<>();
    @BeforeEach
    public void setUp() {
        this.employeeService = new EmployeeServiceImpl(employees);
    }
    @Test
    public void checkIfNameIsCorrectWhileAdding() {
        Assertions.assertThrows(NameIsNotCorrectException.class, () -> employeeService.addEmployee("Anton228", "Vasilyev", 40000, 3));
    }
    @Test
    public void checkIfDuplicateEmployee() {
        employees.put(testEmployee.getFullName(), testEmployee);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee("Artur", "Pirozhkov", 30000, 2));
    }
    @Test
    public void checkIfEmployeeAdded() {
        employeeService.addEmployee("Artur", "Pirozhkov", 30000, 2);
        employees.put(testEmployee.getFullName(), testEmployee);
        Assertions.assertEquals(employees, employeeService.getEmployees());
    }
    @Test
    public void checkIfNameIsCorrectWhileRemoving() {
        Assertions.assertThrows(NameIsNotCorrectException.class, () -> employeeService.removeEmployee("Anton228", "Vasilyev", 40000, 3));
    }
    @Test
    public void checkIfEmployeeDoesNotExist() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.removeEmployee("Artur", "Pirozhkov", 30000, 2));
    }
    @Test
    public void checkIfEmployeeRemoved() {
        employees.put(testEmployee.getFullName(), testEmployee);
        employeeService.addEmployee("Anton", "Kolesnikov", 50000, 4);
        employeeService.removeEmployee("Anton", "Kolesnikov", 50000, 4);
        Assertions.assertEquals(employees, employeeService.getEmployees());
    }
    @Test
    public void checkIfEmployeeDoesNotExistWhileFinding() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee("Artur", "Pirozhkov", 30000, 2));
    }
    @Test
    public void checkIfNameIsCorrectWhileFinding() {
        Assertions.assertThrows(NameIsNotCorrectException.class, () -> employeeService.findEmployee("Anton228", "Vasilyev", 40000, 3));
    }
    @Test
    public void checkIfEmployeeFound() {
        employeeService.addEmployee("Artur", "Pirozhkov", 30000, 2);
        Assertions.assertEquals(testEmployee, employeeService.findEmployee("Artur", "Pirozhkov", 30000, 2));
    }
}
