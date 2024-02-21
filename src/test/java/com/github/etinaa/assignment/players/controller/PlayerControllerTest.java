package com.github.etinaa.assignment.players.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlayerControllerTest {

    private static final int DEFAULT_PAGE_SIZE = 20;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllDefault() throws Exception {
        mockMvc.perform(get("/api/v1/players"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(DEFAULT_PAGE_SIZE)))
                .andExpect(jsonPath("$.content[15].playerID").value("abbotku01"))
                .andExpect(jsonPath("$.pageable.pageNumber").value(0))
                .andExpect(jsonPath("$.pageable.pageSize").value(DEFAULT_PAGE_SIZE))
                .andExpect(jsonPath("$.pageable.sort.sorted").value(true))
                .andExpect(jsonPath("$.totalElements").value(19370));
    }

    @Test
    void getAllPageable() throws Exception {
        mockMvc.perform(get("/api/v1/players?pageSize=5&sortField=HEIGHT&sortDirection=DESC"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(5)))
                .andExpect(jsonPath("$.content[0].playerID").value("rauchjo01"))
                .andExpect(jsonPath("$.content[0].height").value(83))
                .andExpect(jsonPath("$.pageable.pageNumber").value(0))
                .andExpect(jsonPath("$.pageable.pageSize").value(5))
                .andExpect(jsonPath("$.pageable.sort.sorted").value(true))
                .andExpect(jsonPath("$.totalElements").value(19370));
    }

    @Test
    void getAllWithNegativePageSize() throws Exception {
        mockMvc.perform(get("/api/v1/players?pageSize=-1"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllWithStringPageSize() throws Exception {
        mockMvc.perform(get("/api/v1/players?pageSize=ABD"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllWithIllegalSortField() throws Exception {
        mockMvc.perform(get("/api/v1/players?sortField=BATS"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllWithIllegalSortDirection() throws Exception {
        mockMvc.perform(get("/api/v1/players?sortDirection=ANY"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllWithPageNumberGreaterThenRowsCount() throws Exception {
        mockMvc.perform(get("/api/v1/players?pageNumber=1000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(0)));
    }

    @Test
    void getAllWithNegativePageNumber() throws Exception {
        mockMvc.perform(get("/api/v1/players?pageNumber=-30"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getByPlayerId() throws Exception {
        mockMvc.perform(get("/api/v1/players/houkra01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.playerID").value("houkra01"))
                .andExpect(jsonPath("$.birthYear").value("1919"))
                .andExpect(jsonPath("$.birthMonth").value("8"))
                .andExpect(jsonPath("$.birthDay").value("9"))
                .andExpect(jsonPath("$.birthCountry").value("USA"))
                .andExpect(jsonPath("$.birthState").value("KS"))
                .andExpect(jsonPath("$.birthCity").value("Lawrence"))
                .andExpect(jsonPath("$.deathYear").value("2010"))
                .andExpect(jsonPath("$.deathMonth").value("7"))
                .andExpect(jsonPath("$.deathDay").value("21"))
                .andExpect(jsonPath("$.deathCountry").value("USA"))
                .andExpect(jsonPath("$.deathState").value("FL"))
                .andExpect(jsonPath("$.deathCity").value("Winter Haven"))
                .andExpect(jsonPath("$.nameFirst").value("Ralph"))
                .andExpect(jsonPath("$.nameLast").value("Houk"))
                .andExpect(jsonPath("$.nameGiven").value("Ralph George"))
                .andExpect(jsonPath("$.weight").value("193"))
                .andExpect(jsonPath("$.height").value("71"))
                .andExpect(jsonPath("$.bats").value("R"))
                .andExpect(jsonPath("$.throws").value("R"))
                .andExpect(jsonPath("$.debut").value("1947-04-26"))
                .andExpect(jsonPath("$.finalGame").value("1954-05-01"))
                .andExpect(jsonPath("$.retroID").value("houkr101"))
                .andExpect(jsonPath("$.bbrefID").value("houkra01"));
    }

    @Test
    void notFoundById() throws Exception {
        mockMvc.perform(get("/api/v1/players/notFound"))
                .andExpect(status().isNotFound());
    }
}