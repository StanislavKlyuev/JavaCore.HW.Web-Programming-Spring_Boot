package org.skypro.skyshop.model.basket;

import java.util.ArrayList;

public class UserBasket {
    private final ArrayList<BasketItem> basketItemList;
    private final Integer total;

    public UserBasket(ArrayList<BasketItem> userList) {
        this.basketItemList = userList;
        this.total = userList.stream().mapToInt(s -> s.getProduct().getPrice() * s.getCount()).sum();
    }

    public ArrayList<BasketItem> getBasketItemList() {
        return basketItemList;
    }

    public Integer getTotal() {
        return total;
    }
}