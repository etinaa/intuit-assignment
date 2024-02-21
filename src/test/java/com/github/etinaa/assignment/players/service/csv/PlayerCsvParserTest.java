package com.github.etinaa.assignment.players.service.csv;

import com.github.etinaa.assignment.players.data.PlayerDto;
import com.github.etinaa.assignment.players.service.csv.PlayerCsvParser;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerCsvParserTest {

    private PlayerCsvParser parser = new PlayerCsvParser();

    @Test
    void parseEmptyFile() throws Exception {
        useFile("empty.csv",
                reader -> assertEquals(0, parser.parse(reader).size()));
    }

    @Test
    void parseFileWithOnlyHeader() throws Exception {
        useFile("onlyHeader.csv",
                reader -> assertEquals(0, parser.parse(reader).size()));
    }

    @Test
    void parseInvalidFile() throws Exception {
        useFile("invalid.csv",
                reader -> assertEquals(0, parser.parse(reader).size()));
    }

    @Test
    void parseFileWithOneRow() throws Exception {
        useFile("oneRowData.csv", reader -> {
            List<PlayerDto> data = parser.parse(reader);
            assertEquals(1, data.size());
            PlayerDto player = data.get(0);
            assertAll(
                    () -> assertEquals("aardsda01", player.getPlayerId()),
                    () -> assertEquals(1981, player.getBirthYear()),
                    () -> assertEquals(12, player.getBirthMonth()),
                    () -> assertEquals(27, player.getBirthDay()),
                    () -> assertEquals("USA", player.getBirthCountry()),
                    () -> assertEquals("CO", player.getBirthState()),
                    () -> assertEquals("Denver", player.getBirthCity()),
                    () -> assertNull(player.getDeathYear()),
                    () -> assertNull(player.getDeathMonth()),
                    () -> assertNull(player.getDeathDay()),
                    () -> assertEquals("", player.getDeathCountry()),
                    () -> assertEquals("", player.getDeathState()),
                    () -> assertEquals("", player.getDeathCity()),
                    () -> assertEquals("David", player.getNameFirst()),
                    () -> assertEquals("Aardsma", player.getNameLast()),
                    () -> assertEquals("David Allan", player.getNameGiven()),
                    () -> assertEquals(215, player.getWeight()),
                    () -> assertEquals(75, player.getHeight()),
                    () -> assertEquals('R', player.getBats()),
                    () -> assertEquals('R', player.getThrowh()),
                    () -> assertEquals(LocalDate.of(2004, 4, 6), player.getDebut()),
                    () -> assertEquals(LocalDate.of(2015, 8, 23), player.getFinalGame()),
                    () -> assertEquals("aardd001", player.getRetroId()),
                    () -> assertEquals("aardsda01", player.getBbrefId())
            );
        });
    }

    @Test
    void parseFileWithTwentyRows() throws Exception {
        useFile("twentyRowsData.csv", reader -> {
            List<PlayerDto> data = parser.parse(reader);
            assertEquals(20, data.size());
            PlayerDto player = data.get(9);
            assertAll(
                    () -> assertEquals("abbeych01", player.getPlayerId()),
                    () -> assertEquals(1866, player.getBirthYear()),
                    () -> assertEquals(10, player.getBirthMonth()),
                    () -> assertEquals(14, player.getBirthDay()),
                    () -> assertEquals("USA", player.getBirthCountry()),
                    () -> assertEquals("NE", player.getBirthState()),
                    () -> assertEquals("Falls City", player.getBirthCity()),
                    () -> assertEquals(1926, player.getDeathYear()),
                    () -> assertEquals(4, player.getDeathMonth()),
                    () -> assertEquals(27, player.getDeathDay()),
                    () -> assertEquals("USA", player.getDeathCountry()),
                    () -> assertEquals("CA", player.getDeathState()),
                    () -> assertEquals("San Francisco", player.getDeathCity()),
                    () -> assertEquals("Charlie", player.getNameFirst()),
                    () -> assertEquals("Abbey", player.getNameLast()),
                    () -> assertEquals("Charles S.", player.getNameGiven()),
                    () -> assertEquals(169, player.getWeight()),
                    () -> assertEquals(68, player.getHeight()),
                    () -> assertEquals('L', player.getBats()),
                    () -> assertEquals('L', player.getThrowh()),
                    () -> assertEquals(LocalDate.of(1893, 8, 16), player.getDebut()),
                    () -> assertEquals(LocalDate.of(1897, 8, 19), player.getFinalGame()),
                    () -> assertEquals("abbec101", player.getRetroId()),
                    () -> assertEquals("abbeych01", player.getBbrefId())
            );
        });
    }

    private void useFile(final String fileName, Consumer<Reader> block) throws Exception {
        try (var inputStream = getClass().getResourceAsStream(fileName)) {
            final var reader = new InputStreamReader(Objects.requireNonNull(inputStream));
            block.accept(reader);
        }
    }
}
