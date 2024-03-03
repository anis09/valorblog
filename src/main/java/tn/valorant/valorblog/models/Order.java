package tn.valorant.valorblog.models;

import java.util.List;

public class Order {

    private String order_id;
    private List<Product> order_items;
    private double order_price;
    private User order_owner;


    public Order(){

    }

    public Order(String order_id, List<Product> order_items, double order_price, User order_owner) {
        this.order_id = order_id;
        this.order_items = order_items;
        this.order_price = order_price;
        this.order_owner = order_owner;
    }

    public Order(List<Product> order_items, double total_price, User order_owner) {
        this.order_items = order_items;
        this.order_price = total_price;
        this.order_owner = order_owner;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public List<Product> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(List<Product> order_items) {
        this.order_items = order_items;
    }

    public double getTotal_price() {
        return order_price;
    }

    public void setTotal_price(double order_price) {
        this.order_price = order_price;
    }

    public User getOrder_owner() {
        return order_owner;
    }

    public void setOrder_owner(User order_owner) {
        this.order_owner = order_owner;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", order_items=" + order_items +
                ", order_price=" + order_price +
                ", order_owner=" + order_owner +
                '}';
    }
}
