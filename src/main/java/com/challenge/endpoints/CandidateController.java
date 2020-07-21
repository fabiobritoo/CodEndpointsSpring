package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    @PostMapping
    public Candidate save (Candidate candidate){
        return candidateService.save(candidate);
    }


    @GetMapping(value = "/{userId}/{accelerationId}/{companyId}")
    public Optional<CandidateDTO> findById(@PathVariable Long userId,@PathVariable  Long companyId,@PathVariable Long accelerationId) {

        return Optional.of(candidateMapper.map(candidateService.findById(userId, companyId, accelerationId).get()))   ;
    }

    @GetMapping
    public List<CandidateDTO> findByAccelerationNameOrCompanyId(@RequestParam Optional<Long> companyId, @RequestParam Optional<Long> accelerationId)  {

        if(companyId.isPresent()) return candidateMapper.map(candidateService.findByCompanyId(companyId.get()));
        else return candidateMapper.map(accelerationId.map(aLong -> candidateService.findByAccelerationId(aLong)).orElse(null));
    }




}
