package com.empresa.productos.domain.model;

import com.empresa.productos.domain.exception.ProductoInvalidoException;

import java.math.BigDecimal;
import java.util.Objects;

public class Producto {

    private final Long id;
    private final String nombre;
    private final BigDecimal precio;

    public Producto(Long id, String nombre, BigDecimal precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new ProductoInvalidoException("El nombre del producto es obligatorio");
        }

        if (precio == null || precio.signum() < 0) {
            throw new ProductoInvalidoException("El precio del producto no puede ser negativo");
        }

        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(id, producto.id)
                && Objects.equals(nombre, producto.nombre)
                && Objects.equals(precio, producto.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio);
    }
}
