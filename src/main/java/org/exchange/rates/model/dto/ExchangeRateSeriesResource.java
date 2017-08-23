package org.exchange.rates.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.exchange.rates.model.Currency;

import java.util.Date;
import java.util.List;

import static org.exchange.rates.util.Constants.DATE_FORMAT;

@Getter
@Setter
public class ExchangeRateSeriesResource {

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern=DATE_FORMAT)
    private Date created;

    private Currency from;
    private Currency to;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern=DATE_FORMAT)
    private Date fromDate;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern=DATE_FORMAT)
    private Date toDate;

    private List<ExchangeRateSeriesResourceItem> rates;

}
