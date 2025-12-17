package com.jbeb.market.persistence.mapper;

import com.jbeb.market.domain.Category;
import com.jbeb.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

// Mapeador para convertir entre el objeto de dominio Category y el Entity Categoria
// Anotamos para indicar que es un mapeador y usamos componentModel para integrar con Spring
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Metodo toCategory, el nombre es importante ya que obtendremos un Category de una Categoria
    // Indicamos como seran los mapeos de los atributos
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    // toCategoria, obtendremos una Categoria de un Category
    // InheritInverseConfiguration indica a MapStruct que la conversion sera inversa a la anterior, por lo que ya no definimos Mappings
    // Ignoramos el atributo "productos" de Categoria, ya que en Category no se incluyo
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

}
