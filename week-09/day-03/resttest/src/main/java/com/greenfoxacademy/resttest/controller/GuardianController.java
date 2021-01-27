package com.greenfoxacademy.resttest.controller;

import com.greenfoxacademy.resttest.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

    @Autowired
    private GuardianService guardianService;

    @GetMapping("/groot")
    public ResponseEntity<?> translateToGroot (@RequestParam (required = false) String message){
        if (message == null){
            return new ResponseEntity<>(guardianService.error(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(guardianService.translateToGroot(message));
    }
}
