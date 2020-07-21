package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private  AccelerationService accelerationService;

    @PostMapping
    public Acceleration save(@Valid @RequestBody Acceleration acceleration){
        return  accelerationService.save(acceleration);
    }

    @GetMapping("/{id}")
    public Optional<Acceleration> findById(@PathVariable("id") Long id) {
        return accelerationService.findById(id);
    }

    @GetMapping
    public List<Acceleration> findByCompanyId(@RequestParam Long companyId) {
        return accelerationService.findByCompanyId(companyId);
    }


}
