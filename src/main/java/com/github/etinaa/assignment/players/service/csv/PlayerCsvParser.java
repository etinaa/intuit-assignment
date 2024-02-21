package com.github.etinaa.assignment.players.service.csv;

import com.github.etinaa.assignment.players.data.PlayerDto;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.util.List;

/**
 * Service for parsing CSV.
 */
@Service
public class PlayerCsvParser {

    /**
     * Parse CSV source for players data.
     * @param reader The reader that is the source of data for the CSV import
     * @return List of player data
     */
    public List<PlayerDto> parse(final Reader reader) {
        return new CsvToBeanBuilder<PlayerDto>(reader)
                .withType(PlayerDto.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build()
                .parse();
    }
}
