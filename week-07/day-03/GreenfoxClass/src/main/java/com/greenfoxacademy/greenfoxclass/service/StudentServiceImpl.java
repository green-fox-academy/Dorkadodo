package com.greenfoxacademy.greenfoxclass.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private List<String> names;

    public StudentServiceImpl() {
        createNames();
    }

    @Override
    public void createNames (){
        names = new ArrayList<>();
        names.add("Sanyi");
        names.add("Lilla");
        names.add("John");
    }

    @Override
    public List<String> findAll() {
        return names;
    }

    @Override
    public void save(String student) {
        names.add(student);
    }

    @Override
    public Integer count(){
        return names.size();
    }

    @Override
    public String check(String name){
        if (names.contains(name)){
            return name + " is already a student.";
        }
        return name + " is not yet a student.";
    }
}