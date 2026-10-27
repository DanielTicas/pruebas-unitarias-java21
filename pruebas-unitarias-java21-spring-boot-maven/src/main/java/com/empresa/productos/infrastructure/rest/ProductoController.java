package com.empresa.productos.infrastructure.rest;

import com.empresa.productos.application.port.in.BuscarProductoUseCase;
import com.empresa.productos.application.port.in.CrearProductoUseCase;
import com.empresa.productos.domain.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final CrearProductoUseCase crearProductoUseCase;
    private final BuscarProductoUseCase buscarProductoUseCase;

    public ProductoController(CrearProductoUseCase crearProductoUseCase,
                              BuscarProductoUseCase buscarProductoUseCase) {
        this.crearProductoUseCase = crearProductoUseCase;
        this.buscarProductoUseCase = buscarProductoUseCase;
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto creado = crearProductoUseCase.ejecutar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(buscarProductoUseCase.ejecutar());
    }
}
