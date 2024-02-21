package com.github.etinaa.assignment.players.service.csv;

import com.github.etinaa.assignment.players.service.csv.LocalDateConverter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LocalDateConverterTest {

    private LocalDateConverter converter = new LocalDateConverter();

    @Test
    void convertDate() {
        assertEquals(LocalDate.of(1999, 6, 22), converter.convert("1999-06-22"));
    }

    @Test
    void convertEmpty() {
        assertNull(converter.convert(""));
    }

    @Test
    void convertInvalid() {
        assertNull(converter.convert("Wrong value"));
    }
}