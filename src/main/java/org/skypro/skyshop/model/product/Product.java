package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;
import java.util.Objects;

public abstract class Product implements Searchable {

    private String name;
    private final UUID id;

    public Product(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Имя продукта не корректно");
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return name;
    }

    public abstract boolean isSpecial();

    @JsonIgnore
    @Override
    public String getSearchName() {
        return name;
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    /*    @Override
        public int compareTo(Searchable o) {
            return name.compareTo(o.getSearchName());
        }
    */
    public UUID getId() {
        return this.id;
    }
}