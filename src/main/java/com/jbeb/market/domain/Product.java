package com.jbeb.market.domain;

// No incluimos el atributo barcode (codigoBarras) que si esta en Producto
public class Product {
    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private Category category;

    // Getters & Setters

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}



/*
¿Qué es el patrón DataMapper y cómo se aplica?
El patrón DataMapper es un concepto fundamental en el desarrollo de software, especialmente en aplicaciones que
siguen el enfoque de dominio. Este patrón se encarga de traducir o convertir entre dos objetos que
realizan funciones similares. Por ejemplo, podríamos tener un objeto Producto y un objeto Product, donde sus
atributos se traducen entre sí para cumplir roles equivalentes en diferentes contextos.

Beneficios del DataMapper
Implementar el patrón DataMapper ofrece varias ventajas:

- Protección de la base de datos: No expone directamente el diseño de las tablas al API, protegiendo así la arquitectura interna.
- Desacoplamiento de la API: Facilita el cambio de bases de datos sin modificar todo el código, simplemente ajustando el traductor.
- Evita campos innecesarios: Permite omitir atributos que no son relevantes en la API, solo mantienen su utilidad dentro del contexto de la persistencia.
- Homogeneidad del idioma: Permite mantener un único idioma en el dominio de la aplicación, evitando mezclar idiomas en el código fuente.


 */