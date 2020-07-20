package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Company save (@Valid @RequestBody Company company){
        return companyService.save(company);
    }

    @GetMapping("/{id}")
    public Optional<Company> findById(@PathVariable("id") Long id) {
        return companyService.findById(id);
    }

    @GetMapping("/byAcceleration/{id}")
    public List<Company> findByAccelerationId(@PathVariable("id") Long accelerationId) {
        return companyService.findByAccelerationId(accelerationId);
    }

    @GetMapping("/byUser/{id}")
    public List<Company> findByUserId(@PathVariable("id") Long userId) {
        return companyService.findByUserId(userId);
    }


}
