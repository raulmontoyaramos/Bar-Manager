-- En MySQLWorkbench, no es posible almacenar directamente un ArrayList en una tabla de base de datos, 
-- ya que los tipos de datos admitidos en MySQL son limitados y no incluyen un tipo de datos 
-- específico para representar una colección como un ArrayList.

-- Sin embargo, puedes utilizar otras estrategias para almacenar la información contenida en un 
-- ArrayList en una tabla de base de datos. Algunas opciones comunes incluyen:

-- 1.- Convertir el ArrayList a una representación de cadena: Puedes convertir los elementos del 
-- ArrayList a una cadena de texto, por ejemplo, utilizando un delimitador específico para separar 
-- los elementos. Luego, puedes almacenar esa cadena en una columna de tipo VARCHAR o TEXT en la tabla de base de datos.

-- 2.- Crear una tabla adicional para los elementos del ArrayList: Puedes crear una tabla separada que 
-- contenga los elementos individuales del ArrayList y establecer una relación con la tabla principal utilizando claves foráneas.
-- Por ejemplo, supongamos que tienes una clase Persona con atributos como nombre, edad y correo 
-- electrónico, y quieres almacenar una lista de personas en una tabla de base de datos. Podrías 
-- hacer lo siguiente:

-- Crear una tabla principal para almacenar información general de las personas, como nombre, edad y correo electrónico.
-- Crear una tabla adicional que represente los elementos individuales de la lista de personas, 
-- con columnas para cada atributo de la clase Persona (por ejemplo, nombre, edad y correo electrónico).
-- Establecer una relación entre las dos tablas utilizando una clave foránea en la tabla adicional 
-- que haga referencia a la tabla principal.
-- De esta manera, puedes almacenar cada persona individual en la tabla adicional y mantener una 
-- relación con la tabla principal.

-- Recuerda que estas son solo algunas estrategias para manejar la persistencia de datos contenidos 
-- en un ArrayList en una base de datos relacional como MySQL. La elección de la estrategia 
-- dependerá de los requerimientos y la estructura de tus datos.


-- Crear la base de datos
drop database if exists tpv;
create database tpv;

-- Usar la base de datos creada
use tpv;

-- drop table Trabajador;
-- Crear tabla Trabajador
CREATE TABLE Trabajador (
    email VARCHAR(255) PRIMARY KEY,
    nombre VARCHAR(255),
    contrasenia VARCHAR(255),
    telefono INT
);

insert into Trabajador (email, nombre, contrasenia, telefono)
VALUES ('p@', 'p', 'abc', 9527842), ('p2', 'pepe', 'vgmkosfjs', 98868);


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

insert into Mesa (numero, capacidad, estaOcupada)
VALUES (1, 4, true), (2, 2, true);
insert into Mesa (numero, capacidad, estaOcupada)
VALUES (3, 4, true);

insert into Producto (nombre, precio, tipoProducto)
VALUES ('p', 4, 'BEBIDA'), ('p2', 5, 'BEBIDA'), ('p3', 6, 'PRIMER_PLATO');

SELECT 
    mp.id, p.id, p.nombre, p.precio, p.tipoProducto
FROM
    Mesa_Producto mp
        INNER JOIN
    Producto p ON mp.numero_mesa = 2
GROUP BY mp.id;
    
    SELECT @@sql_mode;
    -- 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION'

    
    SELECT 
    mp.numero_mesa, mp.id, mp.id_producto, p.id, p.nombre, p.precio, p.tipoProducto
FROM
    Mesa_Producto mp
        INNER JOIN
    Producto p ON mp.numero_mesa = 2 AND p.nombre = 'w';
    
    SELECT 
    p.id, p.nombre, p.precio, p.tipoProducto
FROM
    Mesa_Producto mp
        INNER JOIN
    Producto p 

