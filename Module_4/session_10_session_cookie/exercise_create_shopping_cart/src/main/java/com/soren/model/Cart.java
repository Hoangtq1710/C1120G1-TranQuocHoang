package com.soren.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Cart {

    private Map<Product, Integer> cart;

    public Cart() {
        cart = new HashMap<>();
    }

    public void addToCart(Product product, Integer amount){
        if (cart.containsKey(product)) {
            cart.put(product,cart.get(product) + amount);
        } else {
            cart.put(product, amount);
        }

    }

    public int getAmount(Product product){
        return cart.get(product);
    }

    public void removeProduct(Product product){
        cart.remove(product);
    }

    public int getSize(){
        return cart.size();
    }

    public List<Product> getListFromCart(){
        List<Product> list = new ArrayList<>();
        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
            list.add(entry.getKey());
        }
        return list;
    }

    public String getCookieCart(){
        StringBuilder cookie = new StringBuilder();
        if (!cart.isEmpty()) {
            for(Map.Entry<Product, Integer> entry : cart.entrySet()){
                cookie.append("split");
                cookie.append(entry.getKey().getId()+"and"+getAmount(entry.getKey()));
            }
            System.out.println(cookie.toString());
            return cookie.toString();
        } else {
            return "";
        }
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }
}
