package ru.gik.spring.market.springmarket.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItem {
    private Product product;
    private int amount;
    private int price;

    public OrderItem(Product product, int amount, int price) {
        this.product = product;
        this.amount = amount;
        this.price = price;
    }
}
