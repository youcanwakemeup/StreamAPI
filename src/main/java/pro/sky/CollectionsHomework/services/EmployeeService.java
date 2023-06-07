package pro.sky.CollectionsHomework.services;

import pro.sky.CollectionsHomework.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee removeEmployee(String firstName, String lastName, int salary, int department);
    Employee addEmployee(String firstName, String lastName, int salary, int department);
    Employee findEmployee(String firstName, String lastName, int salary, int department);
    Map<String, Employee> getEmployees();
    Boolean validateInput(String firstName, String lastName);
}
