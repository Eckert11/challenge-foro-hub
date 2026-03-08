package com.alura.forohub.controller;

import com.alura.forohub.domain.topico.*;
import com.alura.forohub.infra.exception.TopicoNoEncontradoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(
            @RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {

        var respuesta = topicoService.registrarTopico(datosRegistroTopico);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    // ============================================
    // NUEVOS MÉTODOS PARA LISTADO
    // ============================================

    // 1. LISTADO SIMPLE - Todos los tópicos
    @GetMapping
    public ResponseEntity<List<DatosListadoTopico>> listarTopicos() {
        var topicos = topicoRepository.findAll()
                .stream()
                .map(DatosListadoTopico::new)
                .toList();
        return ResponseEntity.ok(topicos);
    }

    // 2. LISTADO CON PAGINACIÓN - Primeros 10 ordenados por fecha ASC
    @GetMapping("/paginado")
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicosPaginados(
            @PageableDefault(size = 10, sort = "fechaCreacion") Pageable paginacion) {
        var page = topicoRepository.findAll(paginacion)
                .map(DatosListadoTopico::new);
        return ResponseEntity.ok(page);
    }

    // 3. LISTADO POR CURSO Y AÑO - Filtrado
    @GetMapping("/buscar")
    public ResponseEntity<List<DatosListadoTopico>> listarPorCursoYAño(
            @RequestParam(required = false) String curso,
            @RequestParam(required = false) Integer año) {

        List<Topico> topicos;

        if (curso != null && año != null) {
            topicos = topicoRepository.findByCursoAndAño(curso, año);
        } else if (curso != null) {
            topicos = topicoRepository.findByCurso(curso);
        } else if (año != null) {
            topicos = topicoRepository.findByAño(año);
        } else {
            topicos = topicoRepository.findAll();
        }

        var datosListado = topicos.stream()
                .map(DatosListadoTopico::new)
                .toList();

        return ResponseEntity.ok(datosListado);
    }

    // 4. LISTADO DE UN SOLO TÓPICO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopico> listarTopicoPorId(@PathVariable Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new TopicoNoEncontradoException("Tópico no encontrado con ID: " + id));

        return ResponseEntity.ok(new DatosListadoTopico(topico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {

        var respuesta = topicoService.actualizarTopico(id, datosActualizarTopico);
        return ResponseEntity.ok(respuesta);
    }

    // ============================================
// ELIMINAR TÓPICO
// ============================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {

        topicoService.eliminarTopico(id);

        return ResponseEntity.noContent().build(); // 204 No Content
    }
}