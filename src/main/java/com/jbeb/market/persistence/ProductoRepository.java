package com.jbeb.market.persistence;

import com.jbeb.market.domain.Product;
import com.jbeb.market.domain.repository.ProductRepository;
import com.jbeb.market.persistence.crud.ProductoCrudRepository;
import com.jbeb.market.persistence.entity.Producto;
import com.jbeb.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// ProductoRepository lo orientamos al dominio (Product) implementando de ProductRepository
@Repository
public class ProductoRepository implements ProductRepository{
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    // finAll() retorna una Iterable, por eso lo casteamos a List
    // List<Producto> lo mapeamos a List<Product> con el metodo toProducts de mapper
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Product> products = mapper.toProducts( productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId) );
        return Optional.of(products);
    }

    // Como no se tiene un mapeador que convierta de Optional<List<Producto>> a Optional<List<Product>> hacemos map a
    // List<Producto> y con toProducts() convertimos a List<Product>, ya con esto map retorna por default un List<Optional>
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity){
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map( prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(producto);
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

}
