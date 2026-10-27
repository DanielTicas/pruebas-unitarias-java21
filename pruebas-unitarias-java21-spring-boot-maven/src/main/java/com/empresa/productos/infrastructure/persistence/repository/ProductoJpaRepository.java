package com.empresa.productos.infrastructure.persistence.repository;

import com.empresa.productos.infrastructure.persistence.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoJpaRepository extends JpaRepository<ProductoEntity, Long> {

    Optional<ProductoEntity> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
