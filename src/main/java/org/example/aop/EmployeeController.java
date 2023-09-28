package org.example.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/emps")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEMp(@PathVariable int id) {
        employeeService.delete(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmp(@PathVariable int id) {
        return employeeService.update(id);
    }

    @GetMapping("/name-check")
    public boolean checkName(@RequestParam("name") String name) {
        return employeeService.isValidName(name);
    }
}
