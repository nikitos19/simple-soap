package com.nikgym.soapclient.service

import com.nikgym.ws.CountryResponse

interface CountryService {

    fun getCountryByName(name: String): CountryResponse
}