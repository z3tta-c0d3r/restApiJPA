package com.inss.imv.restapi.mapper;

import com.inss.imv.restapi.mapper.qualifiers.DateConverter;
import com.inss.imv.restapi.mapper.qualifiers.ParseDate;
import com.inss.imv.restapi.mapper.qualifiers.ParseTimestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@DateConverter
public class DateToTimestamp {
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @ParseDate
    private java.util.Date parseDate(Date date) {
        try {
            return DATE_FORMAT.parse(String.valueOf(date));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @ParseTimestamp
    private java.util.Date parseTimestamp(Date timestamp) {
        try {
            return DATE_TIME_FORMAT.parse(String.valueOf(timestamp));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
