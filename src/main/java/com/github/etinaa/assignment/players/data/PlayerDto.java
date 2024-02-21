package com.github.etinaa.assignment.players.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.etinaa.assignment.players.service.csv.LocalDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.Data;

import java.time.LocalDate;

@Data
@SuppressWarnings("PMD.TooManyFields")
public class PlayerDto {

    @CsvBindByName(column = "playerID")
    @JsonProperty("playerID")
    private String playerId;
    @CsvBindByName(column = "birthYear")
    private Integer birthYear;
    @CsvBindByName(column = "birthMonth")
    private Integer birthMonth;
    @CsvBindByName(column = "birthDay")
    private Integer birthDay;
    @CsvBindByName(column = "birthCountry")
    private String birthCountry;
    @CsvBindByName(column = "birthState")
    private String birthState;
    @CsvBindByName(column = "birthCity")
    private String birthCity;
    @CsvBindByName(column = "deathYear")
    private Integer deathYear;
    @CsvBindByName(column = "deathMonth")
    private Integer deathMonth;
    @CsvBindByName(column = "deathDay")
    private Integer deathDay;
    @CsvBindByName(column = "deathCountry")
    private String deathCountry;
    @CsvBindByName(column = "deathState")
    private String deathState;
    @CsvBindByName(column = "deathCity")
    private String deathCity;
    @CsvBindByName(column = "nameFirst")
    private String nameFirst;
    @CsvBindByName(column = "nameLast")
    private String nameLast;
    @CsvBindByName(column = "nameGiven")
    private String nameGiven;
    @CsvBindByName(column = "weight")
    private Integer weight;
    @CsvBindByName(column = "height")
    private Integer height;
    @CsvBindByName(column = "bats")
    private Character bats;
    @CsvBindByName(column = "throws")
    @JsonProperty("throws")
    private Character throwh;
    @CsvCustomBindByName(column = "debut", converter = LocalDateConverter.class)
    private LocalDate debut;
    @CsvCustomBindByName(column = "finalGame", converter = LocalDateConverter.class)
    private LocalDate finalGame;
    @CsvBindByName(column = "retroID")
    @JsonProperty("retroID")
    private String retroId;
    @CsvBindByName(column = "bbrefID")
    @JsonProperty("bbrefID")
    private String bbrefId;

}
