package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.entity.Submission;
import com.challenge.mappers.CandidateMapper;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    private CandidateMapper candidateMapper;

    @PostMapping
    public Candidate save (Candidate candidate){
        return candidateService.save(candidate);
    }


    @GetMapping(value = "/{userId}/{companyId}/{accelerationId}")
    public Optional<CandidateDTO> findById(@PathVariable Long userId,@PathVariable  Long companyId,@PathVariable Long accelerationId) {

        return Optional.of(candidateMapper.map(candidateService.findById(userId, companyId, accelerationId).get()))   ;
    }

    @GetMapping("/byCompany/{companyId}")
    public List<CandidateDTO> findByCompanyId(@PathVariable Long companyId) {
        return candidateMapper.map(candidateService.findByCompanyId(companyId));
    }

    @RequestMapping("/byAcceleration/{accelerationId}")
    public List<CandidateDTO> findByAccelerationId(@PathVariable Long accelerationId) {
        return candidateMapper.map(candidateService.findByAccelerationId(accelerationId));
    }


}
