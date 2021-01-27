package com.greenfoxacademy.resttest;

import com.greenfoxacademy.resttest.controller.GuardianController;
import com.greenfoxacademy.resttest.model.GrootTranslator;
import com.greenfoxacademy.resttest.model.ErrorMessage;
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

        ErrorMessage mockErrorMessage = new ErrorMessage("I am ErrorMessage Groot!");
        when(guardianService.error()).thenReturn(mockErrorMessage);

        mockMvc.perform(get("/groot"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("error", is("I am ErrorMessage Groot!")))
                .andDo(print());
    }
}
