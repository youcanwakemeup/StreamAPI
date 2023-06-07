package pro.sky.CollectionsHomework.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.CollectionsHomework.Employee;
import pro.sky.CollectionsHomework.services.DepartmentsService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequestMapping("/departments")
@RestController
public class DepartmentsController {
    private final DepartmentsService departmentsService;
    public DepartmentsController(DepartmentsService departmentsService) {this.departmentsService = departmentsService;}
    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int department) {
        return departmentsService.maxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam int department) {
        return departmentsService.minSalary(department);
    }

    @GetMapping("/all/{department}")
    public Collection<Employee> printEmployeesInDepartment(@PathVariable int department) {
        return departmentsService.employeesInDepartment(department);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> printAllEmployeesByDepartment() {
        return departmentsService.employeesByDepartment();
    }
    @GetMapping("/sum")
    public int totalSalaryByDepartment(@RequestParam int department) {
        return departmentsService.salaryByDepartment(department);
    }
}
