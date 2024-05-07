package org.employee.controller;

import org.apache.coyote.Response;
import org.employee.beans.Employee;
import org.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empl")
public class EmployeeController {

    @Autowired
    EmployeeService service;
    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        String msg = service.addEmployee(employee);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getALLEmployees() {
        List<Employee> list = service.findAllEmployees();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/bysal/{salary}")
    public ResponseEntity<List<Employee>> getEmployeesBySal(@PathVariable("salary") double sal){
        List<Employee> list = service.findBySalary(sal);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}