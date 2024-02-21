package com.github.etinaa.assignment.players.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "players")
@SuppressWarnings("PMD.TooManyFields")
public class Player {

    @Id
    private String playerId;
    private String retroId;
    private String bbrefId;
    private String firstName;
    private String lastName;
    private String givenName;
    private Integer weight;
    private Integer height;
    private Character bats;
    private Character throwh;
    private LocalDate debut;
    private LocalDate finalGame;
    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private Integer deathYear;
    private Integer deathMonth;
    private Integer deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;
}
