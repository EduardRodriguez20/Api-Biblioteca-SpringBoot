-- Insertar datos en la tabla users
INSERT INTO users (email, pwd) VALUES ('usuario1@example.com', 'passUser1');
INSERT INTO users (email, pwd) VALUES ('usuario2@example.com', 'passUser2');
INSERT INTO users (email, pwd) VALUES ('usuario3@example.com', 'passUser3');
INSERT INTO users (email, pwd) VALUES ('admin@example.com', 'passAdmin');
INSERT INTO users (email, pwd) VALUES ('librarian1@example.com', 'passLibrarian1');
INSERT INTO users (email, pwd) VALUES ('librarian2@example.com', 'passLibrarian2');

--Insertar datos en las tabla de roles
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_USER', 'role user', 1);
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_USER', 'role user', 2);
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_USER', 'role user', 3);
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_ADMIN', 'role admin', 4); 
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_LIBRARIAN', 'role librarian', 5);
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_LIBRARIAN', 'role librarian', 6);


--Insertar datos en la tabla de libros

INSERT INTO libros (titulo, autor, genero, anno, inventario) VALUES ('Cien años de soledad', 'Gabriel García Márquez', 'Realismo mágico', 1967, 10);
INSERT INTO libros (titulo, autor, genero, anno, inventario) VALUES ('1984', 'George Orwell', 'Ciencia ficción', 1949, 8);
INSERT INTO libros (titulo, autor, genero, anno, inventario) VALUES ('El principito', 'Antoine de Saint-Exupéry', 'Literatura infantil', 1943, 12);
INSERT INTO libros (titulo, autor, genero, anno, inventario) VALUES ('Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Fantasía', 1997, 15);
INSERT INTO libros (titulo, autor, genero, anno, inventario) VALUES ('El amor en los tiempos del cólera', 'Gabriel García Márquez', 'Realismo mágico', 1985, 7);

--Insertar datos en la tabla de prestamos

INSERT INTO prestamos (libros_id, users_id, prestamo, devolucion, estado) VALUES (1, 1, '2024-03-22', '2024-04-22', 'APROBADO');
INSERT INTO prestamos (libros_id, users_id, prestamo, devolucion, estado) VALUES (2, 2, '2024-03-23', '2024-04-23', 'SOLICITADO');
INSERT INTO prestamos (libros_id, users_id, prestamo, devolucion, estado) VALUES (3, 3, '2024-03-24', '2024-04-24', 'DEVUELTO');
INSERT INTO prestamos (libros_id, users_id, prestamo, devolucion, estado) VALUES (4, 1, '2024-03-25', '2024-04-25', 'CANCELADO');
INSERT INTO prestamos (libros_id, users_id, prestamo, devolucion, estado) VALUES (5, 2, '2024-03-26', '2024-04-26', 'APROBADO');
