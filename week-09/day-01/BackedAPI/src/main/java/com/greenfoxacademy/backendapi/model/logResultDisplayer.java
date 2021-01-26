package com.greenfoxacademy.backendapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.greenfoxacademy.backendapi.repo.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class logResultDisplayer {

    @Autowired
    private LogRepository logRepository;
    private List<Log> entries;
    @JsonProperty("entry_count")
    private Integer entryCount;

    public logResultDisplayer(List<Log> entries){
        this.entries = entries;
        this.entryCount = entries.size();
    }

    public List<Log> getEntries() {
        return entries;
    }

    public void setEntries(List<Log> entries) {
        this.entries = entries;
    }

    public Integer getEntryCount() {
        return entryCount;
    }

    public void setEntryCount(Integer entryCount) {
        this.entryCount = entryCount;
    }
}
