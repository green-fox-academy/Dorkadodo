package com.greenfoxacademy.web.servicecolors;

import com.greenfoxacademy.web.servicehellobean.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedColor implements MyColor {

    Printer printer;

    @Autowired
    public RedColor(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void printColor() {
        String text = "This color is red.";
        printer.log(text);
    }
}
