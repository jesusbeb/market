package com.jbeb.market.persistence.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// La llave primaria de la tabla en la BD, que representa este Entity esta compuesta por dos columnas: id_compra y id_producto
// para esto se crea otra clase (ComprasProductoPK) que contenga esas dos columnas y despues se agrega a esta clase
// @EmbeddedId para cuando la clave primaria es compuesta y esta dada por otra clase
@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    @EmbeddedId
    private ComprasProductoPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

    // Getters & Setters

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
