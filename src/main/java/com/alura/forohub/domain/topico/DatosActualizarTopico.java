package com.alura.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DatosActualizarTopico(

        @Size(min = 5, message = "El título debe tener al menos 5 caracteres")
        String titulo,

        @Size(min = 10, message = "El mensaje debe tener al menos 10 caracteres")
        String mensaje,

        String autor,

        String curso,

        String status
) {}