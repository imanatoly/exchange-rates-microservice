package org.exchange.rates.configuration;

import org.exchange.rates.converter.ExchangeRateInputResourceToExchangeRateConverter;
import org.exchange.rates.converter.ExchangeRateListToExchangeRateSeriesResourceConverter;
import org.exchange.rates.converter.ExchangeRateToExchangeRateResourceConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.GenericConversionService;

@Configuration
public class ConverterConfiguration {

    @Bean
    public ConfigurableConversionService exchangeRateConversionService() {
        final ConfigurableConversionService conversionService = new GenericConversionService();
        conversionService.addConverter(new ExchangeRateToExchangeRateResourceConverter());
        conversionService.addConverter(new ExchangeRateListToExchangeRateSeriesResourceConverter());
        conversionService.addConverter(new ExchangeRateInputResourceToExchangeRateConverter());
        return conversionService;
    }
}
