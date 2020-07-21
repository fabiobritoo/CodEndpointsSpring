package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable("id") Long userId) {
        return userService.findById(userId);
    }

    @GetMapping
    public List<User> findByAccelerationNameOrCompanyId(@RequestParam Optional<String> accelerationName,@RequestParam Optional<Long> companyId)  {

        if(accelerationName.isPresent()) return userService.findByAccelerationName(accelerationName.get());
        else return companyId.map(aLong -> userService.findByCompanyId(aLong)).orElse(null);
    }

}
