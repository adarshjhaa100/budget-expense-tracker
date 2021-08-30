package com.tcsc.budgetAndExpense.services;

import com.tcsc.budgetAndExpense.models.AppUser;
import com.tcsc.budgetAndExpense.repositories.AppUserRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepo;
    private List<AppUser> users=new ArrayList<AppUser>();

    @Autowired
    AppUserService(AppUserRepository repo){
        this.appUserRepo=repo;
    }

    public void registerUser(AppUser user){
        users.add(new AppUser(user.getUsername(),
                              user.getPassword(),
                              user.getEmail(),
                              AppUser.generateAuthToken()));
    }

    public AppUser getUserDetailsByUsername(String username){
        return new AppUser("","","","");
    }

    public void loginUser(String username, String password){
//        appUserRepo.find
    }


}
