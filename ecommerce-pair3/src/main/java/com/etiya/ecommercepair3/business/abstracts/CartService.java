package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Address;
import com.etiya.ecommercepair3.entities.concrete.Cart;

import java.util.List;

public interface CartService {

    List<Cart> getAll();
    Cart getCartById(Integer id);

    void addCart(Cart cart);
}
