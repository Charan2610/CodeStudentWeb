package com.Student.Dao;

import com.Student.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByEmailAndPassword(String email,String password);
}
