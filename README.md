# Exchange Rates Microservice

## Overview

Sample standalone REST microservice for 
* get daily exchange rate from EURO to USD.
* list exchange rates in given date interval

Data is populated from <http://fixer.io> with a scheduled task. Scheduling is configured at `application.properties`

Keywords: Spring Boot, Feign Client, Scheduling, Unit &amp; Integration Tests (Mockito and jUnit), Maven  

## Usage

Run microservice

```
mvn spring-boot:run
```

Run tests

```
mvn test
```

## API 

### Get Current Exchange Rate

```http
GET /api/exchangeRates/latest
```

```json
{
  "date": "2017-08-17",
  "from": "EUR",
  "to": "USD",
  "rate": 1.1174
}
```
### List Exchange Rates in Date Interval

```http
GET /api/exchangeRateSeries?startDate={START_DATE}&endDate={END_DATE}
```

```json
{
  "created": "2017-08-23",
  "from": "EUR",
  "to": "USD",
  "fromDate": "2017-08-09",
  "toDate": "2017-08-19",
  "rates": [
    { "date": "2017-08-13", "rate": 1.1797},
    { "date": "2017-08-14", "rate": 1.1744},
    { "date": "2017-08-15", "rate": 1.1171},
    { "date": "2017-08-16", "rate": 1.1697},
    { "date": "2017-08-17", "rate": 1.1174}
  ]
} 
```
