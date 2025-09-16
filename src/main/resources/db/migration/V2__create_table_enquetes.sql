CREATE TABLE enquetes (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensagem TEXT NOT NULL,
    comentarios TEXT,
    usuario_id BIGINT NOT NULL,
    CONSTRAINT fk_enquetes_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);