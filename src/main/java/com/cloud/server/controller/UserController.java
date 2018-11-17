 package com.cloud.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cloud.server.repository.UserRepository;
import com.cloud.server.model.User;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("/user")
public class UserController{

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/user")
	String home() {
		return "Insert User!";
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get_user")
  
    public List<User> index(){
        return userRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create_user")
    public User create(@RequestBody Map<String, String> body){
        String fname = body.get("first_name");
        String lname = body.get("last_name");
        String userName = body.get("user_name");
        String password = body.get("password");

        return userRepository.save(new User(fname,lname,userName,password));
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/user/verify_user")
    public List<User> search(@RequestBody Map<String, String> body){
        String userName = body.get("userName");
        String password = body.get("password");
        return userRepository.findUserByUsernamePassword(userName, password);
    }
 }