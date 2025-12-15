package com.jbeb.market.persistence;

import com.jbeb.market.persistence.crud.ProductoCrudRepository;
import com.jbeb.market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    // finAll() retorna una Iterable, por eso lo casteamos a List
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
