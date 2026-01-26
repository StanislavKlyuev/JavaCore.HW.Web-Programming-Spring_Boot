package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;
import java.util.Objects;

public final class Article implements Searchable {

    private final String ARTICLE;
    private final String TEXT;

    private final UUID id;

    public Article(String ARTICLE, String TEXT) {
        if (ARTICLE == null || ARTICLE.isBlank() || TEXT == null || TEXT.isBlank())
            throw new IllegalArgumentException("Описание продукта не действительно");
        this.ARTICLE = ARTICLE;
        this.TEXT = TEXT;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return ARTICLE + " - " + TEXT;
    }

    @JsonIgnore
    @Override
    public String getSearchName() {
        return toString();
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Article article)) return false;
        return Objects.equals(ARTICLE, article.ARTICLE);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ARTICLE);
    }

    /*    @Override
        public int compareTo(Searchable o) {
            return getSearchName().compareTo(o.getSearchName());
        }
    */
    public UUID getId() {
        return this.id;
    }
}