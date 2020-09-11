package ru.lightvsi.springmvcapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lightvsi.springmvcapp.entity.GoodDescription;
import ru.lightvsi.springmvcapp.repository.GoodDescriptionRepository;
import ru.lightvsi.springmvcapp.xmlTemplate.GoodDescriptionXML;

import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

@Service
public class GoodDescriptionService {
    @Autowired
    private GoodDescriptionRepository goodDescriptionRepository;
    @Autowired
    private JAXBContext unmarshaller;
    @Autowired
    ServletContext servletContext;

    @Transactional
    public List<GoodDescription> update() {
        try {
            GoodDescriptionXML good = (GoodDescriptionXML) unmarshaller.createUnmarshaller().unmarshal(getClass().getClassLoader().getResourceAsStream("goods.xml"));
            List<GoodDescription> goodsList = good.getGoodDescriptions();
            goodDescriptionRepository.deleteAll();
            if (!goodsList.isEmpty())
                goodDescriptionRepository.saveAll(goodsList);
            return goodDescriptionRepository.findAll();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Transactional
    public List<GoodDescription> findAll() {
        return goodDescriptionRepository.findAll();
    }


}
