package com.Main.StorageManagment.Service;

import com.Main.StorageManagment.Repository.ProductRepository;
import com.Main.StorageManagment.exception.CategoryNotFoundException;
import com.Main.StorageManagment.exception.ProductNotFoundException;
import com.Main.StorageManagment.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(Long id) {
        return productRepository.findProductById(id).orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " was not found."));
    }


    public List<Product> getProductsByCategory(String category) {
        List<Product> products = productRepository.findProductByCategory(category);

        if (products.isEmpty()) {
            throw new CategoryNotFoundException("No products were found for " + category + "!");
        }

        return products;
    }


    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }




}
