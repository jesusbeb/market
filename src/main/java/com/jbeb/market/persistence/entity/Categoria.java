package com.jbeb.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;

    private boolean estado;

    // UNA categoria puede tener MUCHOS productos ( List<Producto> )
    // La relacion esta mapeada por el atributo categoria que esta dentro de Producto
    // mappedBy indique que esta clase NO es la dueña de la relacion.
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
}
