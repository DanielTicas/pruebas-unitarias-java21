package com.empresa.productos.application.usecase;

import com.empresa.productos.application.port.out.ProductoRepositoryPort;
import com.empresa.productos.domain.exception.ProductoDuplicadoException;
import com.empresa.productos.domain.model.Producto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearProductoServiceTest {

    @Mock
    private ProductoRepositoryPort productoRepositoryPort;

    @InjectMocks
    private CrearProductoService crearProductoService;

    @Test
    @DisplayName("Debe crear un producto cuando el nombre no existe")
    void deberiaCrearProductoCuandoNoExiste() {
        Producto entrada = new Producto(null, "Teclado", new BigDecimal("250.00"));
        Producto guardado = new Producto(1L, "Teclado", new BigDecimal("250.00"));

        when(productoRepositoryPort.existePorNombre("Teclado")).thenReturn(false);
        when(productoRepositoryPort.guardar(any(Producto.class))).thenReturn(guardado);

        Producto resultado = crearProductoService.ejecutar(entrada);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Teclado", resultado.getNombre());
        assertEquals(new BigDecimal("250.00"), resultado.getPrecio());

        verify(productoRepositoryPort).existePorNombre("Teclado");
        verify(productoRepositoryPort).guardar(entrada);
    }

    @Test
    @DisplayName("Debe lanzar excepción cuando ya existe un producto con el mismo nombre")
    void deberiaLanzarExcepcionCuandoElProductoYaExiste() {
        Producto entrada = new Producto(null, "Mouse", new BigDecimal("120.00"));

        when(productoRepositoryPort.existePorNombre("Mouse")).thenReturn(true);

        assertThrows(
                ProductoDuplicadoException.class,
                () -> crearProductoService.ejecutar(entrada)
        );

        verify(productoRepositoryPort, never()).guardar(any(Producto.class));
    }
}
