package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Company> findByAccelerationIdOrUserId(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> accelerationId)  {

        if(userId.isPresent()) return companyService.findByUserId(userId.get());
        else return accelerationId.map(aLong -> companyService.findByAccelerationId(aLong)).orElse(null);
    }



}
