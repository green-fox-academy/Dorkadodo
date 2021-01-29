package com.greenfoxacademy.resttest;
import com.greenfoxacademy.resttest.service.GuardianService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class GuardianControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GuardianService guardianService;

    @BeforeEach
    public void emptyAmmoAmounts(){
        guardianService.setAmountOfAmmo(".25", 0);
        guardianService.setAmountOfAmmo(".30", 0);
        guardianService.setAmountOfAmmo(".50", 0);
    }

    @Test
    public void getEmptyIfCargoIsNull() throws Exception {
        mockMvc.perform(get("/rocket"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("caliber25", is(0)))
                .andExpect(jsonPath("shipstatus", is("empty")))
                .andExpect(jsonPath("ready", is(false)))
                .andDo(print());
    }

    @Test
    public void getCorrectPercent() throws Exception {
        mockMvc.perform(get("/rocket/fill")
                .param("caliber", ".25")
                .param("amount", "2500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("received", is(".25")))
                .andExpect(jsonPath("shipstatus", is("20%")))
                .andExpect(jsonPath("ready", is(false)))
                .andDo(print());
    }

    @Test
    public void getFullWhenHundredPercent() throws Exception {
        mockMvc.perform(get("/rocket/fill")
                .param("caliber", ".30")
                .param("amount", "12500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("received", is(".30")))
                .andExpect(jsonPath("shipstatus", is("full")))
                .andExpect(jsonPath("ready", is(true)))
                .andDo(print());
    }

    @Test
    public void getOverloadedWhenMorethanHundredPercent() throws Exception {
        mockMvc.perform(get("/rocket/fill")
                .param("caliber", ".30")
                .param("amount", "20500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("received", is(".30")))
                .andExpect(jsonPath("shipstatus", is("overloaded")))
                .andExpect(jsonPath("ready", is(false)))
                .andDo(print());
    }

    @Test
    public void getErrorMessageWhenNoAmountIsAdded() throws Exception {
        mockMvc.perform(get("/rocket/fill")
                .param("caliber", ".30"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("error", is("Provide the caliber and the loaded amount!")))
                .andDo(print());
    }
}
