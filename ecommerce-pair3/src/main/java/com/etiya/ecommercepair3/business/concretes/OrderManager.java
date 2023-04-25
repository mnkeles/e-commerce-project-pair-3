package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.OrderService;
import com.etiya.ecommercepair3.entities.concrete.Order;
import com.etiya.ecommercepair3.repositories.abstracts.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderManager implements OrderService {
    private OrderDao orderDao;


    @Override
    public List<Order> getAll() {
        return orderDao.findAll();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderDao.getById(id);
    }

    @Override
    public void addOrder(Order order) {
        if(order.getCustomer().getId()==null){
            return;
        }

        orderDao.save(order);
    }
}
