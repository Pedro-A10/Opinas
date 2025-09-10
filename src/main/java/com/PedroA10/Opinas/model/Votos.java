package com.PedroA10.Opinas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Votos extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comentario;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Opcao opcao;
}

