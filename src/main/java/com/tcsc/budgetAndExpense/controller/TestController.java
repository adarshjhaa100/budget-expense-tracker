package com.tcsc.budgetAndExpense.controller;


import com.tcsc.budgetAndExpense.entity.TestUser;
import com.tcsc.budgetAndExpense.repo.TestUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    private final TestUserRepo testUserRepo;
    @Autowired
    public TestController(TestUserRepo testUserRepo) {
        this.testUserRepo = testUserRepo;
    }


    @GetMapping("sampleUser")
    public List<TestUser> getObjects(){
        return testUserRepo.findAll();
    }

    @PostMapping("sampleUser")
    public void addObject(@RequestBody TestUser obj){
        testUserRepo.save(new TestUser(obj));
    }




}
