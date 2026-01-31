package org.skypro.skyshop.service;

/*
Сервис для хранения всех возможных товаров и статей
 */

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> productMap;
    private final Map<UUID, Article> articleMap;

    public StorageService() {
        this.productMap = new HashMap<>();
        this.articleMap = new HashMap<>();
        fillingMap();
    }

    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    public Collection<Article> getAllArticle() {
        return articleMap.values();
    }

    private void fillingMap() {
        Product lemon = new SimpleProduct("Lemon", 30);
        Product apple = new SimpleProduct("Apple", 50);
        Product watermellon = new SimpleProduct("Watermellon", 95);
        Product appleDis = new DiscountedProduct("Apple", 50, 10);
        Product lemonDis = new DiscountedProduct("Lemon", 30, 30);
        Product watermellonDis = new DiscountedProduct("Watermellon", 90, 20);
        Product corn = new DiscountedProduct("Corn", 25, 10);
        Product appleFix = new FixPriceProduct("Apple");
        Product tomato = new FixPriceProduct("Tomato");

        productMap.put(lemon.getId(), lemon);
        productMap.put(apple.getId(), apple);
        productMap.put(watermellon.getId(), watermellon);
        productMap.put(appleDis.getId(), appleDis);
        productMap.put(lemonDis.getId(), lemonDis);
        productMap.put(watermellonDis.getId(), watermellonDis);
        productMap.put(corn.getId(), corn);
        productMap.put(appleFix.getId(), appleFix);
        productMap.put(tomato.getId(), tomato);

        Article appleInfo = new Article("Apple", "Фрукт. Цвет - красный, жёлтый, зеленый. Круглый, сочный, сладкий. Растет в саду. На ощуп твердый, гладкий. Едят сырым, варят варенье, готовят сок.");
        Article lemonInfo = new Article("Lemon", "Фрукт из рода цитрусовых. Фрукт овальный, жёлтый, имеет приятный запах и кислый. Сверху покрыт кожурой, внутри есть дольки и семена");
        Article watermellonInfo = new Article("Watermellon", "Крупная ягода. Чаще всего круглый или овальный. Окрас белый, жёлтый, тёмно-зелёный. Едят сырым, делают сок, варят варенье.");
        Article cornInfo = new Article("Corn", "Травянистое растение. Злак. Плод — початок, спрятанный под зелёными листьями-обёртками. На початке рядами растут жёлтые, белые или даже разноцветные зёрна.");
        Article tomatoInfo = new Article("Tomato", "Овощ. Красный и круглый. На вкус кисло-сладкий. Растёт в огороде на грядке. На ощупь мягкий, гладкий. Можно приготовить салат, суп, сок, кетчуп.");

        articleMap.put(appleInfo.getId(), appleInfo);
        articleMap.put(lemonInfo.getId(), lemonInfo);
        articleMap.put(watermellonInfo.getId(), watermellonInfo);
        articleMap.put(cornInfo.getId(), cornInfo);
        articleMap.put(tomatoInfo.getId(), tomatoInfo);
    }

    public Collection<Searchable> getAllSearchable() {
        Collection<Searchable> coll = new ArrayList<>();
        coll.addAll(productMap.values());
        coll.addAll((articleMap.values()));
        return coll;
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(productMap.get(id));
    }
}