package org.exchange.rates.client;

import org.exchange.rates.model.dto.ExchangeRateInputResource;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name = "exchange-service", url = "https://api.fixer.io")
public interface FixerExchangeRateClient {

    @RequestMapping(value = "/latest?symbols=USD", method = GET)
    ExchangeRateInputResource latest();
}
