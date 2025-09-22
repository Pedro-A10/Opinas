package com.PedroA10.Opinas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Option> options;

    @NotEmpty
    private String text;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;
}
