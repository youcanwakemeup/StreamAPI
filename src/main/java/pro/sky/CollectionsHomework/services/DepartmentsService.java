package pro.sky.CollectionsHomework.services;

import pro.sky.CollectionsHomework.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentsService {
    Employee maxSalary(int department);
    Employee minSalary(int department);
    Map<Integer, List<Employee>> employeesByDepartment();
    Collection<Employee> employeesInDepartment(int department);
    int salaryByDepartment(int department);
}
