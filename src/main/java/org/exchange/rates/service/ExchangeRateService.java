package org.exchange.rates.service;

import org.exchange.rates.exceptions.ResourceNotFoundException;
import org.exchange.rates.model.entity.ExchangeRate;
import org.exchange.rates.persistence.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static java.text.MessageFormat.format;

@Service
public class ExchangeRateService {

    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public ExchangeRate getCurrentExchangeRate() {
        ExchangeRate exchangeRate = exchangeRateRepository.getFirstByOrderByCreatedDesc();
        if (exchangeRate == null) {
            throw new ResourceNotFoundException("There is no exchange rate.");
        }
        return exchangeRate;
    }

    public List<ExchangeRate> getExchangeRates(Date startDate, Date endDate) {
        List<ExchangeRate> exchangeRates = exchangeRateRepository.createdBetweenOrderByCreatedAsc(startDate, endDate);
        if (exchangeRates == null || exchangeRates.isEmpty()) {
            throw new ResourceNotFoundException(format("No exchange rate found between {0} - {1}.", startDate, endDate));
        }
        return exchangeRates;
    }

    public void save(ExchangeRate exchangeRate) {
        if (exchangeRate == null) {
            throw new IllegalArgumentException("Exchange rate can not be null");
        }
        exchangeRateRepository.save(exchangeRate);
    }
}
