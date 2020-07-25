package ru.gik.spring.market.springmarket.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gik.spring.market.springmarket.entities.dto.ProductDto;
import ru.gik.spring.market.springmarket.exceptions.ProductNotFoundException;
import ru.gik.spring.market.springmarket.services.ProductsService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/products")
@Api("Set of endpoints for CRUD operations for Products")
public class RestProductController {
    ProductsService productsService;

    @Autowired
    public RestProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/dto")
    @ApiOperation("get  all dto")
    public List<ProductDto> getDto() {
        return productsService.getDto();
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(ProductNotFoundException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }
}
