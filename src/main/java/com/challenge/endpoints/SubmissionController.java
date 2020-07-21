package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Candidate;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    private SubmissionMapper submissionMapper;

    @PostMapping
    public Submission save (Submission submission){
        return submissionService.save(submission);
    }


    @GetMapping("/challenge{challengeId}/acceleration/{accelerationId}")
    public List<SubmissionDTO> findByChallengeIdAndAccelerationId(@PathVariable Long challengeId,@PathVariable Long accelerationId) {
        return submissionMapper.map(submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
    }
}
