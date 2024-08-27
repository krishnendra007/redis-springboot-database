package com.redis.Repository;

import com.redis.config.AppConstants;
import com.redis.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private RedisTemplate template;

    public Product saveProduct (Product product){
        template.opsForHash().put(AppConstants.HASH_KEY,product.getId(),product);
        return product;
    }

    public List<Product> findAllProduct (){
        return template.opsForHash().values(AppConstants.HASH_KEY);
    }

    public Product findProductById(int id){
        return (Product) template.opsForHash().get(AppConstants.HASH_KEY,id);
    }

    public String deleteProductById(int id){
        template.opsForHash().delete(AppConstants.HASH_KEY,id);
        return "Product deleted with ID"+ id;
    }

}
