package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

public class BasketItem {
    private final Product PRODUCT;
    private final int COUNT;

    public BasketItem(Product product, int count) {
        this.PRODUCT = product;
        this.COUNT = count;
    }

    public Product getProduct() {
        return PRODUCT;
    }

    public int getCount() {
        return COUNT;
    }
}