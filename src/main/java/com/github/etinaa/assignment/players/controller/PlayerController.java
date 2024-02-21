package com.github.etinaa.assignment.players.controller;

import com.github.etinaa.assignment.players.data.PlayerDto;
import com.github.etinaa.assignment.players.service.PlayerService;
import com.github.etinaa.assignment.players.data.SortField;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/players")
public class PlayerController {

    private final PlayerService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Page<PlayerDto> getAllByPage(@RequestParam(defaultValue = "0") final int pageNumber,
                                        @RequestParam(defaultValue = "20") final int pageSize,
                                        @RequestParam(defaultValue = "PLAYERID") final SortField sortField,
                                        @RequestParam(defaultValue = "ASC") final Sort.Direction sortDirection) {
        return service.getAllByPage(pageNumber, pageSize, sortField, sortDirection);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{playerId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public PlayerDto getByPlayerId(@PathVariable("playerId") final String playerId) {
        return service.getByPlayerId(playerId);
    }
}
