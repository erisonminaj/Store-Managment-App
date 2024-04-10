package com.Main.StorageManagment;

import com.Main.StorageManagment.Service.ProductService;
import com.Main.StorageManagment.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productContrroller {

    private final ProductService productService;

    public productContrroller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/get/{category}")
    public ResponseEntity<List<Product>>getProductsByCategory(@PathVariable("category") String category) {
        List<Product> products = productService.getProductsByCategory(category);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @PutMapping ("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.CREATED);
    }
    @PutMapping ("/delete/{id}")
    public ResponseEntity<?>deleteProductById(@PathVariable("id") Long id) {
       productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
