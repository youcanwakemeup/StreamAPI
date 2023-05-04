package pro.sky.CollectionsHomework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.CollectionsHomework.Employee;
import pro.sky.CollectionsHomework.exceptions.EmployeeAlreadyAddedException;
import pro.sky.CollectionsHomework.exceptions.EmployeeNotFoundException;
import pro.sky.CollectionsHomework.exceptions.EmployeeStorageIsFullException;
import pro.sky.CollectionsHomework.services.EmployeeService;

import java.util.List;
@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping("/get")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
}
