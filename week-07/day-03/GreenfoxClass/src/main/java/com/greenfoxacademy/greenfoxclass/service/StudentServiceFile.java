package com.greenfoxacademy.greenfoxclass.service;

import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceFile implements StudentService {

    private List<String> names;

    @Override
    public void createNames() {
        names = new ArrayList<>();
        names.add("Sanyi");
        names.add("Lilla");
        names.add("John");
    }

    private List<String> readFile (){
        Path path = Paths.get("names.txt");
        List<String> names = new ArrayList<>();
return names;
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
    public Integer count() {
        return names.size();
    }

    @Override
    public String check(String name) {
        Optional<String> optionalname = names.stream()
                .filter(n -> n.equals(name))
                .findAny();
        if (optionalname.isPresent()) {
            return name + " is already a student.";
        }
        return name + " is not yet a student.";
    }
}