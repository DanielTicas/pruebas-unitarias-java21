package com.empresa.productos.infrastructure.persistence.adapter;

import com.empresa.productos.domain.model.Producto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(ProductoRepositoryAdapter.class)
class ProductoRepositoryAdapterIT {

    @Autowired
    private ProductoRepositoryAdapter productoRepositoryAdapter;

    @Test
    @DisplayName("Debe guardar y recuperar un producto usando JPA")
    void deberiaGuardarYRecuperarProducto() {
        Producto producto = new Producto(null, "Laptop", new BigDecimal("18500.00"));

        Producto guardado = productoRepositoryAdapter.guardar(producto);

        assertNotNull(guardado.getId());
        assertEquals("Laptop", guardado.getNombre());

        List<Producto> productos = productoRepositoryAdapter.buscarTodos();

        assertFalse(productos.isEmpty());
        assertTrue(productoRepositoryAdapter.existePorNombre("Laptop"));
    }
}
