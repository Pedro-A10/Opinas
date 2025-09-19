package com.PedroA10.Opinas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Votos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "opcao_id")
    private Opcao opcao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

