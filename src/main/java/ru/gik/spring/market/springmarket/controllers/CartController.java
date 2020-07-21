package ru.gik.spring.market.springmarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gik.spring.market.springmarket.services.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("cartList", cartService.findAll());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable Long id) {
        cartService.save(id);
        return "redirect:/products/";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Integer id) {
        cartService.remove(id);
        return "redirect:/cart/";
    }
}
