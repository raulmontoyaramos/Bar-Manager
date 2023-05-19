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

-- Crear tabla Negocio
CREATE TABLE Negocio (
    CIF VARCHAR(255) PRIMARY KEY,
    comidas VARCHAR(255),
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    telefono INT,
    email VARCHAR(255)
);

-- Crear tabla Trabajador
CREATE TABLE Trabajador (
    email VARCHAR(255) PRIMARY KEY,
    nombre VARCHAR(255),
    contraseña VARCHAR(255),
    telefono INT,
    FOREIGN KEY (email)
        REFERENCES Negocio (CIF)
);

-- Crear tabla Gerente
-- create table Gerente (
--    id int primary key,
--     foreign key (id) references Trabajador(email)
-- );


CREATE TABLE Trabajador_Negocio (
    email_trabajador VARCHAR(255),
    CIF_negocio VARCHAR(255),
    PRIMARY KEY (email_trabajador , CIF_negocio),
    FOREIGN KEY (email_trabajador)
        REFERENCES Trabajador (email),
    FOREIGN KEY (CIF_negocio)
        REFERENCES Negocio (CIF)
);
-- Crear tabla MenuDelDia
-- create table MenuDelDia (
--     id int primary key auto_increment,
--     foreign key (id) references Negocio(CIF)
-- );

-- Crear tabla Menu
-- create table Menu (
--     id int primary key auto_increment,
--     foreign key (id) references Negocio(CIF),
--     foreign key (id) references MenuDelDia(id)
-- );

-- Crear tabla Mesa
-- create table Mesa (
--     numero smallint primary key,
--     capacidad tinyint,
--     estáOcupada boolean,
--     id_negocio int,
--     foreign key (id_negocio) references Negocio(id)
-- );

-- Crear tabla Producto
-- create table Producto (
-- 	id int primary key auto_increment,
--     nombre varchar(255),
--     precio float,
--     esFrio boolean
-- );

-- Crear tabla Entrante
-- create table Entrante (
--     id int primary key auto_increment,
--     esVegetariano boolean,
--     esVegano boolean,
--     tieneGluten boolean,
--     tieneLactosa boolean,
--     foreign key (id) references Producto(id)
-- );

-- Crear tabla PrimerPlato
-- create table PrimerPlato (
--     id int primary key auto_increment,
--     esVegetariano boolean,
--     esVegano boolean,
--     tieneGluten boolean,
--     tieneLactosa boolean,
-- 	foreign key (id) references Producto(id)
-- );

-- Crear tabla SegundoPlato
-- create table SegundoPlato (
--     id int primary key auto_increment,
--     esVegetariano boolean,
--     esVegano boolean,
--     tieneGluten boolean,
--     tieneLactosa boolean,
-- 	foreign key (id) references Producto(id)
-- );

-- Crear tabla Postre
-- create table Postre (
--     id int primary key auto_increment,
--     tieneGluten boolean,
--     tieneLactosa boolean,
-- 	foreign key (id) references Producto(id)
-- );

-- Crear tabla Bebida
-- create table Bebida (
--     id int primary key auto_increment,
--     esAlcohólica boolean,
--     tieneCafeína boolean,
--     tieneAzúcar boolean,
-- 	foreign key (id) references Producto(id)
-- );

-- Crear tabla Mesa_Negocio
-- create table Mesa_Negocio (
--     numero_mesa smallint,
--     CIF_negocio int,
--     primary key (numero_mesa , CIF_negocio),
--     foreign key (numero_mesa) references Mesa (numero),
--     foreign key (CIF_negocio) references Negocio (CIF)
-- );



-- Crear tabla Menu_Negocio
-- create table Menu_Negocio (
--     id_menu int,
--     CIF_negocio int,
--     primary key (id_menu , CIF_negocio),
--     foreign key (id_menu) references Menu (id),
--     foreign key (CIF_negocio) references Negocio (CIF)
-- );

-- Crear tabla MenuDelDia_Negocio
-- create table MenuDelDia_Negocio (
--     id_menuDelDia int,
--     CIF_negocio int,
--     primary key (id_menuDelDia , CIF_negocio),
--     foreign key (id_menuDelDia) references MenuDel (id),
--     foreign key (CIF_negocio) references Negocio (CIF)
-- );