package org.exchange.rates.integration;

import org.exchange.rates.model.entity.ExchangeRate;
import org.exchange.rates.service.ExchangeRateService;
import org.exchange.rates.util.DateUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.exchange.rates.TestUtil.SAMPLE_END_DATE;
import static org.exchange.rates.TestUtil.SAMPLE_SIZE;
import static org.exchange.rates.TestUtil.SAMPLE_START_DATE;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ExchangeRateServiceITests extends BaseIntegrationTests {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Test
    public void shoulGetLatestRate(){
        ExchangeRate rate = exchangeRateService.getCurrentExchangeRate();
        assertNotNull(rate);
        assertTrue(0 < rate.getRate());
    }

    @Test
    public void shouldGetSeries() {
        List<ExchangeRate> rates = exchangeRateService.getExchangeRates(DateUtil.parse(SAMPLE_START_DATE),
                                                                 DateUtil.parse(SAMPLE_END_DATE));
        assertNotNull(rates);
        assertTrue(SAMPLE_SIZE == rates.size());
    }

}
