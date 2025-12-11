package com.jbeb.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

// @Embeddable porque esta clase se va a embeder dentro de la clase ComprasProducto
// Esta clase no lleva @Entity ya que no mapea ninguna tabla de la BD
@Embeddable
public class ComprasProductoPK implements Serializable {

    // Atributos

    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;

    // Getters & Setters

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

}