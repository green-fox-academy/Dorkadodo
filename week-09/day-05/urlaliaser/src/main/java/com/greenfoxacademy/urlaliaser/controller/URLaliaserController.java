package com.greenfoxacademy.urlaliaser.controller;

import com.greenfoxacademy.urlaliaser.model.SecretCodeDTO;
import com.greenfoxacademy.urlaliaser.model.URLalias;
import com.greenfoxacademy.urlaliaser.service.URLaliaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class URLaliaserController {

    @Autowired
    private URLaliaserService urLaliaserService;

    @GetMapping ("/")
    public String mainPage(Model model, @RequestParam (required = false) Long id, @RequestParam (required = false) String url, @RequestParam(required = false) String alias){
        if (!(id==null)) {
            URLalias urLalias = urLaliaserService.getURLaliasByID(id);
            model.addAttribute("URLalias", urLalias);
        }
        if (!((url == null) && (alias == null))){
            model.addAttribute("message", "Your alias is already in use!");
            model.addAttribute("url", url);
            model.addAttribute("alias", alias);
        }
        return "index";
    }

    @PostMapping ("/save-link")
    public String storeNewData(@RequestParam String url, @RequestParam String alias, Model model){
        if (urLaliaserService.isAliasInUse(alias)){
            model.addAttribute("message", "Your alias is already in use!");
            model.addAttribute("url", url);
            model.addAttribute("alias", alias);
            return "redirect:/?url=" + url + "&alias=" + alias;
        }
        URLalias urLalias = urLaliaserService.addNewURLalias(url, alias);
        return "redirect:/?id=" + urLalias.getId();
    }

    @GetMapping("/a/{alias}")
    public ResponseEntity<?> redirect(@PathVariable String alias){
        URLalias url = urLaliaserService.getURLaliasByAlias(alias);
        if (url == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        url.setHitCount(url.getHitCount() + 1);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", url.getUrl());
        return new ResponseEntity<>(headers,HttpStatus.PERMANENT_REDIRECT);
    }

    @GetMapping("/api/links")
    public ResponseEntity<?> listOfStoredURL(){
        return ResponseEntity.ok(urLaliaserService.getAllUrlAliases());
    }

    @DeleteMapping("/api/Links/{id}")
    public ResponseEntity<?> deleteById (@PathVariable Long id, @RequestBody (required = false) SecretCodeDTO secretCode){
        if (secretCode == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!(urLaliaserService.doesSecretCodeMatch(id, secretCode))){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        urLaliaserService.deleteURLalias(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
