package com.alura.forohub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Optional<Topico> findByTitulo(String titulo);

    // ============================================
    // NUEVOS MÉTODOS PARA BÚSQUEDA
    // ============================================

    // Buscar por curso
    List<Topico> findByCurso(String curso);

    // Buscar por año (usando JPQL)
    @Query("SELECT t FROM Topico t WHERE YEAR(t.fechaCreacion) = :año")
    List<Topico> findByAño(@Param("año") int año);

    // Buscar por curso y año
    @Query("SELECT t FROM Topico t WHERE t.curso = :curso AND YEAR(t.fechaCreacion) = :año")
    List<Topico> findByCursoAndAño(@Param("curso") String curso, @Param("año") int año);

    // Los primeros 10 ordenados por fecha (ya lo hacemos con Pageable)
}