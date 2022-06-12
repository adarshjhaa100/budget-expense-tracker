package com.tcsc.budgetAndExpense.repo;

import com.tcsc.budgetAndExpense.entity.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestUserRepo extends JpaRepository<TestUser, Integer>{
    public List<TestUser> findByEmail(String email);
}
