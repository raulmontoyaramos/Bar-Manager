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

-- Crear tabla Menu
 -- CREATE TABLE Menu (
	
 -- );




