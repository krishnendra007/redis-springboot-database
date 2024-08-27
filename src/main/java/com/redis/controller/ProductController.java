package com.redis.controller;

import com.redis.Repository.ProductDao;
import com.redis.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDao dao;

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return  dao.saveProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return dao.findAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProductsById(@PathVariable int id){
            return dao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public  String deleteProduct(@PathVariable int id){
        return dao.deleteProductById(id);
    }
}
