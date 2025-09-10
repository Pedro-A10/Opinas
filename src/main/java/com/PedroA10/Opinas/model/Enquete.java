package com.PedroA10.Opinas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Enquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 100)
    private String titulo;

    @NotEmpty
    @Size(max = 1000)
    private String mensagem;

    @Size(max = 1000)
    private String comentarios;

    @ManyToOne
    private Usuario usuario;

    @NotEmpty
    @OneToMany(mappedBy = "enquete", cascade = CascadeType.ALL)
    private List<Opcao> opcoes = new ArrayList<>();

}
