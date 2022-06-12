package com.tcsc.budgetAndExpense.repo;

import com.tcsc.budgetAndExpense.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
