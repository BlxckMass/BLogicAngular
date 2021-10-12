package ru.blogic.blogicspring.entity.document;

/**
 * Перечисление методов доставки
 *
 * @author evaleev
 */
public enum DeliveryMethod {
    DELIVERY("Доставка"),
    PICK_UP("Самовывоз");

    /**
     * Поле для получения содержания из перечисления
     */
    private String message;

    DeliveryMethod(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

