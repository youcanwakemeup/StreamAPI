package pro.sky.CollectionsHomework.services;

import org.springframework.stereotype.Service;
import pro.sky.CollectionsHomework.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
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
        Map<Integer, List<Employee>> employeesByDepartment = employeesDepartment.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, List<Employee>> entry : employeesByDepartment.entrySet()) {
            int department = entry.getKey();
            List<Employee> employees = entry.getValue();
            result.append(department).append(" отдел: ").append(employees);
        }
        return result.toString();
    }
    @Override
    public Collection<Employee> employeesInDepartment(int department) {
        return employeesDepartment.values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
}
