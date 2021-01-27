package com.greenfoxacademy.backendapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.backendapi.model.ChangedResult;
import com.greenfoxacademy.backendapi.model.ChangedValue;
import com.greenfoxacademy.backendapi.model.ErrorMessage;
import com.greenfoxacademy.backendapi.service.MainService;
import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;

import static org.hamcrest.Matchers.is;

import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {

    @Autowired
    @MockBean
    private MainService mainService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void canReturnTheDoubledInput () throws Exception {

        Integer input = 5;
        ChangedValue mockChangedValue = new ChangedValue(5, 10);
        when(mainService.doubledValue(input)).thenReturn(mockChangedValue);

        mockMvc.perform(get("/doubling")
                .param("input", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("result", is(10)))
                .andDo(print());
    }

    @Test
    public void canReturnMessageForNullInput() throws Exception {
        ErrorMessage mockErrorMessage = new ErrorMessage("Please provide an input!");
        when(mainService.error("Please provide an input!")).thenReturn(mockErrorMessage);

        mockMvc.perform(get("/doubling"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("error", is("Please provide an input!")))
                .andDo(print());
    }
}
