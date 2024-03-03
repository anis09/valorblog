package tn.valorant.valorblog.interfaces;

import tn.valorant.valorblog.models.Order;
import java.util.ArrayList;

public interface IOrderService<T> {

    void addOrder(T t);
    Order getOrder();
    ArrayList<T> getOrders();
    void updateOrder(T t);
    Boolean deleteOrder();
}
