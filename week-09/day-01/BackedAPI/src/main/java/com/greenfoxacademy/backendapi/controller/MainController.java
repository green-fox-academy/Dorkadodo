package com.greenfoxacademy.backendapi.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.backendapi.model.ArrayToChange;
import com.greenfoxacademy.backendapi.model.ChangedResult;
import com.greenfoxacademy.backendapi.model.Text;
import com.greenfoxacademy.backendapi.model.UntilNumber;
import com.greenfoxacademy.backendapi.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;
    private ObjectMapper objectMapper;

    @GetMapping("/doubling")
    public ResponseEntity<?> doubling(@RequestParam(required = false) Integer input) throws JsonProcessingException {
        mainService.addToLog("doubling", "{\"name\":\"" + input + "\"}");
        if (input == null) {
            return ResponseEntity.ok(mainService.error("Please provide an input!"));
        }
        return ResponseEntity.ok(mainService.doubledValue(input));
    }

    @GetMapping("/greeter")
    public ResponseEntity<?> greeter(@RequestParam(required = false) String name, @RequestParam(required = false) String title) throws JsonProcessingException {
        mainService.addToLog("doubling", "{\"name\":\"" + name + "\",\"title\":\"" + title + "\"}");
        if (name == null && title == null) {
            return new ResponseEntity(mainService.error("Please provide a name and a title!"), HttpStatus.BAD_REQUEST);
        }
        if (name == null) {
            return new ResponseEntity(mainService.error("Please provide a name!"), HttpStatus.BAD_REQUEST);
        }
        if (title == null) {
            return new ResponseEntity(mainService.error("Please provide a title!"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(mainService.getGreetingMessage(name, title));
    }

    @GetMapping("/appenda/{appendable}")
    public ResponseEntity<?> greeter(@PathVariable(required = false) String appendable) {
        mainService.addToLog("appenda", "{\"appendable\":\"" + appendable + "\"}");
        if (appendable == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(mainService.appendString(appendable));
    }

    @PostMapping("/dountil/{action}")
    public ResponseEntity<?> doUntil(@PathVariable String action, @RequestBody(required = false) UntilNumber untilNumber) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        mainService.addToLog("dountil", "{\"action\":\"" + action + "\"}" + objectMapper.writeValueAsString(untilNumber));
        if (untilNumber == null) {
            return new ResponseEntity(mainService.error("Please provide a number!"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(mainService.resultUntil(untilNumber.getUntil(), action));
    }

    @PostMapping("/arrays")
    public ResponseEntity<?> arrayChanger (@RequestBody (required = false) ArrayToChange arrayToChange) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        mainService.addToLog("arrays", objectMapper.writeValueAsString(arrayToChange));
        if (arrayToChange.getWhat() == null || arrayToChange.getNumbers() == null){
            return new ResponseEntity(mainService.error("Please provide what to do with the numbers!"), HttpStatus.BAD_REQUEST);
        }
        if (arrayToChange.getWhat().equals("double")){
            return ResponseEntity.ok(mainService.arrayDoubler (arrayToChange));
        }
        ChangedResult changedResult = mainService.arrayChanger (arrayToChange);
        if (changedResult == null){
            return new ResponseEntity(mainService.error("Please provide what to do with the numbers!"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(changedResult);
    }

//    @PostMapping("/sith")
//    public ResponseEntity<?> reverserOfSith (@RequestBody (required = false)Text text) throws JsonProcessingException {
//        objectMapper = new ObjectMapper();
//        mainService.addToLog("sith", objectMapper.writeValueAsString(text));
//
//        return;
//    }
}
