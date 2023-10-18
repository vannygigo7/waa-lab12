package com.sangvaleap.lab12server.service.impl;

import com.sangvaleap.lab12server.model.Product;
import com.sangvaleap.lab12server.repository.ProductRepository;
import com.sangvaleap.lab12server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<Product> get() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) throws Exception {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product book) throws Exception {
        if(productRepository.existsById(id)) {
            return productRepository.save(book);
        }else{
            throw new Exception("Product is not found.");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }else{
            throw new Exception("Product is not found.");
        }
    }
}
