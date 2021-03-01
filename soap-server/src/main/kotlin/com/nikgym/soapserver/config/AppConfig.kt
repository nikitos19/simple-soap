package com.nikgym.soapserver.config

import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.ws.config.annotation.EnableWs
import org.springframework.ws.config.annotation.WsConfigurerAdapter
import org.springframework.ws.transport.http.MessageDispatcherServlet
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition
import org.springframework.xml.xsd.SimpleXsdSchema
import org.springframework.xml.xsd.XsdSchema

@EnableWs
@Configuration
class AppConfig : WsConfigurerAdapter() {

    @Bean
    fun messageDispatcherServlet(applicationContext: ApplicationContext): ServletRegistrationBean<MessageDispatcherServlet> {
        val servlet = MessageDispatcherServlet()
        servlet.setApplicationContext(applicationContext)
        servlet.isTransformWsdlLocations = true
        return ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/*")
    }

    @Bean
    fun countriesSchema(): XsdSchema = SimpleXsdSchema(ClassPathResource("xsd/countries.xsd"))

    @Bean(name = ["countries"])
    fun defaultWsdl11Definition(countriesSchema: XsdSchema): DefaultWsdl11Definition {
        val wsdl11Definition = DefaultWsdl11Definition()
        wsdl11Definition.setPortTypeName("countriesPort")
        wsdl11Definition.setLocationUri("/")
        wsdl11Definition.setTargetNamespace("http://localhost:8080/countries")
        wsdl11Definition.setSchema(countriesSchema)
        return wsdl11Definition
    }
}