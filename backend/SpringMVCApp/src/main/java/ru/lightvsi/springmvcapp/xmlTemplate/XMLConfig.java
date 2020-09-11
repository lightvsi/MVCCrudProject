package ru.lightvsi.springmvcapp.xmlTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.bind.JAXBContext;

@Configuration
public class XMLConfig {
    @Bean
    public JAXBContext unmarshaller() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(GoodDescriptionXML.class);
        return jaxbContext;
    }
}
