package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.StorageService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @Mock
    private StorageService mockStorageService;

    @Mock
    private ProductBasket mockProductBasket;

    @InjectMocks
    private BasketService basketService;

    @Test
    public void addNonExistentProduct() {
        UUID invalidId = UUID.randomUUID();
        when(mockStorageService.getProductById(invalidId)).thenReturn(Optional.empty());
        assertThrows(NoSuchProductException.class, () -> basketService.addProduct(invalidId));
    }

    @Test
    public void addExistentProduct() {
        UUID validId = UUID.randomUUID();
        Product testProduct = new SimpleProduct("TestProduct", 10);
        when(mockStorageService.getProductById(validId)).thenReturn(Optional.of(testProduct));
        basketService.addProduct(validId);
        verify(mockProductBasket, times(1)).addProduct(validId);
    }

    @Test
    public void whenProductBasketisEmpty() {
        when(mockProductBasket.getProductsFromBasket()).thenReturn(new HashMap<>());
        assertTrue(basketService.getUserBasket().getBasketItemList().isEmpty());
        assertEquals(0, basketService.getUserBasket().getTotal());
    }

    @Test
    public void whenBusketIsContainSimpleProduct() {
        UUID validId = UUID.randomUUID();
        Product testProduct = new SimpleProduct("testProduct", 30);
        Map<UUID, Integer> testMap = Map.of(validId, 3);
        when(mockProductBasket.getProductsFromBasket()).thenReturn(testMap);
        when(mockStorageService.getProductById(validId)).thenReturn(Optional.of(testProduct));
        assertEquals(90, basketService.getUserBasket().getTotal());
        assertEquals(1, basketService.getUserBasket().getBasketItemList().size());
    }
}
