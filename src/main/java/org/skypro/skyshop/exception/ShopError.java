package org.skypro.skyshop.exception;

public class ShopError {
    private final String code = "404";
    private final String message;

    public ShopError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}