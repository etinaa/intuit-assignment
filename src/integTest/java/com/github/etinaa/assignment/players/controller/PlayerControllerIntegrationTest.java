package com.github.etinaa.assignment.players.controller;

import com.github.etinaa.assignment.players.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class PlayerControllerIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getByPlayerId() throws Exception {
        mockMvc.perform(get("/api/v1/players/mcginru01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.playerID").value("mcginru01"));
    }
}
