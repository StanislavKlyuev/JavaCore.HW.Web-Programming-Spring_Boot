package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> productMap;

    public ProductBasket() {
        this.productMap = new HashMap<>();
    }

    public void addProduct(UUID id) {
        Integer count = productMap.get(id);
        if (count == null) {
            productMap.put(id, 1);
        } else {
            productMap.put(id, ++count);
        }
    }

    public Map<UUID, Integer> getProductsFromBasket() {
        return Collections.unmodifiableMap(this.productMap);
    }
}