package com.example.demosringappweb.service;

import com.example.demosringappweb.model.Employee;
import com.example.demosringappweb.repository.EmployeeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeProxy employeeProxy;

    /**
     *
     * @param id {id of employee}
     * @return an Employee
     */
    public Employee getEmployee(final int id){
        return employeeProxy.getEmployee(id);
    }

    /**
     *
     * @return Iterable Employee
     */
    public Iterable<Employee> getEmployees(){
        return employeeProxy.getEmployees();
    }

    /**
     *
     * @param id {id employee to delete}
     */
    public void deleteEmployee(final int id){
        employeeProxy.deleteEmpoyee(id);
    }

    /**
     *
     * @param e {Employee to creat or to update}
     * @return Employee saved
     */
    public Employee saveEmployee(Employee e){
        Employee savedEmployee;
        if(e.getId()== null){
            savedEmployee = employeeProxy.createEmployee(e);
        }else {
            savedEmployee = employeeProxy.updateEmployee(e);
        }
        return savedEmployee;
    }

}
