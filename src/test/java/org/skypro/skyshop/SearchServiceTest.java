package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private StorageService mockStorageService;

    @InjectMocks
    private SearchService searchService;

    @Test
    public void whenStorageServiceIsEmpty_ThenSearchServiceReturnEmptyList() {
        Mockito.when(mockStorageService.getAllSearchable()).thenReturn(Collections.emptyList());
        assertTrue(searchService.search("TestProduct").isEmpty());
        verify(mockStorageService, times(1)).getAllSearchable();
    }

    @Test
    public void whenStorageServiceIsNotEmpty_ButNotNecessaryProduct() {
        Product product = new SimpleProduct("notProd", 30);
        Mockito.when(mockStorageService.getAllSearchable()).thenReturn(Collections.singletonList(product));
        assertTrue(searchService.search("Product").isEmpty());
        verify(mockStorageService, times(1)).getAllSearchable();
    }

    @Test
    public void whenStorageServiceIsNotEmpty_WhenFindeProduct() {
        Product goodProduct = new SimpleProduct("TestProduct", 30);
        Product badProduct = new DiscountedProduct("notProd", 50, 20);
        Mockito.when(mockStorageService.getAllSearchable()).thenReturn(Arrays.asList(goodProduct, badProduct));
        assertEquals(1, searchService.search("Product").size());
    }

    @Test
    public void whenStorageServiceIsNotEmpty_WhenFindeArticleByName() {
        Article goodArticle = new Article("TestArticle", "text");
        Article badArticle = new Article("name", "text");
        Mockito.when(mockStorageService.getAllSearchable()).thenReturn(Arrays.asList(goodArticle, badArticle));
        assertEquals(1, searchService.search("Article").size());
    }

    @Test
    public void whenStorageServiceIsNotEmpty_WhenFindeArticleByText() {
        Article goodArticle = new Article("Name", "TestArticleText");
        Article badArticle = new Article("name", "text");
        Mockito.when(mockStorageService.getAllSearchable()).thenReturn(Arrays.asList(goodArticle, badArticle));
        assertEquals(1, searchService.search("article").size());
    }
}
