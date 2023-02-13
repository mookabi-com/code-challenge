package com.demo.productsystem.service;

import com.demo.productsystem.dto.ProductDTO;
import com.demo.productsystem.model.Product;

import java.util.List;

public interface ProductService {
    public ProductDTO save(ProductDTO product);
    public List<ProductDTO> getAllProducts();
    List<ProductDTO> getAllProductsBySorting(String sortBy);
}
