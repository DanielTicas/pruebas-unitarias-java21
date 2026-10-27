package com.empresa.productos.infrastructure.persistence.adapter;

import com.empresa.productos.application.port.out.ProductoRepositoryPort;
import com.empresa.productos.domain.model.Producto;
import com.empresa.productos.infrastructure.persistence.entity.ProductoEntity;
import com.empresa.productos.infrastructure.persistence.repository.ProductoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {

    private final ProductoJpaRepository productoJpaRepository;

    public ProductoRepositoryAdapter(ProductoJpaRepository productoJpaRepository) {
        this.productoJpaRepository = productoJpaRepository;
    }

    @Override
    public Producto guardar(Producto producto) {
        ProductoEntity entity = new ProductoEntity(
                producto.getNombre(),
                producto.getPrecio()
        );

        ProductoEntity guardado = productoJpaRepository.save(entity);

        return new Producto(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getPrecio()
        );
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) {
        return productoJpaRepository.findById(id)
                .map(entity -> new Producto(
                        entity.getId(),
                        entity.getNombre(),
                        entity.getPrecio()
                ));
    }

    @Override
    public List<Producto> buscarTodos() {
        return productoJpaRepository.findAll()
                .stream()
                .map(entity -> new Producto(
                        entity.getId(),
                        entity.getNombre(),
                        entity.getPrecio()
                ))
                .toList();
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return productoJpaRepository.existsByNombre(nombre);
    }
}
