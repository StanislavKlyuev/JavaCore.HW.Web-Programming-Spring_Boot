package org.skypro.skyshop.exception;

import java.util.UUID;

public class NoSuchProductException extends RuntimeException {

    public NoSuchProductException() {
        super("Товар не найден");
    }

    public NoSuchProductException(UUID id) {
        super("Товар с индексом " + '<' + id.toString() + '>' + " не найден");
    }
}