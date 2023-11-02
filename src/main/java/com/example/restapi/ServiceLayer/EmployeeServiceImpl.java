package com.example.restapi.ServiceLayer;

import com.example.restapi.Employee;
import com.example.restapi.EmployeeRepository;
import com.example.restapi.ResourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee byId(Long id) {
        Optional<Employee> emp=employeeRepository.findById(id);
        if (emp.isPresent()){
            return emp.get();
        }else{
            throw new ResourseNotFoundException("Employee","id",id);
        }
    }

    @Override
    public void delete(Long id) {
        employeeRepository.findById(id).orElseThrow(()
                ->new ResourseNotFoundException("Employee","id",id));
        employeeRepository.deleteById(id);
    }

    @Override
    public void deletebyid(Long id) {

    }


    @Override
    public Employee update(Employee employee, Long id) {
        employee.setId(id);
        employeeRepository.findById(id).orElseThrow(()
                ->new ResourseNotFoundException("Employee","id",id));
        employeeRepository.save(employee);
        return employee;
    }

}
