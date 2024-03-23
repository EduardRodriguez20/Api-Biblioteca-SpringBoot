-- Insertar datos en la tabla users
INSERT INTO users (email, pwd) VALUES ('account@debuggeandoieas.com', 'to_be_encoded');
INSERT INTO users (email, pwd) VALUES ('cards@debuggeandoieas.com', 'to_be_encoded');
INSERT INTO users (email, pwd) VALUES ('loans@debuggeandoieas.com', 'to_be_encoded');
INSERT INTO users (email, pwd) VALUES ('balance@debuggeandoieas.com', 'to_be_encoded');

--Insertar datos en las tabla de roles
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_ADMIN', 'cant view account endpoint', 1);      
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_ADMIN', 'cant view cards endpoint', 2); 
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_USER', 'cant view account endpoint', 3); 
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_USER', 'cant view account endpoint', 4); 