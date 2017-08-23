package org.exchange.rates.converter;

import org.exchange.rates.model.entity.ExchangeRate;
import org.exchange.rates.model.dto.ExchangeRateSeriesResource;
import org.exchange.rates.model.dto.ExchangeRateSeriesResourceItem;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ExchangeRateListToExchangeRateSeriesResourceConverter implements Converter<List<ExchangeRate>, ExchangeRateSeriesResource> {

    @Override
    public ExchangeRateSeriesResource convert(List<ExchangeRate> rates) {
        if (rates==null || rates.isEmpty())
            return null;

        ExchangeRate sample = rates.get(0);
        ExchangeRateSeriesResource resource = new ExchangeRateSeriesResource();
        resource.setCreated(new Date());
        resource.setFrom(sample.getFromCurrency());
        resource.setTo(sample.getToCurrency());
        resource.setRates(rates.stream()
                            .map(r -> new ExchangeRateSeriesResourceItem(r.getCreated(), r.getRate()))
                            .collect(Collectors.toList()));
        return resource;
    }
}
