package ru.lightvsi.timeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import ru.lightvsi.timeservice.data.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@Endpoint
public class TimeEndpoint {
    private static final String NAMESPACE_URI = "data.timeservice.lightvsi.ru";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTimeRequest")
    @ResponsePayload
    public GetTimeResponse getTime(@RequestPayload GetTimeRequest request) {
        try {
            GregorianCalendar gcal = new GregorianCalendar(TimeZone.getTimeZone(request.getTimezone()));
            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gcal);
            System.out.println(xmlGregorianCalendar);
            GetTimeResponse response = new GetTimeResponse();
            response.setCurrenttime(xmlGregorianCalendar);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}