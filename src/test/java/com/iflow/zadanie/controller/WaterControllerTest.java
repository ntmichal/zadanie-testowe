package com.iflow.zadanie.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.iflow.zadanie.exceptions.ErrorMessage;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WaterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private int[] EMPTY_ARRAY = new int[]{};
    private int[] ARRAY_WITH_ONE_ELEMENT = new int[]{1};
    private String ARRAY_IS_EMPTY = "Array is empty";
    private String WRONG_FORMAT = "Wrong data format";

    @Test
    void sendArrayPayloadIsEmptyThenIsBadRequest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/water")).andExpect(status().isBadRequest()).andReturn();

        ErrorMessage error = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),ErrorMessage.class);

        assertEquals(400, error.getCode());
        assertEquals(WRONG_FORMAT, error.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, error.getStatus());
    }

    @Test
    void sendArrayPayloadWrongFormatThenIsBadRequest() throws Exception {
        String JSON = objectMapper.writeValueAsString("-1");
        MvcResult mvcResult = mockMvc.perform(post("/water")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        ErrorMessage error = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),ErrorMessage.class);

        assertEquals(400, error.getCode());
        assertEquals(WRONG_FORMAT, error.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, error.getStatus());
    }
    @Test
    void sendArrayPayloadIsEmptyArrayThenIsBadRequest() throws Exception {
        String JSON = objectMapper.writeValueAsString(EMPTY_ARRAY);
        MvcResult mvcResult = mockMvc.perform(post("/water")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        ErrorMessage error = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),ErrorMessage.class);

        assertEquals(400, error.getCode());
        assertEquals(ARRAY_IS_EMPTY, error.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, error.getStatus());
    }

    @Test
    void sendArrayWithOneElementThenReturnZero() throws Exception {
        String JSON = objectMapper.writeValueAsString(ARRAY_WITH_ONE_ELEMENT);
        MvcResult result = mockMvc.perform(post("/water")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON))
                .andExpect(status().isOk())
                .andReturn();

        int responseResult = objectMapper.readValue(result.getResponse().getContentAsString(),Integer.class);

        assertEquals(0, responseResult);
    }

    @Test
    void sendArrayWithCorrectElementThenReturnValue() throws Exception {
        int[] correctWaterArray = new int[]{3, 0 , 2};
        String JSON = objectMapper.writeValueAsString(correctWaterArray);
        MvcResult result = mockMvc.perform(post("/water")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON))
                .andExpect(status().isOk())
                .andReturn();

        int responseResult = objectMapper.readValue(result.getResponse().getContentAsString(),Integer.class);

        assertEquals(2, responseResult);
    }
}