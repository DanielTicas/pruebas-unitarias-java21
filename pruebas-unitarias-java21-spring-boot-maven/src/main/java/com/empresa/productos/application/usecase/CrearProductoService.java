package com.empresa.productos.application.usecase;

import com.empresa.productos.application.port.in.CrearProductoUseCase;
import com.empresa.productos.application.port.out.ProductoRepositoryPort;
import com.empresa.productos.domain.exception.ProductoDuplicadoException;
import com.empresa.productos.domain.model.Producto;

public class CrearProductoService implements CrearProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public CrearProductoService(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto ejecutar(Producto producto) {
        boolean existe = productoRepositoryPort.existePorNombre(producto.getNombre());

        if (existe) {
            throw new ProductoDuplicadoException(
                    "Ya existe un producto con el nombre: " + producto.getNombre()
            );
        }

        return productoRepositoryPort.guardar(producto);
    }
}
