package com.tcsc.budgetAndExpense.repositories;

import com.tcsc.budgetAndExpense.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    
}