package com.soren.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> cart;

    public Cart() {
        cart = new HashMap<>();
    }

    public void addToCart(Product product, Integer amount) {
        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + amount);
        } else {
            cart.put(product, amount);
        }

    }

    public int getSize(){
        if (!cart.isEmpty()) {
            return cart.size();
        }
        return 0;
    }

    public int getAmount(Product product) {
        return cart.get(product);
    }

    public void removeProduct(Product product) {
        cart.remove(product);
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }
}
