package org.exchange.rates.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ExchangeRateInputResourceDetail {

    @JsonProperty("USD")
    private double usd;
}
