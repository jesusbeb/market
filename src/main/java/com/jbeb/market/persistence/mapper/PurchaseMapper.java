package com.jbeb.market.persistence.mapper;

import com.jbeb.market.domain.Purchase;
import com.jbeb.market.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    // el @Mapping "productos" a "items" es el que usa PurchaseItemMapper.class para convertir los productos uno a uno
    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items"),
    })
    Purchase toPurchase(Compra compra);

    // Lista de compras a Lista de purchases. Como ya se hizo el metodo anterior que lo hace para un objeto, este
    // metodo lo usara para crear la lista
    List<Purchase> toPurchases(List<Compra> compras);

    // Hacemos el metodo inverso. Si en la clase destino no tiene todos los atributos, se debe ignorar explicitamente
    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);
}
