package com.nikgym.soapserver.controller

import com.nikgym.ws.Country
import com.nikgym.ws.CountryRequest
import com.nikgym.ws.CountryResponse
import com.nikgym.ws.Currency
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

@Endpoint
class CountriesController {

    private val countries = mapOf(
        "Russia" to createCountryResponse("Russia", "Moscow", 10_000, Currency.RUB),
        "USA" to createCountryResponse("USA", "Washington", 12_000, Currency.GBP),
        "Finland" to createCountryResponse("Finland", "Helsinky", 5_000, Currency.EUR)
    )

    @PayloadRoot(namespace = "http://localhost:8080/countries", localPart = "countryRequest")
    @ResponsePayload
    fun getCountryByName(@RequestPayload countryRequest: CountryRequest) =
        countries[countryRequest.name]

    private fun createCountryResponse(name: String, capital: String, population: Int, currency: Currency) =
        CountryResponse().apply {
            country = Country().apply {
                this.name = name
                this.capital = capital
                this.population = population
                this.currency = currency
            }
        }
}