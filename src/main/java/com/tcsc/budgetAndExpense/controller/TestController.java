package com.tcsc.budgetAndExpense.controller;


import com.tcsc.budgetAndExpense.entity.TestEntity;
import com.tcsc.budgetAndExpense.repo.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test1")
public class TestController {
    private final TestRepo testRepo;
    @Autowired
    public TestController(TestRepo testRepo) {
        this.testRepo = testRepo;
    }

    @GetMapping
    public List<TestEntity> getObjects(){
        return testRepo.findAll();
    }

    @PostMapping
    public void addObject(@RequestBody TestEntity obj){
        testRepo.save(new TestEntity(obj));
    }
}
