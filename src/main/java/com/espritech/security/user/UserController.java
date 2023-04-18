package com.espritech.security.user;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    UserService userService;

    @PostMapping(value = "/auth/register")
    public UserDto save(@RequestBody  UserDto userDto) throws IOException {
        return userService.save(userDto);
    }

    @GetMapping("/users/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
