package com.example.javaSpringBoot.users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{userId}")
    public Optional<User> getUser(@PathVariable("userId") long id) {
        // return userService.getUser(id);
        return userRepository.findById(id);
    }

    @PostMapping("/signinwithgoogle")
    public void signInWithGoogle(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody User user) {
        userService.addNewUser(user);
    }

}
