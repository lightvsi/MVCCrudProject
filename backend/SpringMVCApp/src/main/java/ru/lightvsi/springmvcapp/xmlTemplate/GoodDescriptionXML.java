package ru.lightvsi.springmvcapp.xmlTemplate;

import ru.lightvsi.springmvcapp.entity.GoodDescription;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "goods")
public class GoodDescriptionXML {
    private List<GoodDescription> goodDescriptions;

    public GoodDescriptionXML() {
    }

    public GoodDescriptionXML(List<GoodDescription> goodDescriptions) {
        this.goodDescriptions = goodDescriptions;
    }

    @XmlElement
    public List<GoodDescription> getGoodDescriptions() {
        return goodDescriptions;
    }

    public void setGoodDescriptions(List<GoodDescription> goodDescriptions) {
        this.goodDescriptions = goodDescriptions;
    }
}
