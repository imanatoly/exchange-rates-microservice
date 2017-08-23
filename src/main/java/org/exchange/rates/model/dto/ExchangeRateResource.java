package org.exchange.rates.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.exchange.rates.model.Currency;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

import static org.exchange.rates.util.Constants.DATE_FORMAT;

@Setter
@Getter
@ResponseBody
public class ExchangeRateResource {

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern=DATE_FORMAT)
    private Date date;

    private Currency from;
    private Currency to;

    private double rate;

}
