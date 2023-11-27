package com.example.ems.service;

import com.example.ems.exception.EmployeeNotFoundException;
import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * add an employee
     * @param employee
     * @return
     */
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Get an employee by id
     * @param id
     * @return
     */
    public Employee getEmployeeById(Long id) {
        if(employeeRepository.findById(id).isEmpty())
            throw new EmployeeNotFoundException("Employee does not exist with the id :" + id);
        return employeeRepository.findById(id).get();
        //return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException());
        //return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee does not exist with the id :" + id));
    }

    /**
     * Get all employees
     * @return
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getID()).orElseThrow(()-> new RuntimeException("Could not find the employee by the given id"));
        if(existingEmployee == null){
            return employeeRepository.save(employee);
        }
        else{
            existingEmployee.setName(employee.getName());
            existingEmployee.setAddress(employee.getAddress());
            existingEmployee.setSex(employee.getSex());
            existingEmployee.setAge(employee.getAge());
            employeeRepository.save(existingEmployee);
        }
        return employee;
    }

    public boolean deleteEmployeeById(Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee does not exist with the given id : " + id));
        if(existingEmployee != null){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
