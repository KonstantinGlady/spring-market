package ru.gik.spring.market.springmarket.utils;

import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;
import ru.gik.spring.market.springmarket.entities.Product;
import ru.gik.spring.market.springmarket.repositories.specifications.ProductSpecifications;

import java.util.Map;

@Getter
public class ProductFilter {
    private Specification<Product> spec;
    private StringBuilder filterDefinition;

    public ProductFilter(Map<String, String> map) {
        this.spec = Specification.where(null);
        this.filterDefinition = new StringBuilder();
        if (map.containsKey("min_price") && !map.get("min_price").isEmpty()) {
            int minPrice = Integer.parseInt(map.get("min_price"));
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(minPrice));
            filterDefinition.append("&min_price=").append(minPrice);
        }
        if (map.containsKey("max_price") && !map.get("max_price").isEmpty()) {
            int maxPrice = Integer.parseInt(map.get("max_price"));
            spec = spec.and(ProductSpecifications.priceLesserOrEqualsThan(maxPrice));
            filterDefinition.append("&max_price=").append(maxPrice);
        }
        if (map.containsKey("product_name") && !map.get("product_name").isEmpty()) {
            String title = map.get("product_name");
            spec = spec.and(ProductSpecifications.titleContains(title));
            filterDefinition.append("&product_name=").append(title);
        }

        if (map.containsKey("product_category") && !map.get("product_category").isEmpty()) {
            String category = map.get("product_category");
            spec = spec.and(ProductSpecifications.onlyCategories(category));
            filterDefinition.append("&category=").append(category);
        }

    }
}
