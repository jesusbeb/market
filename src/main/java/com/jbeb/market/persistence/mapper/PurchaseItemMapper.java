package com.jbeb.market.persistence.mapper;

import com.jbeb.market.domain.PurchaseItem;
import com.jbeb.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

// Como se hace referencia internamente a ProductMapper.class aunque para ignorarlo, lo incluimos
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    // Para convertir a productId, tenemos que el id no esta dentro de ComprasProducto, sino
    // dentro del atributo "id" de tipo ComprasProductoPK y se llama idProducto
    // No es necesario incluir atributos que tienen el mismo nombre en source y target
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    // Hacemos el mapper contrario. InheritInverseConfiguratio toma la configuracion del metodo anterior de forma inversa
    // Con Mapping indicamos los atributos que no incluiremos
    // id.idCompra no esta incluido en el metodo anterior, asi que lo indicamos para ser ignorado
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);

}
