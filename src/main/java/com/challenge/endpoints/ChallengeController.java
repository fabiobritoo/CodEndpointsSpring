package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @PostMapping
    public Challenge save (@Valid @RequestBody Challenge challenge){
        return  challengeService.save(challenge);
    }


    @RequestMapping("/{accelerationId}/{userId}")
    public List<Challenge> findByAccelerationIdAndUserId(@PathVariable Long accelerationId, @PathVariable Long userId) {
        return challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }

    @GetMapping
    public List<Challenge> findByAccelerationIdOrUserId(@RequestParam Long accelerationId, @RequestParam Long userId)  {
        return challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }


}
