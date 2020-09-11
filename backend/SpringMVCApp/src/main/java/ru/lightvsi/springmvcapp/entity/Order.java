package ru.lightvsi.springmvcapp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "order_sum")
    private int orderSum;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;

    @JsonIgnore
    @OneToOne(mappedBy = "orderId", cascade = CascadeType.ALL)
    private OrderDetails orderDetails;

    public Order() {
    }

    public Order(String name, String address, int orderSum, Date orderDate) {
        this.name = name;
        this.address = address;
        this.orderSum = orderSum;
        this.orderDate = orderDate;
    }

    public Order(String name, String address, int orderSum, Date orderDate, OrderDetails orderDetails) {
        this.name = name;
        this.address = address;
        this.orderSum = orderSum;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(int orderSum) {
        this.orderSum = orderSum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
