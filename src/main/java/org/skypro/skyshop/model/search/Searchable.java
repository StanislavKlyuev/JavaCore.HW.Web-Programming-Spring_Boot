package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {

    default String getStringRepresentation() {
        return getSearchName() + " - " + getClass().getSimpleName();
    }

    String getContentType();

    String getSearchName();

    UUID getId();
}