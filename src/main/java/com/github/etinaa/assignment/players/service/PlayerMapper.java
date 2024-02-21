package com.github.etinaa.assignment.players.service;

import com.github.etinaa.assignment.players.data.PlayerDto;
import com.github.etinaa.assignment.players.data.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "firstName", source = "player.nameFirst")
    @Mapping(target = "lastName", source = "player.nameLast")
    @Mapping(target = "givenName", source = "player.nameGiven")
    Player toEntity(PlayerDto player);

    @Mapping(target = "nameFirst", source = "player.firstName")
    @Mapping(target = "nameLast", source = "player.lastName")
    @Mapping(target = "nameGiven", source = "player.givenName")
    PlayerDto toDto(Player player);
}
