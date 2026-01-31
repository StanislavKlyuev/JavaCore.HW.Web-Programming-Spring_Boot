package org.skypro.skyshop.service;

/*
Сервис для управления корзиной пользователя
 */

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProduct(UUID id) {
        if (storageService.getProductById(id).isPresent()) {
            productBasket.addProduct(id);
        } else {
            throw new IllegalArgumentException("Товар не найден");
        }
    }

    public UserBasket getUserBasket() {
        return new UserBasket(productBasket.getProductsFromBasket().entrySet().stream().
                map(s -> new BasketItem(storageService.getProductById(s.getKey()).orElseThrow(() -> new IllegalArgumentException("Product not found for ID: " + s.getKey())), s.getValue())).
                collect(Collectors.toCollection(ArrayList::new)));
    }
}