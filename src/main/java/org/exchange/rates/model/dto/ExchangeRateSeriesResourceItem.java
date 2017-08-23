package org.exchange.rates.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static org.exchange.rates.util.Constants.DATE_FORMAT;

@Getter
@Setter
@AllArgsConstructor
public class ExchangeRateSeriesResourceItem {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private Date date;

    private double rate;
}
