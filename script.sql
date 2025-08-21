CREATE DATABASE codando_ideias;

DROP TABLE IF EXISTS post;

CREATE TABLE post (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    author VARCHAR(20),
    creation_date TIMESTAMP DEFAULT now(),
    update_date TIMESTAMP DEFAULT now(),
    title VARCHAR(50),
    post_content TEXT,
    key_word VARCHAR(20)
);

INSERT INTO post (author, title, post_content, key_word) VALUES
('Paulo', 'Primeiro Post', 'Conteúdo do primeiro post de teste.', 'teste'),
('Maria', 'Dicas de SQL', 'Explicando como usar SELECT e JOIN no PostgreSQL.', 'sql'),
('João', 'Quarkus Rocks', 'Explorando o framework Quarkus para microsserviços.', 'java'),
('Ana', 'Machine Learning', 'Introdução a modelos supervisionados e não supervisionados.', 'ia'),
('Lucas', 'Docker Básico', 'Passo a passo para criar containers com Docker.', 'devops'),
('Fernanda', 'Kotlin x Java', 'Comparando recursos do Kotlin e do Java.', 'kotlin'),
('Rafael', 'API REST', 'Como estruturar uma API RESTful de forma eficiente.', 'api'),
('Carla', 'Frontend Moderno', 'React, Next.js e Tailwind para interfaces modernas.', 'frontend'),
('Bruno', 'Linux Essentials', 'Comandos essenciais para iniciantes no Linux.', 'linux'),
('Sofia', 'Banco de Dados', 'Boas práticas de modelagem relacional no PostgreSQL.', 'database');

SELECT * FROM post;

COMMIT;
