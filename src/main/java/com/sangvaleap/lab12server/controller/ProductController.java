package com.sangvaleap.lab12server.controller;

import com.sangvaleap.lab12server.model.Product;
import com.sangvaleap.lab12server.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/products"})
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> get() {
        return productService.get();
    }

    @GetMapping(value = {"/{id}"})
    public Product getById(@PathVariable long id) throws Exception {
        return productService.getById(id);
    }

    @PostMapping
    public Product addBook(@RequestBody Product product) {
        return  productService.add(product);
    }

    @PutMapping(value = {"/{id}"})
    public Product updateBook(@PathVariable long id, @RequestBody Product product) throws Exception {
        return productService.update(id, product);
    }

    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable long id)  throws Exception{
        productService.delete(id);
    }
}
