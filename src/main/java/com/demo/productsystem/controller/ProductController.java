package com.demo.productsystem.controller;

import com.demo.productsystem.dto.ProductDTO;
import com.demo.productsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String add(@RequestBody ProductDTO product){
        productService.save(product);
        return "New product is added";
    }
    @GetMapping("/get-all")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{sortBy}")
    public List<ProductDTO> getProducts(@PathVariable String sortBy) {
        return productService.getAllProductsBySorting(sortBy);

    }


}
