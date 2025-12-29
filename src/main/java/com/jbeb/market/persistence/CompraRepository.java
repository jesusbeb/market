package com.jbeb.market.persistence;

import com.jbeb.market.domain.Purchase;
import com.jbeb.market.domain.repository.PurchaseRepository;
import com.jbeb.market.persistence.crud.CompraCrudRepository;
import com.jbeb.market.persistence.entity.Compra;
import com.jbeb.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;


    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases( (List<Compra>) compraCrudRepository.findAll() );
    }

    // Metodo para obtener listas de compras por cliente
    // Aplicamos map para obtener cada compra y mapearla a purchase
    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
        .map(compras -> mapper.toPurchases(compras));
    }

    // El purchase lo mapeamos a compra.
    // La informacion se tiene que guardar en cascada, por lo que compra debe conocer los productos y los
    // producos deben saber a que compra pertenecen, para eso recorremos cada producto y lo asignamos a la
    // compra que se convirtio
    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
