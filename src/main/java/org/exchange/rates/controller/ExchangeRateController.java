package org.exchange.rates.controller;

import org.exchange.rates.model.entity.ExchangeRate;
import org.exchange.rates.model.dto.ExchangeRateResource;
import org.exchange.rates.model.dto.ExchangeRateSeriesResource;
import org.exchange.rates.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static org.exchange.rates.util.Constants.DATE_FORMAT;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExchangeRateController {

    private ExchangeRateService exchangeRateService;

    private ConversionService exchangeRateConversionService;

    @Autowired
    public ExchangeRateController(ExchangeRateService exchangeRateService, ConversionService exchangeRateConversionService) {
        this.exchangeRateService = exchangeRateService;
        this.exchangeRateConversionService = exchangeRateConversionService;
    }

    @RequestMapping(value = "/exchangeRates/latest", method = RequestMethod.GET)
    public ExchangeRateResource getRate() {
        final ExchangeRate exchangeRate = exchangeRateService.getCurrentExchangeRate();
        return exchangeRateConversionService.convert(exchangeRate, ExchangeRateResource.class);
    }

    @RequestMapping(value = "/exchangeRateSeries", method = RequestMethod.GET)
    public ExchangeRateSeriesResource getRateSeries(@RequestParam @DateTimeFormat(pattern = DATE_FORMAT) Date startDate,
                                                    @RequestParam @DateTimeFormat(pattern = DATE_FORMAT) Date endDate) {
        List<ExchangeRate> exchangeRates = exchangeRateService.getExchangeRates(startDate, endDate);
        ExchangeRateSeriesResource exchangeRateSeriesResource = exchangeRateConversionService.convert(exchangeRates, ExchangeRateSeriesResource.class);
        exchangeRateSeriesResource.setFromDate(startDate);
        exchangeRateSeriesResource.setToDate(endDate);
        return exchangeRateSeriesResource;
    }
}
