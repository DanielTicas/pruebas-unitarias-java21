package com.empresa.productos.application.port.in;

import com.empresa.productos.domain.model.Producto;

import java.util.List;

public interface BuscarProductoUseCase {

    List<Producto> ejecutar();
}
