package com.demo.productsystem.service;

import com.demo.productsystem.dto.ProductDTO;
import com.demo.productsystem.model.Product;
import com.demo.productsystem.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productServiceImpl;
    @Mock
    private ProductRepository productRepository;

    @Test
    void testSave() {
        Product product = new Product();
        product.setName("test");
        product.setPrice(7678.0);
        product.setRanking(90);

        when(productRepository.save(any())).thenReturn(product);
        ProductDTO result = productServiceImpl.save(new ProductDTO());

        assertEquals(result.getName(),product.getName());
    }

    @Test
    void testGetAllProducts() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setName("test product");
            product.setRanking(20);
            product.setPrice(7000);
            productList.add(product);
        }
        when(productRepository.findAll()).thenReturn(productList);
        List<ProductDTO> result = productServiceImpl.getAllProducts();
    }

    @Test
    void testGetAllProductsBySorting() {


    }
}