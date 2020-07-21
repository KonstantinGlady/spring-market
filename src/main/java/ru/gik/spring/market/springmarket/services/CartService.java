package ru.gik.spring.market.springmarket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gik.spring.market.springmarket.entities.OrderItem;
import ru.gik.spring.market.springmarket.entities.Product;
import ru.gik.spring.market.springmarket.repositories.specifications.CartRepository;

import java.util.HashMap;
import java.util.List;

@Service
public class CartService {


    private CartRepository cartRepository;
    private ProductsService productsService;

    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    public HashMap<Integer, OrderItem> findAll() {
        return cartRepository.getCart();
    }

    public void save(Long id) {
        cartRepository.save(productsService.findById(id));
    }

    public void remove(Integer id) {
        cartRepository.remove(id);
    }

}
