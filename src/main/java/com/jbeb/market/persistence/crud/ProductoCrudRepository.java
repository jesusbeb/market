package com.jbeb.market.persistence.crud;

import com.jbeb.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

// Interface que extiende de CrudRepository para consultas de Producto en la BD
// <Tabla, tipo de dato de clave primaria>
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{
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