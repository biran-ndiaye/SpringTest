package com.example.demosringappweb.controller;

import com.example.demosringappweb.model.Employee;
import com.example.demosringappweb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     *
     * @param model - Home
     * @return page Home
     */
    @GetMapping("/")
    public String home(Model model){
        Iterable<Employee> listEmployees = employeeService.getEmployees();
        model.addAttribute("employees",listEmployees);
        return "home";
    }

    @GetMapping("/deleteEmploye/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") final int id){
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:/");
    }
    /*
    * Update an employee
    * */

    @GetMapping("/updateEmployee/{id}")
    public String UpdateEmployee(Model model, @PathVariable("id") int id){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee",employee);
        return "updateEmployee";
    }
    /***
     * add an employee
     */
    @GetMapping("/addEmployee")
    public String addEmployee(){
        return "addEmployee";
    }
    /**
     * A
     * @param employee test
     * @return UpdateEmployee Page
     */
    @PostMapping("/saveEmployee")
    public ModelAndView saveEmploye(Employee employee){
        employeeService.saveEmployee(employee);
        return new ModelAndView("redirect:/");
    }
}
