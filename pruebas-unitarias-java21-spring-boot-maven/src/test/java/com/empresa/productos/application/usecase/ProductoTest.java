package com.empresa.productos.domain.model;

import com.empresa.productos.domain.exception.ProductoInvalidoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductoTest {

    @Test
    @DisplayName("Debe crear un producto válido")
    void deberiaCrearProductoValido() {
        Producto producto = new Producto(1L, "Monitor", new BigDecimal("1500.00"));

        assertNotNull(producto);
        assertEquals(1L, producto.getId());
        assertEquals("Monitor", producto.getNombre());
        assertEquals(new BigDecimal("1500.00"), producto.getPrecio());
    }

    @Test
    @DisplayName("No debe permitir un nombre vacío")
    void noDeberiaPermitirNombreVacio() {
        assertThrows(
                ProductoInvalidoException.class,
                () -> new Producto(null, "  ", new BigDecimal("100.00"))
        );
    }

    @Test
    @DisplayName("No debe permitir un precio negativo")
    void noDeberiaPermitirPrecioNegativo() {
        assertThrows(
                ProductoInvalidoException.class,
                () -> new Producto(null, "Monitor", new BigDecimal("-10.00"))
        );
    }
}
