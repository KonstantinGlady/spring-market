package ru.gik.spring.market.springmarket.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gik.spring.market.springmarket.entities.Product;
import ru.gik.spring.market.springmarket.services.ProductsService;
import ru.gik.spring.market.springmarket.services.UserService;
import ru.gik.spring.market.springmarket.utils.ProductFilter;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private ProductsService productsService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String showAll(Model model, @RequestParam Map<String, String> requestParams) {
        Integer pageNumber = Integer.parseInt(requestParams.getOrDefault("p", "1"));
        ProductFilter productFilter = new ProductFilter(requestParams);
        Page<Product> products = productsService.findAll(productFilter.getSpec(), pageNumber);
        model.addAttribute("products", products);
        model.addAttribute("filterDef", productFilter.getFilterDefinition().toString());
        return "manage_products";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("usersList",userService.findAll());
        return "users";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add_product_form";
    }

    @PostMapping("/add")
    public String saveNewProduct(@ModelAttribute Product product) {
        productsService.saveOrUpdate(product);
        return "redirect:/admin/";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("products", productsService.findById(id));
        return "edit_product_form";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product) {
        productsService.saveOrUpdate(product);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productsService.deleteById(id);
        return "redirect:/admin/";
    }
}
