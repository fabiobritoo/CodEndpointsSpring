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
    Optional<User> findById(@PathVariable("id") Long userId) {
        return userService.findById(userId);
    }

    @GetMapping("/byAccelerationName/{name}")
    List<User> findByAccelerationName(@PathVariable("name") String name) {
        return userService.findByAccelerationName(name);
    }

    @GetMapping("/byCompany/{id}")
    List<User> findByCompanyId(@PathVariable("id") Long companyId) {
        return userService.findByCompanyId(companyId);
    }

}
