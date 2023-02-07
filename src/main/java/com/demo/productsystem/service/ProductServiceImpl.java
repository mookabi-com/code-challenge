package com.demo.productsystem.service;

import com.demo.productsystem.dto.ProductDTO;
import com.demo.productsystem.mapper.ProductMapper;
import com.demo.productsystem.model.Product;
import com.demo.productsystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = ProductMapper.convertToEntity(productDTO);
        return ProductMapper.convertToDto(productRepository.save(product));
    }
    @Override
    public List<ProductDTO> getAllProducts() {
        return ProductMapper.listProductDTO(productRepository.findAll());
    }
    @Override
    public List<ProductDTO> getAllProductsBySorting(String sortBy) {
        List<Product> products = null;
        if (sortBy == null || sortBy.equals("ranking")) {
            products = productRepository.findAllByOrderByRanking();
        } else if (sortBy.equals("price")) {
            products = productRepository.findAllByPriceGreaterThanEqualOrderByPriceAsc();
        }
        return ProductMapper.listProductDTO(products);
    }

}
