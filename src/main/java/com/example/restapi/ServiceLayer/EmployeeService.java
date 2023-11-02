package com.example.restapi.ServiceLayer;

import com.example.restapi.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getEmployee();
    Employee byId(Long id);
    Employee update(Employee employee,Long id);
    void delete(Long id);
    void deletebyid(Long id);

}
