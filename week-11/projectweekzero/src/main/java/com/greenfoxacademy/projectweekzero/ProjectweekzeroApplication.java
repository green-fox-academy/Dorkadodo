package com.greenfoxacademy.projectweekzero;

import com.greenfoxacademy.projectweekzero.repo.MyUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = MyUserRepository.class)
public class ProjectweekzeroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectweekzeroApplication.class, args);
    }

}
