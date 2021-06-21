package com.example.demosringappweb.repository;


import com.example.demosringappweb.configuration.Customproperties;
import com.example.demosringappweb.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.http.HttpResponse;

@Slf4j
@Repository
public class EmployeeProxy {

    @Autowired
    private Customproperties props;

    /**
     * Get All Employees from API
     * @return An Iterable of all employees
     */
    public Iterable<Employee> getEmployees(){
        String baseApiUrl = props.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/employees";

        //Definir le restTemplate qui permet de configurer la requete
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(
                getEmployeesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }

        );
        return response.getBody();
    }
    /**
     * Get an Employee by id
     * @param id {id of employee to get}
     * @return Employee
     */
    public Employee getEmployee(final long id){
        String baseApiUrl = props.getApiUrl();
        String getEmployeeUrl = baseApiUrl + "/employee/"+id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response = restTemplate.exchange(
          getEmployeeUrl,
          HttpMethod.GET,
                null,
                Employee.class
        );
        return response.getBody();
    }
    /**
     * delete an employee by id
     * @param id {id of employee to delete}
     */
    public void deleteEmpoyee(final long id){
        String baseApiUrl = props.getApiUrl();
        String deleteEmployeeUrl = baseApiUrl + "/employee/"+id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteEmployeeUrl,
                HttpMethod.DELETE,
                null,
                Void.class
        );
    }
    /**
     *  Add an employee
     * @return e Saved Employee
     * @param e {employee to create}
     */
    public Employee createEmployee(Employee e){

        String baseApiUrl = props.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/employee";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response = restTemplate.exchange(
          getEmployeesUrl,
          HttpMethod.POST,
                new HttpEntity<>(e),
                Employee.class
        );
        return response.getBody();
    }

    /**
     *  Update an employee
     * @return e {updated employee}
     * @param e {existing employee to update}
     */
    public Employee updateEmployee(Employee e){
        String baseApiUrl = props.getApiUrl();
        String updateEmployeeUrl = baseApiUrl+ "/employee/"+e.getId();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response= restTemplate.exchange(
          updateEmployeeUrl,
          HttpMethod.PUT,
          new HttpEntity<>(e),
          Employee.class
        );
        return response.getBody();
    }


}
