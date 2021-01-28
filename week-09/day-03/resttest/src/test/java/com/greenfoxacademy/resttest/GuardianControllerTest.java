package com.greenfoxacademy.resttest;

import com.greenfoxacademy.resttest.controller.GuardianController;
import com.greenfoxacademy.resttest.model.*;
import com.greenfoxacademy.resttest.service.GuardianService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(GuardianController.class)
public class GuardianControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @MockBean
    private GuardianService guardianService;

    @Test
    public void getGrootMessageAfterCorrectInput() throws Exception {
        String message = "some message";
        GrootTranslator mockGrootTranslator = new GrootTranslator(message);
        when(guardianService.translateToGroot(message)).thenReturn(mockGrootTranslator);

        mockMvc.perform(get("/groot")
                .param("message", "some message"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("translated", is("I am Groot!")))
                .andDo(print());
    }

    @Test
    public void getGrootMessageAfterNullInput() throws Exception {

        ErrorMessage mockErrorMessage = new ErrorMessage("I am Error Groot!");
        when(guardianService.error("I am Error Groot!")).thenReturn(mockErrorMessage);

        mockMvc.perform(get("/groot"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("error", is("I am Error Groot!")))
                .andDo(print());
    }

    @Test
    public void getYondusArrowSpeedCorrectInput() throws Exception {
        Double distance = 100.0;
        Double time = 10.0;
        SpeedCalculator mockSpeedCalculator = new SpeedCalculator(distance, time);
        when(guardianService.youndusArrow(distance, time)).thenReturn(mockSpeedCalculator);

        mockMvc.perform(get("/yondu")
                .param("distance", "100")
                .param("time", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("speed", is(10.0)))
                .andDo(print());
    }

    @Test
    public void getYondusArrowSpeedNullInput() throws Exception {

        ErrorMessage mockErrorMessage = new ErrorMessage("Please provide both distance and time parameters!");
        when(guardianService.error("Please provide both distance and time parameters!")).thenReturn(mockErrorMessage);

        mockMvc.perform(get("/yondu"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("error", is("Please provide both distance and time parameters!")))
                .andDo(print());
    }

    @Test
    public void getStatusOfShipCargoWithoutInput () throws Exception {
        WholeCargoDTO mockWholeCargo = new WholeCargoDTO(5, 10, 415, "3%", false);
        when(guardianService.getListOfCargo()).thenReturn(mockWholeCargo);

        mockMvc.perform(get("/rocket"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("caliber25", is(5)))
                .andExpect(jsonPath("shipstatus", is("3%")))
                .andDo(print());
    }

    @Test
    public void getStatusOfShipAfterFillingWithInput () throws Exception {
        String caliber = ".25";
        Integer amount = 500;
        ReceivedAmmunitionDTO mockReceivedAmmunitionDTO = new ReceivedAmmunitionDTO(caliber, amount, "15%", false);
        when(guardianService.fillCargoAndAnswer(caliber, amount)).thenReturn(mockReceivedAmmunitionDTO);
        when(guardianService.isExistingCaliber(caliber)).thenReturn(true);
        when(guardianService.isValidAmount(amount)).thenReturn(true);

        mockMvc.perform(get("/rocket/fill")
                .param("caliber", ".25")
                .param("amount", "500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("received", is(".25")))
                .andExpect(jsonPath("shipstatus", is("15%")))
                .andDo(print());
    }
}
