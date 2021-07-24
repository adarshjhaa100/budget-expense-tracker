package com.tcsc.budgetAndExpense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BudgetExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetExpenseTrackerApplication.class, args);
	}


    // just to test run of spring app
    @GetMapping("testSiteRun")
    public String testAppRun(){
	    return "The app is running...";
    }

}
