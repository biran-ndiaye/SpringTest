package com.example.demosringappweb;

import com.example.demosringappweb.model.Employee;
import com.example.demosringappweb.repository.EmployeeProxy;
import com.example.demosringappweb.service.EmployeeService;
import org.assertj.core.internal.Iterators;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoSringAppWebApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Test Get All Employees
     * */
    @Test
    public void testGetEmployees() throws Exception{
        String expected = "Laurent";
        String result = employeeService.getEmployees().iterator().next().getFirstName();
        System.out.println(employeeService.getEmployees());
        assertEquals(expected,result);
    }

    /**
     * Test Get an Employees
     * */
    @Test
    public void testGetEmployee() throws Exception{
        String expected = "Biran";
        String result = employeeService.getEmployee(9).getFirstName();
        System.out.println(employeeService.getEmployee(9));
        assertEquals(expected,result);
    }
    /**
     * Test add employee to API
     */
    @Test
    public void testAddEmployee(){
        //Add An Employee to API
        Employee e = new Employee("Ndongo", "Lo","test@test.com","abc123...");
        String expected = "Ndongo";
        String result = employeeService.saveEmployee(e).getFirstName();
        assertEquals(expected,result);
        System.out.println("SUCCESS TEST");

    }
    /**
     * Test update employee to API
     */
    @Test
    public void testUpdateEmployee(){
        //Add An Employee to API
        Employee e = new Employee("Ndongo", "Dia","test@test.com","abc123...");
        e.setId(13L);
        String expected = "Dia";
        String result = employeeService.saveEmployee(e).getLastName();
        assertEquals(expected,result);
        System.out.println("SUCCESS TEST");

    }
    /**
     * Test add employee to API
     */
    @Test
    public void testDeleteEmployee(){
        //Add An Employee to API
        employeeService.deleteEmployee(12);
        System.out.println("SUCCESS TEST");

    }
    @Test
    void contextLoads() {
    }

}
