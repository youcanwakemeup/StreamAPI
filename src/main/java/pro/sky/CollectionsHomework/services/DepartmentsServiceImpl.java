package pro.sky.CollectionsHomework.services;

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
    private Map<String, Employee> employeesDepartment;
    public DepartmentsServiceImpl() {this.employeesDepartment = EmployeeServiceImpl.employees;}
    EmployeeService employeeService = new EmployeeServiceImpl();
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
    public Map<Integer, List<Employee>> employeesByDepartment() {
        return employeeService.getEmployees().stream()
                .sorted(comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .collect(groupingBy(Employee::getDepartment));
    }
    @Override
    public Collection<Employee> employeesInDepartment(int department) {
        return employeesDepartment.values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
}
