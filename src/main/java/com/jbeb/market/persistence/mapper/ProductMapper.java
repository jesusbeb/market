package com.jbeb.market.persistence.mapper;

import com.jbeb.market.domain.Product;
import com.jbeb.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

// Mapeador para convertir entre el objeto de dominio Product y el Entity Producto
// Como mapeamos el atributo categoria y este ya tiene su mapeador, lo indicamos con uses=, asi internamente lo usara
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos); // Incluimos un mapeador para cuando se necesite una Lista entre Productos y Products

    // Hacemos el mapeador inverso
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
