package com.sangvaleap.lab12server.service;
import com.sangvaleap.lab12server.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> get();
    Product getById(Long id) throws Exception;
    Product add(Product product);

    Product update(Long id, Product book) throws Exception;
    void delete(Long id) throws Exception;
}
