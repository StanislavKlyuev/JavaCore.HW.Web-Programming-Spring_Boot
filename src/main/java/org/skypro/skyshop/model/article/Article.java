package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;
import java.util.Objects;

public final class Article implements Searchable {

    private final String article;
    private final String text;

    private final UUID id;

    public Article(String article, String text) {
        if (article == null || article.isBlank() || text == null || text.isBlank())
            throw new IllegalArgumentException("Описание продукта не действительно");
        this.article = article;
        this.text = text;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return article + " - " + text;
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
        return Objects.equals(this.article, article.article);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(article);
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