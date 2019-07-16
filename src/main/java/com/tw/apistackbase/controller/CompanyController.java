package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private List<Company> companyList = new ArrayList<>();

    @GetMapping
    public List<Company> getCompanies() {
        return companyList;
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable int id) {
        for (int i = 0; i < companyList.size(); i++) {
            if (companyList.get(i).getCompanyId() == id)
                return companyList.get(i);
        }
        return null;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByCompanyId(@PathVariable int id) {
        for (int i = 0; i < companyList.size(); i++) {
            if (companyList.get(i).getCompanyId() == id)
                return companyList.get(i).getEmployeeList();
        }
        return null;
    }

    @GetMapping()
    public List<Company> getCompaniesByPage(@RequestParam int page, @RequestParam int pageSize) {
        List<Company> list = new ArrayList<>();
        for (int i = page-1; i < pageSize; i++) {
            list.add(companyList.get(i));
        }
        return list;
    }

    @PostMapping
    public Company addCompany(Company company) {
        companyList.add(company);
        return company;
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable int id, @RequestBody Company company) {
        for (int i = 0; i < companyList.size(); i++) {
            if (companyList.get(i).getCompanyId() == id) {
                companyList.remove(companyList.get(i));
                companyList.add(company);
                return company;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable int id) {
        for (int i = 0; i < companyList.size(); i++) {
            if (companyList.get(i).getCompanyId() == id) {
                companyList.remove(companyList.get(i));
                return;
            }
        }
    }
}
