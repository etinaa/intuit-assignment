package com.github.etinaa.assignment.players.service;

import com.github.etinaa.assignment.players.service.csv.PlayerCsvParser;
import com.github.etinaa.assignment.players.data.Player;
import com.github.etinaa.assignment.players.data.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final String FILEPATH = "/data/player.csv";

    private final PlayerCsvParser csvParser;
    private final PlayerRepository repository;
    private final PlayerListMapper mapper;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        try (var inputStream = getClass().getResourceAsStream(FILEPATH)) {
            final var reader = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
            List<Player> players = mapper.toEntityList(csvParser.parse(reader));
            repository.saveAll(players);
        } catch (IOException ex) {
            log.error("Error reading data from resource file '{}'", FILEPATH, ex);
        }
    }

}
