package com.demo.productsystem.mapper;

import com.demo.productsystem.dto.ProductDTO;
import com.demo.productsystem.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    private ProductMapper() {}

    public static ProductDTO convertToDto(Product product) {
       ProductDTO productDTO = new ProductDTO();
       productDTO.setId(product.getId());
       productDTO.setName(product.getName());
       productDTO.setPrice(product.getPrice());
       productDTO.setRanking(product.getRanking());
       return productDTO;
    }

    public static Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setRanking(productDTO.getRanking());
        return product;
    }

    public static List<ProductDTO> listProductDTO(List<Product> productList) {
       List<ProductDTO> productDTOList = new ArrayList<>();
        productList.forEach(product -> {
            productDTOList.add(convertToDto(product));
        });
       return productDTOList;
    }
}
