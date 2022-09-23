package com.cart.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {

    private Map<FlowerDto, Integer> carts = new HashMap<>();

    public CartDto() {
    }

    public Map<FlowerDto, Integer> getCarts() {
        return carts;
    }

    public void setCarts(Map<FlowerDto, Integer> carts) {
        this.carts = carts;
    }

    public void addToCart(FlowerDto flowerDto) {
        if (carts.containsKey(flowerDto)) {
            int currentCart = carts.get(flowerDto);
            carts.put(flowerDto, currentCart + 1);
        } else {
            carts.put(flowerDto, 1);
        }
    }

    public void decreaseProduct(FlowerDto flowerDto) {
//        if (carts.containsKey(flowerDto)) {
            int currentCart = carts.get(flowerDto);
            carts.put(flowerDto, currentCart - 1);
            if (currentCart == 1) {
                carts.remove(flowerDto);
            }
//        }
    }

    public void deleteProduct(int id) {
            carts.remove(id);
    }

    public long payBill() {
        return 0;
    }
}
