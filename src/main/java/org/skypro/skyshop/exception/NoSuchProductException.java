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

/* Данный фрагмент кода представляет собой определение пользовательского исключения NoSuchProductException, которое расширяет класс RuntimeException

    Конструктор этого исключения принимает строку message, которая будет передана в родительский класс RuntimeException.
    Это исключение используется для обозначения ситуации, когда запрошенный ресурс не найден, что часто происходит при обращении
    к несуществующему элементу в системе, например, к продукту с определённым id в интернет-магазине.

    Использование такого кастомного исключения позволяет эффективно обрабатывать ошибки на глобальном уровне с помощью ControllerAdvice
    и ExceptionHandler в Spring, возвращая информативные ответы пользователю без необходимости использования ResponseEntity в каждом методе контроллера.

    Теперь, если продукт не будет найден, выбросится NoSuchProductException.
*/