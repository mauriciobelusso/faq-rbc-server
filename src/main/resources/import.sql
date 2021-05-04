INSERT INTO permissao (permissao) values('ROLE_USER');
INSERT INTO permissao (permissao) values('ROLE_ADMIN');

INSERT INTO usuario(nome, username, password) VALUES ('Administrador', 'admin','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO usuario(nome, username, password) VALUES ('Teste', 'teste','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');

INSERT INTO usuario_permissoes(Usuario_id, Permissoes_id) VALUES (1, 1);
INSERT INTO usuario_permissoes(Usuario_id, Permissoes_id) VALUES (1, 2);
INSERT INTO usuario_permissoes(Usuario_id, Permissoes_id) VALUES (2, 2);
