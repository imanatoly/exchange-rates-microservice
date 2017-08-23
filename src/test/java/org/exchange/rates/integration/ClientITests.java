package org.exchange.rates.integration;

import org.exchange.rates.client.FixerExchangeRateClient;
import org.exchange.rates.model.dto.ExchangeRateInputResource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class ClientITests extends BaseIntegrationTests {

    @Autowired
    private FixerExchangeRateClient fixerExchangeRateClient;

    @Test
    public void shouldGetRate(){
        ExchangeRateInputResource inputResource = fixerExchangeRateClient.latest();
        assertNotNull(inputResource);
        assertEquals("EUR", inputResource.getBase());
        assertNotNull(inputResource.getRates());
        assertTrue(inputResource.getRates().getUsd() > 0);
    }
}
