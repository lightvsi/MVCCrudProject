package ru.lightvsi.springmvcapp.wsdl;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.lightvsi.springmvcapp.wsdl.GetTimeRequest;
import ru.lightvsi.springmvcapp.wsdl.GetTimeResponse;

public class TimeClient extends WebServiceGatewaySupport {
    public String getTime(String timezone) {
        GetTimeRequest request = new GetTimeRequest();
        request.setTimezone(timezone);
        //log.info("Requesting time " + message);
        GetTimeResponse response = (GetTimeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8090/ws/time", request,
                        new SoapActionCallback(
                                "data.timeservice.lightvsi.ru/GetTimeRequest"));
        String string = response.getCurrenttime().getDay() +  "/" + response.getCurrenttime().getMonth() + "/" + response.getCurrenttime().getYear()
                + " " + response.getCurrenttime().getHour()+ ":" + response.getCurrenttime().getMinute();
        return string;
    }
}
