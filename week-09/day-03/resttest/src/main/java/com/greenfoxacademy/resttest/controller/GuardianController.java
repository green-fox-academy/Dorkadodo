package com.greenfoxacademy.resttest.controller;

import com.greenfoxacademy.resttest.model.WholeCargoDTO;
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
            return new ResponseEntity<>(guardianService.error("I am Error Groot!"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(guardianService.translateToGroot(message));
    }

    @GetMapping("/yondu")
    public ResponseEntity<?> youndusArrow(@RequestParam (required = false) Double distance, @RequestParam (required = false) Double time){
        if (distance == null || time == null){
            return new ResponseEntity<>(guardianService.error("Please provide both distance and time parameters!"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(guardianService.youndusArrow(distance, time));
    }

    @GetMapping("/rocket")
    public ResponseEntity<WholeCargoDTO> rocketsAmmunition (){
        return ResponseEntity.ok(guardianService.getListOfCargo());
    }

    @GetMapping("/rocket/fill")
    public ResponseEntity<?> fillCargo(@RequestParam (required = false) String caliber, @RequestParam (required = false) Integer amount){
        if (caliber == null || amount == null){
            return new ResponseEntity<>(guardianService.error("Provide the caliber and the loaded amount!"), HttpStatus.BAD_REQUEST);
        }
        if (!(guardianService.isExistingCaliber(caliber))){
            return new ResponseEntity<>(guardianService.error("The given caliber doesn't exist!"), HttpStatus.BAD_REQUEST);
        }
        if (!(guardianService.isValidAmount(amount))){
            return new ResponseEntity<>(guardianService.error("Can't fill negative amount!"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(guardianService.fillCargoAndAnswer(caliber, amount));
    }
}
