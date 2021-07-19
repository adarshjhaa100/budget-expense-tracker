package com.tcsc.budgetAndExpense.controllers;

import com.tcsc.budgetAndExpense.models.AppUser;
import com.tcsc.budgetAndExpense.services.AppUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/users")
@RestController
public class AppUserController {
    private final AppUserServices userServices;
    @Autowired
    public AppUserController(AppUserServices services) {
        this.userServices = services;
    }

    @PostMapping
    public Map<String, Object> addUser(@RequestBody AppUser newUser){
        return userServices.addUser(newUser);
    }

    @PostMapping("logged")
    public AppUser getUserById(@RequestBody Map<String, String> req,@RequestHeader("Authorization") String header){
        Long userId= Long.parseLong(req.get("id"));
//        System.out.println(header);
        return userServices.getUserDetails(userId, header);
    }

    @PostMapping("logout")
    public Map<String, String> logout(@RequestBody Map<String, String> req, @RequestHeader("Authorization") String header){
        Long userId= Long.parseLong(req.get("id"));
//        System.out.println(header);
        return userServices.logoutUser(userId, header);
    }

    // login
    @PostMapping("login")
    public Map<String, Object> loginUser(@RequestBody AppUser user){
        return userServices.loginUser(
                user.getUsername(),
                user.getPassword(),
                user.getId()
        );
    }

    // remove before deploying
    @GetMapping
    public List<AppUser> getAllUsers(){
        return userServices.showAllUsers();
    }
}
