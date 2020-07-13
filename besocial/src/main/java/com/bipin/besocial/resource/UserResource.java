package com.bipin.besocial.resource;

import com.bipin.besocial.config.WebSecurityConfig;
import com.bipin.besocial.domain.User;
import com.bipin.besocial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserResource {

    @Autowired
    UserService userService;

    //    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    WebSecurityConfig securityConfig;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping(path = "/addUser")
    public User addUser(@RequestBody User user) {

        System.out.println("PASSWORD ");
        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));

        System.out.println("PASSWORD " + user.getPassword());

        return userService.save(user);

    }

//    @RequestMapping(method = )

    @DeleteMapping(path = "/user/{id}")
    public List<User> deleteUser(@PathVariable("id") Integer id) {
        System.out.println(id);
        userService.delete(id);
        return userService.findAll();
    }

    @PutMapping(path = "/user/{id}")
    public User editUser(@PathVariable("id") Integer id, @RequestBody User user) {
        final User updatedUser = userService.edit(id, user);
        return updatedUser;
    }
}
