package com.greenfoxacademy.web.servicecolors;

import com.greenfoxacademy.web.servicehellobean.Printer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GreenColor implements MyColor{

    @Autowired
    Printer printer;

    @Override
    public void printColor() {
        String text = "The last color is green.";
        printer.log(text);
    }
}
