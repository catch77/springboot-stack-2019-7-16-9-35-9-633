package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employeeList = new ArrayList<>();

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeList;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id)
                return employeeList.get(i);
        }
        return null;
    }

    @GetMapping
    public List<Employee> getEmployeesByPage(@RequestParam int page, @RequestParam int pageSize) {
        List<Employee> list = new ArrayList<>();
        for (int i = page-1; i < pageSize; i++) {
            list.add(employeeList.get(i));
        }
        return list;
    }

    @GetMapping
    public List<Employee> getEmployeesByGender(@RequestParam String gender) {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getGender().equals(gender)) {
                list.add(employeeList.get(i));
            }
        }
        return list;
    }

    @PostMapping
    public Employee addemployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.remove(employeeList.get(i));
                employeeList.add(employee);
                return employee;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.remove(employeeList.get(i));
                return;
            }
        }
    }
}
