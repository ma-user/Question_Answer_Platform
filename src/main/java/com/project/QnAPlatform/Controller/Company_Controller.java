package com.project.QnAPlatform.Controller;

import com.project.QnAPlatform.Model.Company;
import com.project.QnAPlatform.Service.Company_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/company")
public class Company_Controller {

    private final Company_Service companyService;

    @Autowired
    public Company_Controller(Company_Service companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies() { return companyService.getAllCompanies(); }

    @GetMapping
    @RequestMapping("/{id}")
    public Optional<Company> getCompany(@PathVariable Long id) { return companyService.getCompany(id); }

    @PostMapping
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Optional<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }
}
