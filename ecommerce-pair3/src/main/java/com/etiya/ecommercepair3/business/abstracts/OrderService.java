package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Address;
import com.etiya.ecommercepair3.entities.concrete.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAll();
    Order getOrderById(Integer id);
    void addOrder(Order order);
}
