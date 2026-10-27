package com.empresa.productos.application.port.out;

import com.empresa.productos.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {

    Producto guardar(Producto producto);

    Optional<Producto> buscarPorId(Long id);

    List<Producto> buscarTodos();

    boolean existePorNombre(String nombre);
}
