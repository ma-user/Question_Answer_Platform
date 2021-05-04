package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Company_Repository;
import com.project.QnAPlatform.Model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Company_Service {

    private final Company_Repository companyRepository;

    @Autowired
    public Company_Service(Company_Repository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompany(Long id) {
        return companyRepository.findById(id);
    }

    public void addCompany(Company company) { companyRepository.saveAndFlush(company); }

    public Optional<Company> updateCompany(Long id, Company newCompany) {
        return companyRepository.findById(id)
                .map(company -> {
                    company.setCompanyName(newCompany.getCompanyName());
                    return companyRepository.saveAndFlush(company);
                });
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Company findCompanyById(Long companyId) {
        return companyRepository.findByCompanyId(companyId);
    }
}
