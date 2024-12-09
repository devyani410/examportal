package com.exam.examPortal;

import com.exam.examPortal.entity.User;
import com.exam.examPortal.services.UserService;
import com.exam.examPortal.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class ExamServerApplication   {

	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}
	@Autowired
	private UserService userService;

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Application started");
//
//		User user = new User();
//		user.setUserName("Deni1");
//		user.setPassword("Deni2910");
//		user.setFirstName("Devyani");
//		user.setLastName("Kumrawat");
//
//		System.out.println(userService.createUser(user,new HashSet<>()));
//	}
}
