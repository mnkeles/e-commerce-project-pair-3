package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercepair3.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercepair3.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDao extends JpaRepository<Order,Integer> {

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.order.ListOrderResponse" +
            "(o.id,c.id,a.id,p.id,i.id,s.id) From Order o join Customer c join Address a join " +
            " Payment  p join Invoice  i join Supplier s")
    List<ListOrderResponse> getAll();

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.order.OrderDetailResponse" +
            "(o.id,c.id,a.id,p.id,i.id,s.id) From Order o join Customer c join Address a join" +
            " Payment  p join Invoice i join Supplier s where o.id=:id")
    OrderDetailResponse getByOrderId(Integer id);
}
