package ru.gik.spring.market.springmarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gik.spring.market.springmarket.entities.Product;
import ru.gik.spring.market.springmarket.entities.dto.ProductDto;

import java.util.List;

@Repository
public interface ProductsRepository extends  JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    List<ProductDto> findAllBy();
}
