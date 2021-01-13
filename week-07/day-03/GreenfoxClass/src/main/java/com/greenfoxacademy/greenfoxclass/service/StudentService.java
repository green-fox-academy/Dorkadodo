package com.greenfoxacademy.greenfoxclass.service;

import java.util.List;

public interface StudentService {

    public List<String> findAll();

    public void save(String student);

    public Integer count();

    public String check(String name);

    public void createNames ();
}
