package com.nikgym.soapclient.service.impl

import com.nikgym.soapclient.config.SoapServerProperties
import com.nikgym.soapclient.service.CountryService
import com.nikgym.ws.CountryRequest
import com.nikgym.ws.CountryResponse
import org.springframework.ws.client.core.support.WebServiceGatewaySupport

class CountryServiceImpl(
    private val soapServerProperties: SoapServerProperties
) : WebServiceGatewaySupport(), CountryService {

    override fun getCountryByName(name: String): CountryResponse {
        val countryRequest = CountryRequest().apply { this.name = name }
        val countriesUrl = "${soapServerProperties.url}${soapServerProperties.countriesUri}"
        return webServiceTemplate.marshalSendAndReceive(countriesUrl, countryRequest) as CountryResponse
    }
}