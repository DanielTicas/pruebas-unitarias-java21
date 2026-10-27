package com.empresa.productos.application.port.in;

import com.empresa.productos.domain.model.Producto;

public interface CrearProductoUseCase {

    Producto ejecutar(Producto producto);
}
