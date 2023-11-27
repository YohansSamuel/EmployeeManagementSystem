package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     * Create an employee
     * @param employee
     * @return
     */
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    /**
     * Get an employee by ID
     * @param id
     * @return
     */
    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    /**
     * Get all employees
     * @return
     */
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    /**
     * Update employee
     * @param employee
     * @return
     */
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    /**
     * Delete Employee by Id
     * @param id
     * @return
     */
    @DeleteMapping("/deleteEmployeeById/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }
}
