package com.springBoot.demo.services;

import com.springBoot.demo.entities.Category;
import com.springBoot.demo.entities.Product;
import com.springBoot.demo.repositories.CategoryRepository;
import com.springBoot.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return  obj.get();
    }

}
