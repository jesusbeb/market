package com.jbeb.market.persistence;

import com.jbeb.market.domain.Product;
import com.jbeb.market.domain.repository.ProductRepository;
import com.jbeb.market.persistence.crud.ProductoCrudRepository;
import com.jbeb.market.persistence.entity.Producto;
import com.jbeb.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// ProductoRepository lo orientamos al dominio (Product) implementando de ProductRepository
// Inyectamos con la anotacion Autowired para que Spring tome el control de los objetos con su contenedor de Inversion de Control
// Los objetos no han sido inicializados y si no se inyectaran provocarian error de NullPointerException
// Cuando inyectemos hay que estar seguros de que el componente a inyectar ya es parte del ambiente de Spring
@Repository
public class ProductoRepository implements ProductRepository{
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
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
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

}





/*
¿Qué es la inyección de dependencias y por qué es importante?
La inyección de dependencias es un principio clave en el desarrollo de software moderno que busca desacoplar las
clases de las implementaciones que utilizan, promoviendo así el principio de inversión de control. Al pasar las
dependencias a la clase en vez de crearlas internamente, se reduce el acoplamiento y se incrementa la flexibilidad y
facilidad de mantenimiento del código.

¿Cómo implementa Spring la inyección de dependencias?
Spring, un marco de trabajo popular para el desarrollo de aplicaciones en Java, implementa la inyección de
dependencias utilizando su contenedor de inversión de control. Este contenedor toma el control de la creación y
gestión de instancias de los objetos necesarios para el funcionamiento de la aplicación.

Autowire en Spring: Spring facilita la inyección de dependencias mediante la anotación @Autowired. Al usar esta
anotación, se indica que el control de la creación de instancias será delegado al contenedor de Spring. Esto hace
transparente el proceso de inyección de dependencias para el desarrollador, quien no tendrá que preocuparse por la
creación manual de objetos.

¿Por qué es crucial utilizar correctamente los componentes de Spring?
Un aspecto esencial al inyectar dependencias en Spring es asegurarse de que las clases o atributos que se desean
inyectar sean componentes reconocidos por el framework. En otras palabras, deben ser beans de Spring.

Ejemplo de uso: Consideremos un repositorio que extiende de CrudRepository. Al extenderlo, automáticamente se marca como
un componente de Spring, permitiendo así ser inyectado. Del mismo modo, si se utiliza una clase decorada con
anotaciones específicas de otra biblioteca, como MapStruct, es importante verificar que el componente o su modelo sea
compatible para ser gestionado por Spring.

¿Cómo ayuda este enfoque a mejorar el desarrollo?
La inyección de dependencias automatizada elimina la necesidad de crear objetos manualmente, lo que puede ser propenso a
errores y difícil de mantener. Al confiar en el framework de Spring para gestionar estas instancias, los
desarrolladores pueden concentrarse en la lógica de negocio de sus aplicaciones, asegurando un código más limpio y eficiente.

Ejemplos prácticos y recomendaciones
Veamos un ejemplo de cómo se evita el error común del "null pointer exception" en Java gracias a la inyección de dependencias de Spring:

@Autowired
private ProductoRepository productoRepository;

@Autowired
private ProductoMapper productoMapper;

Recomendaciones para el uso efectivo
- Verificar componentes: Asegúrate de que las clases a inyectar son parte del ecosistema de Spring para evitar problemas.
- Utilizar anotaciones adecuadas: Aprovecha las anotaciones que ofrece Spring, como @Component, @Service, @Repository,
para que el contenedor pueda identificar y gestionar tus beans.
- Evitar el acoplamiento excesivo: La inyección de dependencias promueve la creación de un código modular y más fácil de
mantener, crucial para proyectos de gran escala.

Este principio no solo fomenta prácticas de codificación limpias, sino que también ofrece beneficios tangibles en la
gestión y escalabilidad del software. Usar la inyección de dependencias de manera eficiente es clave para el desarrollo ágil y sostenible
 */