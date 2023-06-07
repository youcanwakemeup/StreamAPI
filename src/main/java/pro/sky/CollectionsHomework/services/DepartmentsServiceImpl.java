package pro.sky.CollectionsHomework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.CollectionsHomework.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    private final Map<String, Employee> employees;
    private EmployeeService employeeService;

    public DepartmentsServiceImpl(Map<String, Employee> employees, EmployeeServiceImpl employeeService) {
        this.employees = employees;
        this.employeeService = employeeService;
    }
    @Override
    public Employee maxSalary(int department) {
        return employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    @Override
    public Employee minSalary(int department) {
        return employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    @Override
    public Map<Integer, List<Employee>> employeesByDepartment() {
        return employeeService.getEmployees().values().stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .collect(Collectors.groupingBy(Employee::getDepartment));}
    @Override
    public Collection<Employee> employeesInDepartment(int department) {
        return employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    @Override
    public int salaryByDepartment(int department) {
        return employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();
    }
}
