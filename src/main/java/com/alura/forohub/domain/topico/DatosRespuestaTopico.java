package com.alura.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso,
        LocalDateTime fechaCreacion,
        String status
) {}