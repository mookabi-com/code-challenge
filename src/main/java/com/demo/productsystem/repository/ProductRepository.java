package com.demo.productsystem.repository;

import com.demo.productsystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p FROM Product p ORDER BY p.ranking DESC")
    List<Product> findAllByOrderByRanking();
    @Query("SELECT p FROM Product p ORDER BY p.price DESC")
    List<Product> findAllByPriceGreaterThanEqualOrderByPriceAsc();

}
