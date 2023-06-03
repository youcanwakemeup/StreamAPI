package pro.sky.CollectionsHomework.services;

import pro.sky.CollectionsHomework.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Employee removeEmployee(String firstName, String lastName, int salary, int department);
    Employee addEmployee(String firstName, String lastName, int salary, int department);
    Employee findEmployee(String firstName, String lastName, int salary, int department);
    Collection<Employee> getEmployees();
    Boolean validateInput(String firstName, String lastName);
}
