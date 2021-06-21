package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Read - Get all employees
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    /**
     * Read - Get An Employee
     * @param id {id of employee}
     * @return employee
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") final long id){
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employee.orElse(null);
    }

    /***
     *
     * @param id {employee to delete}
     */
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final long id){
        employeeService.deleteEmployee(id);
    }
    /***
     * Create -save an employee
     * @return the Employee added
     *
     */
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee e){
        return employeeService.saveEmployee(e);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") final long id, @RequestBody Employee employee){
        Optional<Employee> e = employeeService.getEmployee(id);
        if(e.isPresent()){
            Employee employeeToUpdate = e.get();
            if(employee.getFirstName() != null){
                employeeToUpdate.setFirstName(employee.getFirstName());
            }
            String lastName = employee.getLastName();
            if(lastName != null) {
                employeeToUpdate.setLastName(lastName);;
            }
            String email = employee.getEmail();
            if(email != null){
                employeeToUpdate.setEmail(email);
            }
            String password = employee.getPassword();
            if(password != null){
                employeeToUpdate.setPassword(password);
            }
            return employeeService.saveEmployee(employeeToUpdate);
        }else {
            return null;
        }

    }
}
