package com.greenfoxacademy.spellchecker;

import com.greenfoxacademy.spellchecker.service.SpellChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpellcheckerApplication implements CommandLineRunner {

    private SpellChecker checker;

    @Autowired
    SpellcheckerApplication(SpellChecker checker) {
        this.checker = checker;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpellcheckerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        checker.checkSpelling();
    }
}