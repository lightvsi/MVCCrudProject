package ru.lightvsi.springmvcapp.wsdl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class TimeConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("ru.lightvsi.springmvcapp.wsdl");
        return marshaller;
    }

    @Bean
    public TimeClient timeClient(Jaxb2Marshaller marshaller) {
        TimeClient client = new TimeClient();
        client.setDefaultUri("http://localhost:8090/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
