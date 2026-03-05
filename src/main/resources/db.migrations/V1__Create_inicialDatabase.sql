CREATE TABLE IF NOT EXISTS `tb_grupo_muscular` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `nome` varchar(100) DEFAULT NULL,
   PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `tb_exercicio` (
`id` bigint NOT NULL AUTO_INCREMENT,
`nome` varchar(100) DEFAULT NULL,
`video` varchar(255) DEFAULT NULL,
`descricao` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `tb_treino` (
`id` bigint NOT NULL AUTO_INCREMENT,
`grupo_muscular_id` bigint DEFAULT NULL,
`tipo` varchar(45) DEFAULT NULL,
`oberservacoes` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_treino_grupo_muscular` FOREIGN KEY (`grupo_muscular_id`) REFERENCES `tb_grupo_muscular`(`id`)
);

CREATE TABLE IF NOT EXISTS `tb_usuario` (
`id` bigint NOT NULL AUTO_INCREMENT,
`email` varchar(255) DEFAULT NULL,
`nome` varchar(255) DEFAULT NULL,
`treino_id` bigint DEFAULT NULL,
`senha` varchar(256) DEFAULT NULL,
`endereco` varchar(256) DEFAULT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_usuario_treino` FOREIGN KEY (`treino_id`) REFERENCES `tb_treino`(`id`)
);

CREATE TABLE IF NOT EXISTS `tb_treino_exercicio` (
     `treino_id` bigint NOT NULL,
     `exercicio_id` bigint NOT NULL,
     PRIMARY KEY (`treino_id`, `exercicio_id`),
     CONSTRAINT `fk_te_treino` FOREIGN KEY (`treino_id`) REFERENCES `tb_treino`(`id`),
     CONSTRAINT `fk_te_exercicio` FOREIGN KEY (`exercicio_id`) REFERENCES `tb_exercicio`(`id`)
);