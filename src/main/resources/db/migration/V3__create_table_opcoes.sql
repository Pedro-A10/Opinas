CREATE TABLE opcoes (
    id BIGSERIAL PRIMARY KEY,
    texto VARCHAR(255) NOT NULL,
    enquete_id BIGINT NOT NULL,
    CONSTRAINT fk_opcoes_enquete FOREIGN KEY (enquete_id) REFERENCES enquetes(id)
);