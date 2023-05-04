package pro.sky.CollectionsHomework.services;

import pro.sky.CollectionsHomework.Employee;

import java.util.List;

public interface EmployeeService {
    Employee removeEmployee(String firstName, String lastName);
    Employee addEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> getEmployees();
}
