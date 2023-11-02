package com.example.restapi.ControllerLayer;

import com.example.restapi.Employee;
import com.example.restapi.EmployeeRepository;
import com.example.restapi.ServiceLayer.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    private EmployeeService employeeService;
    @Autowired
    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @RequestBody is to convert the data JSON to Java
    @PostMapping("/api/employees")
    public ResponseEntity<Employee> saveEmployeeDetails(@RequestBody Employee emp){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(emp), HttpStatus.CREATED);
    }


    @GetMapping("/api/get")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }
    @GetMapping("/api/{id}")
    public Employee getemp(@PathVariable("id")Long id){
        return this.employeeService.byId(id);
    }


    @DeleteMapping("/api/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        employeeService.delete(id);
        return new ResponseEntity<String>("Emplployee having "+id+"" +
                                                "deleted Successfully",
                                                    HttpStatus.NOT_FOUND);
    }


    @PutMapping("/api/{id}")
    public  ResponseEntity<String> update(@RequestBody Employee employee,
                                          @PathVariable("id")Long id){

        employeeService.update(employee,id);
        return new ResponseEntity<String>("Updated SuccessFully",
                                                    HttpStatus.NOT_FOUND);
    }
}
