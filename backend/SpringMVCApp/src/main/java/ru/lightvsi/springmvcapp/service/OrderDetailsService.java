package ru.lightvsi.springmvcapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lightvsi.springmvcapp.entity.GoodDescription;
import ru.lightvsi.springmvcapp.entity.Order;
import ru.lightvsi.springmvcapp.entity.OrderDetails;
import ru.lightvsi.springmvcapp.repository.OrderDetailsRepository;
import ru.lightvsi.springmvcapp.xmlTemplate.GoodDescriptionXML;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private JAXBContext unmarshaller;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void fillWithContent() {
        try {
            GoodDescriptionXML good = (GoodDescriptionXML) unmarshaller.createUnmarshaller().unmarshal(getClass().getClassLoader().getResourceAsStream("goods.xml"));
            List<GoodDescription> goodsList = good.getGoodDescriptions();
            goodsList.subList(0, goodsList.size() / 2);
            Order order1 = new Order("Ivan", "Moscow,Russia", 15395, new GregorianCalendar(2026, 2, 15).getTime());
            OrderDetails orderDetails1 = new OrderDetails(goodsList.subList(0, goodsList.size() / 2), "3", order1);
            Order order2 = new Order("Steven", "NewYork,USA", 23685, new GregorianCalendar(2085, 12, 5).getTime());
            OrderDetails orderDetails2 = new OrderDetails(goodsList.subList(goodsList.size() / 2, goodsList.size()), "3", order2);
            orderDetailsRepository.save(orderDetails1);
            orderDetailsRepository.save(orderDetails2);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    @Transactional
    public List<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }
}
