package pro.sky.CollectionsHomework.services;

import pro.sky.CollectionsHomework.Employee;

import java.util.Collection;

public interface DepartmentsService {
    Employee maxSalary(int department);
    Employee minSalary(int department);
    String employeesByDepartment();
    Collection<Employee> employeesInDepartment(int department);
}
