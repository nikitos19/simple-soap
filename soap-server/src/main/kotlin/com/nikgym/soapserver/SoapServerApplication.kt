package com.nikgym.soapserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SoapServerApplication

fun main(args: Array<String>) {
    runApplication<SoapServerApplication>(*args)
}