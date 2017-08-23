package org.exchange.rates;

import org.exchange.rates.model.entity.ExchangeRate;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import static org.exchange.rates.model.Currency.EUR;
import static org.exchange.rates.model.Currency.USD;


public class TestUtil {

    private static final Random random = new Random();

    // exchange rate count in initial persistence
    public static final int SAMPLE_SIZE = 5;

    // date interval for test persistence
    public static final String SAMPLE_START_DATE    = "2017-08-13";
    public static final String SAMPLE_END_DATE      = "2017-08-19";


    public static ExchangeRate anyExchangeRate() {
        return new ExchangeRate(
                UUID.randomUUID().toString(),
                new Date(),
                EUR,
                USD,
                1+ random.nextInt() / Integer.MAX_VALUE);
    }
}
