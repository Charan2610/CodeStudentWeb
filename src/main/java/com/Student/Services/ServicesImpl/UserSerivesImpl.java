package com.Student.Services.ServicesImpl;

import com.Student.Dao.UserRepo;
import com.Student.Models.Users;
import com.Student.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerivesImpl implements UserServices {

    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Users findByEmailAndPassword(String email, String password) {
        return userRepo.findByEmailAndPassword(email,password);
    }
}
