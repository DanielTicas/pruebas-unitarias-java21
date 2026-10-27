# Pruebas Unitarias con Java 21, JPA y Spring Boot

Proyecto Maven listo para abrir en IntelliJ IDEA.

## Requisitos

- JDK 21
- Maven 3.9+ o usar el Maven incluido en IntelliJ IDEA
- MySQL 8 opcional para ejecutar la aplicación
- H2 se usa para pruebas de integración

## Abrir en IntelliJ IDEA

1. Descomprime el archivo ZIP.
2. Abre IntelliJ IDEA.
3. Selecciona **File > Open**.
4. Abre la carpeta `pruebas-unitarias-java21-spring-boot-maven`.
5. Espera a que Maven descargue dependencias.
6. Verifica que el Project SDK sea Java 21 en **File > Project Structure**.

## Ejecutar pruebas unitarias

Desde IntelliJ:

- Abrir `CrearProductoServiceTest`
- Clic derecho sobre la clase
- Seleccionar **Run 'CrearProductoServiceTest'**

Desde terminal:

```bash
mvn test
```

## Ejecutar solo pruebas unitarias

```bash
mvn test -Dtest=CrearProductoServiceTest
```

## Ejecutar prueba de dominio

```bash
mvn test -Dtest=ProductoTest
```

## Ejecutar prueba de integración JPA

```bash
mvn test -Dtest=ProductoRepositoryAdapterIT
```

## Ejecutar la aplicación

Configura MySQL y crea la base de datos:

```sql
CREATE DATABASE productos_db;
```

Luego ejecuta:

```bash
mvn spring-boot:run
```

## Documentación oficial

- JUnit 5: https://docs.junit.org/current/user-guide/
- Spring Boot Testing: https://docs.spring.io/spring-boot/reference/testing/index.html
- Spring Data JPA: https://docs.spring.io/spring-data/jpa/reference/
