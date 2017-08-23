package org.exchange.rates.converter;

import org.exchange.rates.model.entity.ExchangeRate;
import org.exchange.rates.model.dto.ExchangeRateResource;
import org.springframework.core.convert.converter.Converter;

public class ExchangeRateToExchangeRateResourceConverter implements Converter<ExchangeRate, ExchangeRateResource> {


    @Override
    public ExchangeRateResource convert(ExchangeRate rate) {
        if (rate==null)
            return null;
        ExchangeRateResource resource = new ExchangeRateResource();
        resource.setFrom(rate.getFromCurrency());
        resource.setTo(rate.getToCurrency());
        resource.setDate(rate.getCreated());
        resource.setRate(rate.getRate());
        return resource;
    }
}
