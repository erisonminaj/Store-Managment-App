package com.Main.StorageManagment.Repository;

import com.Main.StorageManagment.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    Optional<Product> findProductById(Long id);

    List<Product> findProductByCategory(String category);
}
