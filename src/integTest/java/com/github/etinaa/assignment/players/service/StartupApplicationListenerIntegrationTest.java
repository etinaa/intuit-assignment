package com.github.etinaa.assignment.players.service;

import com.github.etinaa.assignment.players.BaseIntegrationTest;
import com.github.etinaa.assignment.players.data.Player;
import com.github.etinaa.assignment.players.data.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartupApplicationListenerIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private PlayerRepository repository;

    @Test
    void testUplodaedData() {
        List<Player> players = repository.findAll();
        assertEquals(19370, players.size());

        Player player = repository.findById("perezti01").orElseThrow();
        assertEquals("Timo", player.getFirstName());
        assertEquals("Perez", player.getLastName());
        assertEquals("Timoniel", player.getGivenName());
    }
}
