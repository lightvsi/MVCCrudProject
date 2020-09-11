package ru.lightvsi.springmvcapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lightvsi.springmvcapp.entity.GoodDescription;
import ru.lightvsi.springmvcapp.entity.OrderDetails;
import ru.lightvsi.springmvcapp.repository.OrderDetailsRepository;
import ru.lightvsi.springmvcapp.service.GoodDescriptionService;
import ru.lightvsi.springmvcapp.service.OrderDetailsService;
import ru.lightvsi.springmvcapp.wsdl.TimeClient;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200", "http://localhost:8081", "http://localhost:8070"})
@RestController
public class MVCController {
    private final String TIME_ZONE = "Europe/Moscow";
    @Autowired
    private GoodDescriptionService goodDescriptionService;
    @Autowired
    private OrderDetailsService orderDetailsService;
    @Autowired
    private TimeClient timeClient;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDetails>> getOrderDetails() {
        return new ResponseEntity<>(orderDetailsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/goods")
    public ResponseEntity<List<GoodDescription>> getGoods() {
        return new ResponseEntity<>(goodDescriptionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/update")
    public ResponseEntity<List<GoodDescription>> updateGoods() {
        return new ResponseEntity<>(goodDescriptionService.update(), HttpStatus.OK);
    }

    @GetMapping("/time")
    public ResponseEntity<String> getTime() {
        return new ResponseEntity<>(timeClient.getTime(TIME_ZONE), HttpStatus.OK);
    }

}

