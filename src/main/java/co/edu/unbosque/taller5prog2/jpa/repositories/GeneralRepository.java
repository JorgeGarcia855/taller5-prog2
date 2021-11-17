package co.edu.unbosque.taller5prog2.jpa.repositories;

import java.util.Optional;

/**
 * La interfaz principal de los repositorios de cada entidad.
 * Contiene los metodos necesarios para poder guardar y actualizar
 * las tablas en la base de datos
 * @param <T> La entidad para hacer operaciones
 * @param <K> El tipo de identificacion
 */
public interface GeneralRepository<T, K> {
    Optional<T> findById(K id);
    Optional<T> save(T t);
    Optional<T> update(T t, K id);
}
