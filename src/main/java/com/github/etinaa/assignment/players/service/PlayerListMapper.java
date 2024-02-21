package com.github.etinaa.assignment.players.service;

import com.github.etinaa.assignment.players.data.PlayerDto;
import com.github.etinaa.assignment.players.data.Player;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PlayerMapper.class})
public interface PlayerListMapper {

    List<Player> toEntityList(List<PlayerDto> players);
}
