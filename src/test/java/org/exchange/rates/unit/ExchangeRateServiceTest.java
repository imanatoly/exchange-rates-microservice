package org.exchange.rates.unit;

import org.exchange.rates.exceptions.ResourceNotFoundException;
import org.exchange.rates.model.entity.ExchangeRate;
import org.exchange.rates.persistence.ExchangeRateRepository;
import org.exchange.rates.service.ExchangeRateService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.exchange.rates.TestUtil.anyExchangeRate;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class ExchangeRateServiceTest {

    @Mock
    private ExchangeRateRepository exchangeRateRepository;

    @InjectMocks
    private ExchangeRateService exchangeRateService;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldSaveExchangeRate() {
        // GIVEN
        ExchangeRate sample = anyExchangeRate();
        given(exchangeRateRepository.save(sample)).willReturn(sample);

        // WHEN
        exchangeRateService.save(sample);

        // THEN
        verify(exchangeRateRepository, times(1)).save(any(ExchangeRate.class));
    }

    @Test
    public void shouldFindLatestRate() {
        // GIVEN
        ExchangeRate sample = anyExchangeRate();
        given(exchangeRateRepository.getFirstByOrderByCreatedDesc()).willReturn(sample);

        // WHEN
        ExchangeRate found = exchangeRateService.getCurrentExchangeRate();

        // THEN
        assertEquals(found, sample);
        verify(exchangeRateRepository, times(1)).getFirstByOrderByCreatedDesc();

    }

    @Test(expected = ResourceNotFoundException.class)
    public void shouldThrowExceptionWhenLatestRateNotFound(){
        // GIVEN
        // WHEN
        exchangeRateService.getCurrentExchangeRate();
    }


}
