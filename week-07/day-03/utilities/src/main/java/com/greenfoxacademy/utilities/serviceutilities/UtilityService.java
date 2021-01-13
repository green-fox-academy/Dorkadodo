package com.greenfoxacademy.utilities.serviceutilities;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UtilityService {

    private List<String> colors;
    private Random random;

    public UtilityService() {
        colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("lime");
        colors.add("orange");
        colors.add("magenta");
        random = new Random();
    }

    public String randomColor() {
        return colors.get(random.nextInt(colors.size()));
    }

    public Boolean validateEmail(String email){
        boolean containsAt = false;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@'){
                containsAt = true;
            }
            if (containsAt){
                if (email.charAt(i)== '.'){
                    return true;
                }
            }
        }
        return false;
    }

    public String caesar(String text, int number) {
        if (number < 0) {
            number = 26 + number;
        }

        String result = "";
        for (int i = 0; i < text.length(); i++) {
            int offset = Character.isUpperCase(text.charAt(i)) ? 'A' : 'a';
            result += (char) (((int) text.charAt(i) + number - offset) % 26 + offset);
        }
        return result;
    }
}
