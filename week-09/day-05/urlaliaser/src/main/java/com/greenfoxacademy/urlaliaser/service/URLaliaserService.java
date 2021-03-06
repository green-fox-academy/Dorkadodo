package com.greenfoxacademy.urlaliaser.service;

import com.greenfoxacademy.urlaliaser.model.SecretCodeDTO;
import com.greenfoxacademy.urlaliaser.model.URLalias;
import com.greenfoxacademy.urlaliaser.repo.URLaliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class URLaliaserService {

    @Autowired
    private URLaliasRepository urlaliasRepository;

    public Boolean isAliasInUse(String alias){
        List<String> aliasList = ((List<URLalias>)urlaliasRepository.findAll()).stream()
                .map(urLalias -> urLalias.getAlias())
                .collect(Collectors.toList());
        if (aliasList.contains(alias)){
            return true;
        }
        return false;
    }

    public URLalias addNewURLalias(String url, String alias){
        URLalias newURLalias = new URLalias(url, alias);
        urlaliasRepository.save(newURLalias);
        return newURLalias;
    }

    public URLalias getURLaliasByID(Long id){
        Optional<URLalias> optionalURLaliasurLalias = urlaliasRepository.findById(id);
        if (optionalURLaliasurLalias.isPresent()){
            return optionalURLaliasurLalias.get();
        }
        return null;
    }

    public URLalias getURLaliasByAlias(String alias){
        return urlaliasRepository.findFirstByAlias(alias);
    }

    public List<URLalias> getAllUrlAliases(){
        return (List<URLalias>)urlaliasRepository.findAll();
    }

    private Boolean doesIdExist (Long id){
        List<Long> idList = ((List<URLalias>)urlaliasRepository.findAll()).stream()
                .map(urLalias -> urLalias.getId())
                .collect(Collectors.toList());
        if (idList.contains(id)){
            return true;
        }
        return false;
    }

    public Boolean doesSecretCodeMatch(Long id, SecretCodeDTO secretCode){
        if(doesIdExist(id)){
            URLalias urLalias = urlaliasRepository.findById(id).get();
            if (urLalias.getSecretCode().equals(secretCode.getSecretCode())){
                return true;
            }
        }
        return false;
    }

    public void deleteURLalias(Long id){
        urlaliasRepository.deleteById(id);
    };
}
