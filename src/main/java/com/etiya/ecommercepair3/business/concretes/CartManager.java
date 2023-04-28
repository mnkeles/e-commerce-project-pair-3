package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CartService;
import com.etiya.ecommercepair3.entities.concrete.Cart;
import com.etiya.ecommercepair3.repositories.abstracts.CartDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartManager implements CartService  {
    private CartDao cartDao;
    @Override
    public List<Cart> getAll() {
        return cartDao.findAll();
    }

    @Override
    public Cart getCartById(Integer id) {
        return cartDao.getById(id);
    }

    @Override
    public void addCart(Cart cart) {
        Cart cart1=getCartById(cart.getId());

        if(cart1!=null){
            return;
        }
        cartDao.save(cart);
    }
}
