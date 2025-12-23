package com.jbeb.market.domain.repository;

import com.jbeb.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();

    // Optional en caso de un cliente sin compras
    Optional<List<Purchase>> getByClient(String clientId);

    Purchase save(Purchase purchase);
}
