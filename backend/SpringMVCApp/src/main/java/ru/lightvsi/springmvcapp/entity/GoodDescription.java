package ru.lightvsi.springmvcapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "good_description")
public class GoodDescription {
    @Id
    @Column(name = "serial_number", columnDefinition = "VARCHAR(64)")
    private String serialNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "good_date")
    private Date goodDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = OrderDetails.class)
    private OrderDetails orderDetails;

    public GoodDescription() {
    }

    public GoodDescription(String name, String address, Date goodDate) {
        this.name = name;
        this.address = address;
        this.goodDate = goodDate;
    }

    public GoodDescription(String serialNumber, String name, String address, Date goodDate) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.address = address;
        this.goodDate = goodDate;
    }

    public GoodDescription(String serialNumber, String name, String address, Date goodDate, OrderDetails orderDetails) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.address = address;
        this.goodDate = goodDate;
        this.orderDetails = orderDetails;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getGoodDate() {
        return goodDate;
    }

    public void setGoodDate(Date goodDate) {
        this.goodDate = goodDate;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "GoodDescription{" +
                "serialNumber='" + serialNumber + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", goodDate=" + goodDate +
                '}';
    }
}
