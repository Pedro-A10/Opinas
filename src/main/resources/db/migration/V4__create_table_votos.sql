CREATE TABLE votos (
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    opcao_id BIGINT NOT NULL,
    CONSTRAINT fk_votos_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_votos_opcao FOREIGN KEY (opcao_id) REFERENCES opcoes(id)
)