package com.tcsc.budgetAndExpense.repositories;

import com.tcsc.budgetAndExpense.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {

}
