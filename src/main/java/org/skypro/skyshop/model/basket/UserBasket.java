package org.skypro.skyshop.model.basket;

import java.util.ArrayList;

public class UserBasket {
    private final ArrayList<BasketItem> USERLIST;
    private final int TOTAL;

    public UserBasket(ArrayList<BasketItem> userList) {
        this.USERLIST = userList;
        this.TOTAL = userList.stream().mapToInt(s -> s.getProduct().getPrice() * s.getCount()).sum();
    }

    public ArrayList<BasketItem> getUSERLIST() {
        return USERLIST;
    }

    public int getTOTAL() {
        return TOTAL;
    }
}