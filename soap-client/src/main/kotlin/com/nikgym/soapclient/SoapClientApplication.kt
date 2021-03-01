package com.nikgym.soapclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class SoapClientApplication

fun main(args: Array<String>) {
    runApplication<SoapClientApplication>(*args)
}
