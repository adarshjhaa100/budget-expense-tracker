package com.tcsc.budgetAndExpense.repo;

import com.tcsc.budgetAndExpense.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepo extends JpaRepository<TestEntity, Integer>{
    public List<TestEntity> findByEmail(String email);
}
