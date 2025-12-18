package com.jbeb.market.domain.service;

import com.jbeb.market.domain.Product;
import com.jbeb.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Servicio de dominio, es como un intermediario entre el controlador de la API y el repositorio
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    // delete no retorna nada en ProductRepository, pero en el servicio hacemos que retorne un boolean
    public boolean delete(int productId){
        if (getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        } else {
            return false;
        }
    }

}
