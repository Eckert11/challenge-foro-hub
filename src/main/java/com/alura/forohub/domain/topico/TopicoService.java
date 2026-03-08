package com.alura.forohub.domain.topico;

import com.alura.forohub.infra.exception.TopicoNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    // ============================================
    // REGISTRAR NUEVO TÓPICO
    // ============================================
    @Transactional
    public DatosRespuestaTopico registrarTopico(DatosRegistroTopico datos) {

        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new ValidacionException("Ya existe un tópico con el mismo título y mensaje");
        }

        var topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                datos.autor(),
                datos.curso()
        );

        topicoRepository.save(topico);

        return new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getFechaCreacion(),
                topico.getStatus()
        );
    }

    // ============================================
    // ACTUALIZAR TÓPICO
    // ============================================
    @Transactional
    public DatosRespuestaTopico actualizarTopico(Long id, DatosActualizarTopico datos) {

        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new TopicoNoEncontradoException("Tópico no encontrado con ID: " + id));

        if (datos.titulo() != null && datos.mensaje() != null) {
            boolean existeDuplicado = topicoRepository.existsByTituloAndMensaje(
                    datos.titulo(),
                    datos.mensaje()
            );

            if (existeDuplicado) {
                var topicoExistente = topicoRepository.findByTitulo(datos.titulo());
                if (topicoExistente.isPresent() && !topicoExistente.get().getId().equals(id)) {
                    throw new ValidacionException("Ya existe otro tópico con el mismo título y mensaje");
                }
            }
        }

        topico.actualizarDatos(datos);

        return new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getFechaCreacion(),
                topico.getStatus()
        );
    }

    // ============================================
    // ELIMINAR TÓPICO (NUEVO)
    // ============================================
    @Transactional
    public void eliminarTopico(Long id) {

        // Verificar si el tópico existe
        if (!topicoRepository.existsById(id)) {
            throw new TopicoNoEncontradoException("Tópico no encontrado con ID: " + id);
        }

        // Eliminar el tópico
        topicoRepository.deleteById(id);
    }

    // ============================================
    // EXCEPCIÓN INTERNA PARA VALIDACIONES
    // ============================================
    public static class ValidacionException extends RuntimeException {
        public ValidacionException(String message) {
            super(message);
        }
    }
}