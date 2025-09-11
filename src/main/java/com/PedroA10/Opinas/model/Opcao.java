package com.PedroA10.Opinas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Opcao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Opcao> opcoes;

    @NotEmpty
    private String texto;

    @ManyToOne
    @JoinColumn(name = "enquete_id")
    private Enquete enquete;
}
