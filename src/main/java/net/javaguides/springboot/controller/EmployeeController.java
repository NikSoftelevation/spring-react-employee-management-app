package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee getEmployeeById = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + "not found"));
        return new ResponseEntity<>(getEmployeeById, HttpStatus.OK);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with " + id));
        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setEmailId(employee.getEmailId());
        Employee updatedEmployee = employeeRepository.save(employeeToUpdate);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long id) {
        Employee employeeToDelete = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with " + id));
        employeeRepository.delete(employeeToDelete);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
