package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartDao extends JpaRepository<Cart,Integer> {
    @Query("SELECT c FROM Cart c")
    List<Cart> findAllByCart();

    @Query("SELECT c.id, cu.refunds, cu.id FROM Cart c JOIN c.order cu")
    List<Cart>getOrderByCart();

    Cart getById(Integer id);
}
