-- Crear la base de datos
drop database if exists tpv;
create database tpv;

-- Usar la base de datos creada
use tpv;


-- Crear tabla Trabajador
CREATE TABLE Trabajador (
    email VARCHAR(255) PRIMARY KEY,
    nombre VARCHAR(255),
    contrasenia VARCHAR(255),
    telefono INT
);

-- Crear tabla Mesa
 CREATE TABLE Mesa (
    numero int PRIMARY KEY,
    capacidad TINYINT,
    estaOcupada BOOLEAN
);

-- Crear tabla Producto
  CREATE TABLE Producto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20),
    precio FLOAT,
    tipoProducto VARCHAR(30)
);

-- Crear tabla intermedia Mesa_Producto
 CREATE TABLE Mesa_Producto (
	id INT PRIMARY KEY AUTO_INCREMENT,
	numero_mesa int,
    id_producto int,
    foreign key (numero_mesa) references Mesa(numero)
    ON DELETE CASCADE,
    foreign key (id_producto) references Producto(id)
        ON DELETE CASCADE
);


