package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> MAP;

    public ProductBasket() {
        this.MAP = new HashMap<>();
    }

    public void addProduct(UUID id) {
        Integer count = MAP.get(id);
        if (count == null) {
            MAP.put(id, 1);
        } else {
            MAP.put(id, ++count);
        }
    }

    public Map<UUID, Integer> getProductsFromBasket() {
        return Collections.unmodifiableMap(this.MAP);
    }
}