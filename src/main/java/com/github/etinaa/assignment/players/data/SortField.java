package com.github.etinaa.assignment.players.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 */
@Getter
@AllArgsConstructor
public enum SortField {
    PLAYERID("playerId"),
    WEIGHT("weight"),
    HEIGHT("height"),
    DEBUT("debut"),
    FINALGAME("finalGame"),
    BIRTHYEAR("birthYear"),
    DEATHYEAR("deathYear");

    private final String dbFieldName;
}
