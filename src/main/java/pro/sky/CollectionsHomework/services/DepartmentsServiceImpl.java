package pro.sky.CollectionsHomework.services;

import org.springframework.stereotype.Service;
import pro.sky.CollectionsHomework.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    private Map<String, Employee> employeesDepartment;
    public DepartmentsServiceImpl() {this.employeesDepartment = EmployeeServiceImpl.employees;}
    @Override
    public Employee maxSalary(int department) {
        return employeesDepartment.values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    @Override
    public Employee minSalary(int department) {
        return employeesDepartment.values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    @Override
    public String employeesByDepartment() {
        return "1 department:" + employeesDepartment.values().stream()
                .filter(e -> e.getDepartment() == 1)
                .collect(Collectors.toList()) +
                "2 department:" + employeesDepartment.values().stream()
                .filter(e -> e.getDepartment() == 2)
                .collect(Collectors.toList()) +
                "3 department:" + employeesDepartment.values().stream()
                .filter(e -> e.getDepartment() == 3)
                .collect(Collectors.toList());
    }
    @Override
    public Collection<Employee> employeesInDepartment(int department) {
        return employeesDepartment.values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
}
