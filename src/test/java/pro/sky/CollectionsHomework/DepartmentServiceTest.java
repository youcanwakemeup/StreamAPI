package pro.sky.CollectionsHomework;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import pro.sky.CollectionsHomework.services.DepartmentsServiceImpl;
import pro.sky.CollectionsHomework.services.EmployeeServiceImpl;

import java.util.*;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @InjectMocks
    private DepartmentsServiceImpl out;
    @Mock
    private EmployeeServiceImpl employeeMock;
    private Map<String, Employee> employees;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        employees = new HashMap<>();
        employees.put("Artur Pirozhkov", new Employee("Artur", "Pirozhkov", 50000, 1));
        employees.put("Ivan Ivanov", new Employee("Ivan", "Ivanov", 60000, 1));
        employees.put("Anton Kolesnikov", new Employee("Anton", "Kolesnikov", 40000, 2));
        out = new DepartmentsServiceImpl(employees, employeeMock);

    }
    @Test
    public void testMaxSalary() {
        int department = 1;
        Employee expectedMaxSalaryEmployee = new Employee("Ivan", "Ivanov", 60000, 1);
        Employee actualMaxSalaryEmployee = out.maxSalary(department);
        Assertions.assertEquals(expectedMaxSalaryEmployee, actualMaxSalaryEmployee);
    }
    @Test
    public void testMaxSalaryWithEmptyDepartment() {
        int department = 1;
        Assertions.assertNull(out.maxSalary(4));
    }
    @Test
    public void testMinSalary() {
        int department = 1;
        Employee expectedMinSalaryEmployee = new Employee("Artur", "Pirozhkov", 50000, 1);
        Employee actualMinSalaryEmployee = out.minSalary(department);
        Assertions.assertEquals(expectedMinSalaryEmployee, actualMinSalaryEmployee);
    }
    @Test
    public void testMinSalaryWithEmptyDepartment() {
        int department = 1;
        Assertions.assertNull(out.minSalary(4));
    }
    @Test
    public void testSalaryInDepartment() {
        int department = 1;
        int expectedSalary = 110000;
        int actualSalary = out.salaryByDepartment(department);
        Assertions.assertEquals(expectedSalary, actualSalary);
    }
    @Test
    public void testSalaryInEmptyDepartment() {
        int department = 3;
        int expectedSalary = 0;
        int actualSalary = out.salaryByDepartment(department);
        Assertions.assertEquals(expectedSalary, actualSalary);
    }
    @Test
    public void testEmployeesByDepartment() {
        Map<Integer, List<Employee>> expectedEmployeesByDepartment = new HashMap<>();
        expectedEmployeesByDepartment.put(1, Arrays.asList(
                new Employee("Artur", "Pirozhkov", 50000, 1),
                new Employee("Ivan", "Ivanov", 60000, 1)
        ));
        expectedEmployeesByDepartment.put(2, Collections.singletonList(
                new Employee("Anton", "Kolesnikov", 40000, 2)
        ));

        Map<Integer, List<Employee>> actualEmployeesByDepartment = out.employeesByDepartment();
        Assertions.assertEquals(expectedEmployeesByDepartment, actualEmployeesByDepartment);
    }
    @Test
    public void testEmployeesByDepartmentEmpty() {
        Map<String, Employee> emptyEmployeesMap = Collections.emptyMap();
        when(employeeMock.getEmployees()).thenReturn(emptyEmployeesMap);
        Map<Integer, List<Employee>> actualEmployeesByDepartment = out.employeesByDepartment();
        Assertions.assertTrue(actualEmployeesByDepartment.isEmpty());
    }
    @Test
    public void testEmployeesInDepartment() {
        int department = 1;
        List<Employee> actual = new ArrayList<>();
        actual.add(new Employee("Ivan", "Ivanov", 60000, 1));
        actual.add(new Employee("Artur", "Pirozhkov", 50000, 1));
        Collection<Employee> expected = out.employeesInDepartment(department);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testEmployeesInEmptyDepartment() {
        int department = 3;
        List<Employee> actual = new ArrayList<>();
        Collection<Employee> expected = out.employeesInDepartment(department);
        Assertions.assertEquals(expected, actual);
    }
}



