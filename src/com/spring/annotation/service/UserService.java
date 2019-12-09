package com.spring.annotation.service;

import com.spring.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//模拟业务层
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void add(){
        System.out.println("UserService add ...");
        userRepository.save();
    }
}