package com.nikgym.soapclient.config

import com.nikgym.soapclient.service.impl.CountryServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import org.springframework.ws.config.annotation.EnableWs
import org.springframework.ws.config.annotation.WsConfigurerAdapter

@EnableWs
@Configuration
class AppConfig(private val soapServerProperties: SoapServerProperties) : WsConfigurerAdapter() {

    @Bean
    fun jaxb2Marshaller() = Jaxb2Marshaller().apply {
        contextPath = "com.nikgym.ws"
    }

    @Bean
    fun countryService(jaxb2Marshaller: Jaxb2Marshaller) =
        CountryServiceImpl(soapServerProperties).apply {
            marshaller = jaxb2Marshaller
            unmarshaller = jaxb2Marshaller
        }
}