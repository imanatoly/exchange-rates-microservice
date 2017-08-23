package org.exchange.rates.integration;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

import static org.exchange.rates.TestUtil.SAMPLE_END_DATE;
import static org.exchange.rates.TestUtil.SAMPLE_START_DATE;
import static org.exchange.rates.model.Currency.EUR;
import static org.exchange.rates.model.Currency.USD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

public class ExchangeRateControllerITests extends BaseIntegrationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @PostConstruct
    public void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldQueryExchangeRateSuccessfully() throws Exception {
        final MockHttpServletRequestBuilder getRequest = get("/api/exchangeRates/latest");
        mockMvc.perform(getRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.from").value(EUR.name()))
                .andExpect(jsonPath("$.to").value(USD.name()))
                .andExpect(jsonPath("$.rate").isNumber())
                .andReturn();

    }

    @Test
    public void shouldQueryExchangeRateSeriesSuccessfully() throws Exception {
        final MockHttpServletRequestBuilder getRequest = get("/api/exchangeRateSeries?startDate={startDate}&endDate={endDate}", SAMPLE_START_DATE, SAMPLE_END_DATE);
        mockMvc.perform(getRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.from").value(EUR.name()))
                .andExpect(jsonPath("$.to").value(USD.name()))
                .andExpect(jsonPath("$.rates").isNotEmpty())
                .andExpect(jsonPath("$.rates[0].date").isString())
                .andExpect(jsonPath("$.rates[0].rate").isNumber())
                .andReturn();

    }

}
