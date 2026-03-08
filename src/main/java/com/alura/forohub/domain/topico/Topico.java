package com.alura.forohub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private String status = "NO_RESPONDIDO";

    private String autor;

    private String curso;

    public Topico(String titulo, String mensaje, String autor, String curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
        this.fechaCreacion = LocalDateTime.now();
        this.status = "NO_RESPONDIDO";
    }

    public void actualizarDatos(DatosActualizarTopico datos) {
        if (datos.titulo() != null && !datos.titulo().isBlank()) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null && !datos.mensaje().isBlank()) {
            this.mensaje = datos.mensaje();
        }
        if (datos.autor() != null && !datos.autor().isBlank()) {
            this.autor = datos.autor();
        }
        if (datos.curso() != null && !datos.curso().isBlank()) {
            this.curso = datos.curso();
        }
        if (datos.status() != null && !datos.status().isBlank()) {
            this.status = datos.status();
        }
    }
}