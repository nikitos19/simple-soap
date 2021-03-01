package com.nikgym.soapclient.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "soapserver")
class SoapServerProperties {
    var url: String = ""
    var countriesUri: String = ""
}