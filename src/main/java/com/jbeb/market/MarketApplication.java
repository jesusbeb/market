package com.jbeb.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

}



/*
¿Cómo estructurar arquitectónicamente una aplicación?
La estructura arquitectónica de una aplicación es fundamental para su correcto funcionamiento y mantenimiento a largo
plazo. Una organización clara y bien definida facilita los procesos de desarrollo, depuración y actualización de la
aplicación. Aquí usaremos una arquitectura por capas orientada al dominio.

¿Qué es la capa de dominio?
La capa de dominio es el núcleo de la aplicación. En esta capa, encontramos los objetos de dominio y los
DTO (Data Transfer Objects). Los objetos de dominio son representaciones abstractas de elementos dentro del contexto de
la aplicación. En el caso de un supermercado, por ejemplo, podríamos tener productos, categorías, clientes, entre otros.

Además, en la capa de dominio, se definen los servicios que actúan como puentes entre los controladores de la API y la
capa de persistencia. Finalmente, encontraremos las especificaciones de los repositorios, que son interfaces definiendo
los contratos que la capa de persistencia debe cumplir.

¿Qué roles juegan la capa web y la capa de persistencia?
La capa web es donde se sitúan los controladores de la API. Estos controladores gestionan las solicitudes y respuestas de
los clientes y actúan como la entrada al sistema.

Por su parte, la capa de persistencia interactúa directamente con la base de datos. Incluye los repositorios que
implementan las especificaciones del dominio y las entidades, que actúan como mapeos entre las clases y las tablas de la base de datos.

¿Cómo fluye la información en esta arquitectura?
 Un cliente hace una solicitud a través de un controlador en la API.
 El controlador se comunica con los servicios en la capa de dominio para procesar la lógica de negocio.
 Los servicios contactan a los repositorios en la capa de persistencia para manejar operaciones de la base de datos.
 Finalmente, los datos son recuperados, transformados en entidades, y enviados de vuelta al cliente a través de la API.
Este flujo permite un desarrollo modular y escalable, facilitando el mantenimiento y crecimiento del proyecto. Así, no
solo optimizas la arquitectura interna, sino que también garantizas un desempeño eficiente a largo plazo.

Este tipo de organización estructural beneficia tanto a desarrolladores como a usuarios, permitiendo un código claro y
fácilmente extensible.
 */