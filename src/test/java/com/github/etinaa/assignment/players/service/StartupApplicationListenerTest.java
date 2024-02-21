package com.github.etinaa.assignment.players.service;

import com.github.etinaa.assignment.players.data.Player;
import com.github.etinaa.assignment.players.data.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StartupApplicationListenerTest {

    @Autowired
    private PlayerRepository repository;

    @Test
    void testUplodaedData() {
        List<Player> players = repository.findAll();
        assertEquals(19370, players.size());

        Player player = repository.findById("perezti01").orElseThrow();
        assertAll(
                () -> assertEquals("perezti01", player.getPlayerId()),
                () -> assertEquals(1975, player.getBirthYear()),
                () -> assertEquals(4, player.getBirthMonth()),
                () -> assertEquals(8, player.getBirthDay()),
                () -> assertEquals("D.R.", player.getBirthCountry()),
                () -> assertEquals("Peravia", player.getBirthState()),
                () -> assertEquals("Bani", player.getBirthCity()),
                () -> assertNull(player.getDeathYear()),
                () -> assertNull(player.getDeathMonth()),
                () -> assertNull(player.getDeathDay()),
                () -> assertEquals("", player.getDeathCountry()),
                () -> assertEquals("", player.getDeathState()),
                () -> assertEquals("", player.getDeathCity()),
                () -> assertEquals("Timo", player.getFirstName()),
                () -> assertEquals("Perez", player.getLastName()),
                () -> assertEquals("Timoniel", player.getGivenName()),
                () -> assertEquals(180, player.getWeight()),
                () -> assertEquals(69, player.getHeight()),
                () -> assertEquals('L', player.getBats()),
                () -> assertEquals('L', player.getThrowh()),
                () -> assertEquals(LocalDate.of(2000, 9, 1), player.getDebut()),
                () -> assertEquals(LocalDate.of(2007, 9, 29), player.getFinalGame()),
                () -> assertEquals("peret004", player.getRetroId()),
                () -> assertEquals("perezti01", player.getBbrefId())
        );
    }
}
