package com.tcsc.budgetAndExpense.services;

import com.tcsc.budgetAndExpense.models.AppUser;
import com.tcsc.budgetAndExpense.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppUserServices {
    private final AppUserRepo appUserRepo;
    @Autowired
    public AppUserServices(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    // Add new user
    public Map<String, Object> addUser(AppUser appUser){
        AppUser user=new AppUser(appUser.getUsername(),
                appUser.getPassword(),
                appUser.getEmail());
        appUserRepo.save(user);
        return user.addUserResponse();
    }

    public AppUser getUserDetailsById(Long id){
        return appUserRepo.findById(id).orElse(null);
    }

    // get details of a single user
    public AppUser getUserDetails(Long id,String token){
        AppUser user=appUserRepo.findById(id).orElse(null);
        if(user!=null){
            // if user exist and correct token
            if(user.getAuthToken().equals(token) && user.isTokenSet())
                return user;
            return null;
        }
        return null;
    }

    // this is just for testing , remove before deploy
    public List<AppUser> showAllUsers(){
        return appUserRepo.findAll();
    }

    /*user login:
    * this method generates and returns an auth token
    * the auth token is also saved to the database*/
    public Map<String,Object> loginUser(String username, String password, Long id) {
        AppUser user = this.getUserDetailsById(id);
        Map<String, Object> authResponse=new HashMap<>();
        if(user!=null){
            // if user exists
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                //credentials are correct
                user.generateToken();
                appUserRepo.save(user); // save user to the repo
                authResponse.put("status","login success");
                authResponse.put("token",user.getAuthToken());
                return authResponse;
            }
        }
        authResponse.put("status","login failed");
        return authResponse;
    }

    /*
    * Logout user
    * regenerate the token and logout
    * */
    public Map<String, String> logoutUser(Long id, String token){
        AppUser user=getUserDetails(id,token);
        Map<String, String> res=new HashMap<>();
        if(user!=null){
            user.generateToken();
            appUserRepo.save(user);
            res.put("status","success");
        }
        else{
            res.put("status","failed");
        }

        return res;
    }
}
