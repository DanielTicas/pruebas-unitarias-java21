package com.empresa.productos.application.usecase;

import com.empresa.productos.application.port.in.BuscarProductoUseCase;
import com.empresa.productos.application.port.out.ProductoRepositoryPort;
import com.empresa.productos.domain.model.Producto;

import java.util.List;

public class BuscarProductoService implements BuscarProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public BuscarProductoService(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public List<Producto> ejecutar() {
        return productoRepositoryPort.buscarTodos();
    }
}
