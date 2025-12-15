package com.jbeb.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    // @Id para indicar que es la clave primaria
    // @GeneratedValue generara automaticamente el incremento del id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private boolean estado;

    // MUCHOS productos pueden existir en UNA categoria. Pero un producto solo puede tener una categoria
    // La anotacion se coloca desde la perspectiva de la clase donde esta declarada
    // No podria ser OneToOne porque signifcaria que un producto pertenece a una categoria y esa categoria pertenece unicamente a ese producto
    // @JoinColumn para especificar el nombre del atributo que sirve como llave foranea hacia Categoria
    // A traves de este atributo no se puede insertar ni actualizar una categoria, sirve solo para
    // saber a que categoria pertenece un producto
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;


    // Getters & Setters

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
