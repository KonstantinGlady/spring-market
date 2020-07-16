package ru.gik.spring.market.springmarket.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.gik.spring.market.springmarket.entities.Category;
import ru.gik.spring.market.springmarket.entities.Category_;
import ru.gik.spring.market.springmarket.entities.Product;
import ru.gik.spring.market.springmarket.entities.Product_;

import javax.persistence.criteria.*;

public class ProductSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(int minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLesserOrEqualsThan(int maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> titleContains(String title) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<Product> onlyCategories(String category) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> {
            ListJoin<Product, Category> productJoin = root.join(Product_.categories);
            return criteriaBuilder.equal(productJoin.get(Category_.ID), category);
        };
    }
}
