package com.Student.Services;

import com.Student.Models.Users;

public interface UserServices {

    Users findByEmailAndPassword(String email,String password);
}
