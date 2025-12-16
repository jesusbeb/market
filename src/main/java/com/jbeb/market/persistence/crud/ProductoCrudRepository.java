package com.jbeb.market.persistence.crud;

import com.jbeb.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// Interface que extiende de CrudRepository para consultas de Producto en la BD
// <Tabla, tipo de dato de clave primaria>
// Dentro de esta interface solo se esciben metodos de consulta mas complejos que no incluye CrudRepository
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{

    // Otra forma de hacer findByCategoria con codigo SQL:
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    //List<Producto> findByCategoria_(int idCategoria);

    // Query Methods. En el nombre del metodo (ademas de las palabras reservadas), se incluyen los nombres que estan en
    // los parametros, en ambas partes estos nombres deben coincidir sin importar el CamelCase
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}



/*
¿Qué son los repositorios de Spring Data y cómo nos ayudan?
Spring Data nos ofrece herramientas poderosas y los repositorios son una de las más destacadas. Diseñados para
simplificar el desarrollo de aplicaciones empresariales en Java, estos repositorios nos permiten realizar operaciones en
bases de datos sin tener que escribir código complejo. A través de ellos, operaciones comunes como eliminar,
encontrar registros o guardar información se ejecutan de manera automática. Los tipos de repositorios que Spring Data ofrece incluyen:

- CrudRepository: Permite realizar operaciones básicas como crear, leer, actualizar y borrar.
- PagingAndSortingRepository: Además de las capacidades del CrudRepository, permite el paginado y ordenamiento de datos.
- JpaRepository: Combina las funcionalidades anteriores y ofrece características específicas de JPA, como Flush.

¿Qué métodos proporciona un CrudRepository?
Los métodos que incluye CrudRepository son variados y útiles para gestionar datos:

save: Guarda una entidad específica.
saveAll: Guarda una lista completa de entidades.
findById: Recupera una entidad usando su ID.
existsById: Verifica la existencia de un registro en la base de datos.
findAll: Recupera todos los registros de una tabla.
findAllById: Recupera los registros que pertenecen a una lista de IDs.
count: Cuenta cuántos registros existen en una tabla.
deleteById: Borra un registro específico por su ID.
deleteAll: Borra todos los registros o una lista específica de registros.

Estos métodos simplifican enormemente el manejo de datos y son inmediatos de usar sin necesidad de implementación adicional.
 */

/*
¿Qué son y cómo funcionan los queryMetods?
Los queryMetods permiten generar consultas simplemente mediante el nombramiento de métodos de una forma específica.
Esto se hace sin tener que escribir consultas en SQL, lo cual es posible gracias a ciertas convenciones de nomenclatura que
el framework Spring interpreta para generar la consulta adecuada.

¿Query nativos o queryMetods?
Aunque el uso de queryMetods es generalmente preferible por su flexibilidad y mejor práctica, existe la opción de
utilizar consultas nativas a través de anotaciones.

Este enfoque puede ser útil en situaciones donde se requiere mayor control sobre la consulta SQL.

 */