package ru.gik.spring.market.springmarket.repositories.specifications;

import org.springframework.stereotype.Repository;
import org.springframework.util.SerializationUtils;
import ru.gik.spring.market.springmarket.entities.OrderItem;
import ru.gik.spring.market.springmarket.entities.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class CartRepository {
    private HashMap<Integer, OrderItem> cart;
    private int id;

    public CartRepository() {
        this.cart = new HashMap<>();
        this.id = 0;
    }

    public HashMap<Integer, OrderItem> getCart() {
        return new HashMap<>(cart);
    }

    public void save(Product product) {

        cart.put(++id, new OrderItem(product, 1, product.getPrice()));
    }

    public void remove(Integer id) {
        cart.remove(id);
    }
}
