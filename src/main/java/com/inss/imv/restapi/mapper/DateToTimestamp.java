package com.inss.imv.restapi.mapper;

import com.inss.imv.restapi.mapper.qualifiers.DateConverter;
import com.inss.imv.restapi.mapper.qualifiers.ParseDate;
import com.inss.imv.restapi.mapper.qualifiers.ParseTimestamp;
import org.mapstruct.Named;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@DateConverter
public class DateToTimestamp {
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @ParseDate
    public java.util.Date parseDate(Date date) {
        try {
            String value = DATE_FORMAT.format(date);
            return DATE_FORMAT.parse(value);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @ParseTimestamp
    public java.util.Date parseTimestamp(Date timestamp) {
        try {
            String value = DATE_TIME_FORMAT.format(timestamp);
            return DATE_TIME_FORMAT.parse(value);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
