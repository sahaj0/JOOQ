package com.example.demo.controller;

import com.example.demo.service.ProductService;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public String addProduct(@RequestBody Product product) {


        productService.insertProduct(product);
        return "Product Added!";
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @DeleteMapping("/deleteById/{productId}")
    public String delete(@PathVariable Long productId){
        productService.deleteById(productId);
        return "deleted";
    }

    @PutMapping("/updateById/{productId}")
    public String update(@PathVariable Long productId,@RequestBody Product product){
        productService.updateProducts(productId,product.getProductName(),product.getProductPrice());
        return "updated";

    }

}
