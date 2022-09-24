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

    public void deleteProduct(FlowerDto flowerDto) {
            carts.remove(flowerDto);
    }

    public long payBill() {
        long totalBill = 0;
        for (Map.Entry<FlowerDto, Integer> payment : carts.entrySet()) {
            totalBill += payment.getKey().getPrice() * payment.getValue();
        }
        return totalBill;
    }
}
