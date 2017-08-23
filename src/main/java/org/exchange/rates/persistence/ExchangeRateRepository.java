package org.exchange.rates.persistence;

import org.exchange.rates.model.entity.ExchangeRate;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, String> {

    ExchangeRate getFirstByOrderByCreatedDesc();

    List<ExchangeRate> createdBetweenOrderByCreatedAsc(Date from, Date to);
}
