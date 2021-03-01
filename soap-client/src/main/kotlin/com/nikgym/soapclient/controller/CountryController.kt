package com.nikgym.soapclient.controller

import com.nikgym.soapclient.service.CountryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/countries")
class CountryController(private val countryService: CountryService) {

    @GetMapping("/{name}")
    fun getCountryByName(@PathVariable name: String) = countryService.getCountryByName(name)
}