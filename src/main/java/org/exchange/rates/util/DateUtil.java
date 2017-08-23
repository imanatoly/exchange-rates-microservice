package org.exchange.rates.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(Constants.DATE_FORMAT);

    public static Date parse(String dateAsString) {
        try {
            return DATE_FORMATTER.parse(dateAsString);
        } catch (Exception x) {
            throw new IllegalArgumentException("Expected date format is " + Constants.DATE_FORMAT);
        }
    }
}
