package ru.lightvsi.springmvcapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = GoodDescription.class, cascade = CascadeType.ALL)
    @Column(name = "goods")
    private List<GoodDescription> goods = new ArrayList<GoodDescription>();

    @Column(name = "amount")
    private String amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order orderId;

    public OrderDetails() {
    }

    public OrderDetails(String amount) {
        this.amount = amount;
    }

    public OrderDetails(String amount, Order orderId) {
        this.amount = amount;
        this.orderId = orderId;
    }

    public OrderDetails(List<GoodDescription> goods, String amount, Order orderId) {
        this.goods = goods;
        this.amount = amount;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<GoodDescription> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodDescription> goods) {
        this.goods = goods;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }
}
