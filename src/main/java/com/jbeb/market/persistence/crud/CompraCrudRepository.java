package com.jbeb.market.persistence.crud;

import com.jbeb.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    // Query Method
    Optional<List<Compra>> findByIdCliente(String idCliente);

}
