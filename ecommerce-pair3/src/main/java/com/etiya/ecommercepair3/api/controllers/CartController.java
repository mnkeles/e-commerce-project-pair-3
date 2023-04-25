package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.AddressService;
import com.etiya.ecommercepair3.business.abstracts.CartService;
import com.etiya.ecommercepair3.entities.concrete.Address;
import com.etiya.ecommercepair3.entities.concrete.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private CartService cartService;

    @GetMapping()
    public List<Cart> getAll(){
        return cartService.getAll();
    }

    @GetMapping("/{id}")
    public Cart getCartById(Integer id){
        return cartService.getCartById(id);
    }

    @PostMapping("/add")
    public void addCart(Cart cart){
        cartService.addCart(cart);
    }
}
