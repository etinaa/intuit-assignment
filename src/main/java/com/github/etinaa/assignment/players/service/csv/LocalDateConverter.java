package com.github.etinaa.assignment.players.service.csv;

import com.opencsv.bean.AbstractBeanField;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Custom converter for Date fields in CSV.
 */
@Slf4j
public class LocalDateConverter extends AbstractBeanField {

    /**
     * Convert field with format "yyyy-MM-dd" to LocalDate.
     * @param value The string from the selected field of the CSV file.
     * @return Value of field in LocalDate type
     */
    @Override
    protected Object convert(final String value) {
        try {
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(value, formatter);
        } catch (DateTimeParseException ex) {
            if (StringUtils.isNotEmpty(value)) {
                log.error("Found wrong value {} for date field", value, ex);
            }
            return null;
        }
    }
}
