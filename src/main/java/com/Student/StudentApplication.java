package com.Student;

import com.Student.Dao.UserRepo;
import com.Student.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication   {
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}


}
