package com.greenfoxacademy.web;

import com.greenfoxacademy.web.servicecolors.BlueColor;
import com.greenfoxacademy.web.servicecolors.GreenColor;
import com.greenfoxacademy.web.servicecolors.MyColor;
import com.greenfoxacademy.web.servicecolors.RedColor;
import com.greenfoxacademy.web.servicehellobean.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication implements CommandLineRunner {

    Printer printer;
    MyColor myColor;

    @Autowired
    WebApplication(Printer printer,  BlueColor myColor){
        this.printer = printer;
        this.myColor = myColor;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        myColor.printColor();
    }
}
