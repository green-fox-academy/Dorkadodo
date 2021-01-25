package com.greenfoxacademy.backendapi.service;

import com.greenfoxacademy.backendapi.model.*;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    public ChangedValue doubledValue (Integer input){
        ChangedValue changedValue = new ChangedValue();
        changedValue.setReceived(input);
        changedValue.setResult(input * 2);
        return changedValue;
    }

    public ErrorMessage error(String message){
        return new ErrorMessage(message);
    }

    public Greeter getGreetingMessage (String name, String title){
        Greeter greeter = new Greeter();
        greeter.setWelcome_message(name, title);
        return greeter;
    }

    public Append appendString (String appendable){
        return new Append(appendable);
    }

    public ChangedUntilValue sumUntil (Integer changeUntil){
        ChangedUntilValue changedUntilValue = new ChangedUntilValue();
        Integer result = 0;
        for (int i = 0; i < changeUntil; i++) {
            result += i;
        }
        changedUntilValue.setResult();
    }
}
