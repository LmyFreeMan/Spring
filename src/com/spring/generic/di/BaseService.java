package com.spring.generic.di;


import org.springframework.beans.factory.annotation.Autowired;



public class BaseService<T> {

    @Autowired
    protected  BaseRepository repository;
    public void add(){
        System.out.println("add..");
        System.out.println(repository);
    }

}