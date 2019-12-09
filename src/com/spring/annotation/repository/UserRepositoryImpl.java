package com.spring.annotation.repository;

import com.spring.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//模拟会话层
@Repository("UserRepository")
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private TestObject testObject;
    @Override
    public void save() {
        System.out.println("UserRepository Save");
        System.out.println(testObject);
    }
}