--1
CREATE DATABASE Colegio;

-- Usar la base de datos
USE Colegio;

-- Crear tabla Alumno
CREATE TABLE Alumno (
id_alumno INT PRIMARY KEY,
nombre_completo VARCHAR(100),
correo VARCHAR(100),
apodo VARCHAR(50)
);

-- Crear tabla Docente
CREATE TABLE Docente (
id_docente INT PRIMARY KEY,
nombre VARCHAR(100),
especialidad VARCHAR(100),
correo_institucional VARCHAR(100)
);

-- Crear tabla Asignatura
CREATE TABLE Asignatura (
id_asignatura INT PRIMARY KEY,
codigo_asignatura INT,
titulo VARCHAR(100),
nivel VARCHAR(50)
);

-- Crear tabla Inscripcion
CREATE TABLE Inscripcion (
id_inscripcion INT PRIMARY KEY,
id_alumno INT,
id_asignatura INT,
codigo_inscripcion INT,
FOREIGN KEY (id_alumno) REFERENCES Alumno(id_alumno),
FOREIGN KEY (id_asignatura) REFERENCES Asignatura(id_asignatura)
);

-- Crear tabla AsignaturaDocente
CREATE TABLE AsignaturaDocente (
id_asignatura_docente INT PRIMARY KEY,
id_asignatura INT,
id_docente INT,
periodo VARCHAR(20),
FOREIGN KEY (id_asignatura) REFERENCES Asignatura(id_asignatura),
FOREIGN KEY (id_docente) REFERENCES Docente(id_docente)
);

CREATE TABLE Horario (
id_horario INT PRIMARY KEY,
id_asignatura_docente INT,
dia VARCHAR(20),
hora_inicio TIME,
hora_fin TIME,
aula VARCHAR(20),
FOREIGN KEY (id_asignatura_docente) REFERENCES AsignaturaDocente(id_asignatura_docente)
);

-- Crear tabla Nota
CREATE TABLE Nota (
id_nota INT PRIMARY KEY,
id_inscripcion INT,
tipo VARCHAR(50),
calificacion DECIMAL(4,2),
fecha DATE,
FOREIGN KEY (id_inscripcion) REFERENCES Inscripcion(id_inscripcion)
);

--2 BD CINE

CREATE DATABASE Cine;
USE Cine;

--Se crea tabla Sala
CREATE TABLE Sala (
id_sala INT PRIMARY KEY,
numero INT
);

--Se crea tabla Comida
CREATE TABLE Comida (
id_comida INT PRIMARY KEY,
nombre VARCHAR (50),
descripcion VARCHAR (100),
precio DECIMAL (10,3)
);

--Se crea tabla Cliente
CREATE TABLE Cliente (
id_cliente INT PRIMARY KEY,
nombre VARCHAR (50),
correo VARCHAR (100),
edad INT
);

--Se crea tabla Genero
CREATE TABLE Genero (
id_genero INT PRIMARY KEY,
nombre VARCHAR (50)
);

--Se crea tabla Pelicula
CREATE TABLE Pelicula (
id_pelicula INT PRIMARY KEY,
id_genero INT,
titulo VARCHAR (50),
descripcion VARCHAR (100),
FOREIGN KEY (id_genero) REFERENCES Genero(id_genero)
);

--Se crea tabla Funcion
CREATE TABLE Funcion (
id_funcion INT PRIMARY KEY,
id_pelicula INT,
id_sala INT,
fecha DATE,
hora TIME,
FOREIGN KEY (id_pelicula) REFERENCES Pelicula(id_pelicula),
FOREIGN KEY (id_sala) REFERENCES Sala(id_sala)
);

--Se crea tabla Venta comida
CREATE TABLE venta_comida (
id_venta INT PRIMARY KEY,
id_cliente INT,
id_comida INT,
cantidad INT,
FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
FOREIGN KEY (id_comida) REFERENCES Comida(id_comida)
);

--Se crea tabla Ticket
CREATE TABLE Ticket (
id_ticket INT PRIMARY KEY,
id_cliente INT,
id_funcion INT,
FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
FOREIGN KEY (id_funcion) REFERENCES Funcion(id_funcion)
);

--3 BD AEROPUERTO

CREATE DATABASE Aeropuerto;
USE Aeropuerto;

--Se crea tabla cliente
CREATE TABLE Cliente (
id_cliente INT PRIMARY KEY,
nombre VARCHAR(50),
documento VARCHAR (20),
telefono VARCHAR(20),
correo VARCHAR(50)
);

--Se crea tabla Empleado
CREATE TABLE Empleado (
id_empleado INT PRIMARY KEY,
nombre VARCHAR(50),
telefono VARCHAR(20),
correo VARCHAR(50)
);

--Se crea tabla Avion
CREATE TABLE Avion (
id_avion INT PRIMARY KEY,
numero INT,
capacidad INT,
aerolinea VARCHAR (50)
);

--Se crea tabla Destino
CREATE TABLE Destino (
id_destino INT PRIMARY KEY,
ciudad VARCHAR (50),
pais VARCHAR (50)
);

--Se crea tabla Vuelo
CREATE TABLE Vuelo (
id_vuelo INT PRIMARY KEY,
id_avion INT,
id_destino INT,
fecha_salida DATE,
fecha_llegada DATE,
FOREIGN KEY (id_avion) REFERENCES Avion(id_avion),
FOREIGN KEY (id_destino) REFERENCES Destino(id_destino)
);

--Se crea tabla Metodo pago
CREATE TABLE MetodoPago (
id_metodo INT PRIMARY KEY,
tipo VARCHAR (50)
);

--Se crea tabla Pago
CREATE TABLE Pago (
id_pago INT PRIMARY KEY,
id_cliente INT,
id_metodo INT,
precio DECIMAL (10,3),
FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
FOREIGN KEY (id_metodo) REFERENCES MetodoPago(id_metodo)
);

--Se crea tabla Ticket
CREATE TABLE Ticket (
id_ticket INT PRIMARY KEY,
id_cliente INT,
id_vuelo INT,
id_pago INT,
fecha DATE,
FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
FOREIGN KEY (id_vuelo) REFERENCES Vuelo(id_vuelo),
FOREIGN KEY (id_pago) REFERENCES Pago(id_pago)
);

--4 BD PRESTAMO LIBROS

CREATE DATABASE prestamo_libros;
USE prestamo_libros;

--Se cambio a VARCHAR estado

CREATE TABLE Libros(
id_libro INT PRIMARY KEY,
titulo VARCHAR(255) NOT NULL,
autor VARCHAR(200),
estado VARCHAR(100)
);

CREATE TABLE usuario(
id_usuario INT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
correo VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE prestamo(
id_prestamo INT PRIMARY KEY,
id_libro INT,
id_usuario INT,
fecha_prestamo DATE,
fecha_devolucion DATE,
FOREIGN KEY (id_libro) REFERENCES Libros(id_libro),
FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

--5 GYM
CREATE DATABASE Gym;
USE Gym;

CREATE TABLE clientes(
id_cliente INT PRIMARY KEY,
nombre VARCHAR(100),
documento VARCHAR(100),
correo VARCHAR (200),
telefono VARCHAR(20),
fecha_registro DATE
);

CREATE TABLE entrenadores(
id_entrenador INT PRIMARY KEY,
nombre VARCHAR(100),
telefono VARCHAR(20)
);

CREATE TABLE membresias(
id_membresia INT PRIMARY KEY,
duracion VARCHAR(50),
precio DECIMAL(10,2),
);

CREATE TABLE asistencia(
id_asistencia INT PRIMARY KEY,
id_cliente INT,
fecha DATE,
FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE pagos(
id_pago INT PRIMARY KEY,
id_cliente INT,
id_membresia INT,
fecha_pago DATE,
total_pago DECIMAL(10,2),
FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
FOREIGN KEY (id_membresia) REFERENCES membresias(id_membresia)
);

--6 HOTEL
CREATE DATABASE Hotel;
USE Hotel;

CREATE TABLE cliente(
id_cliente INT PRIMARY KEY,
nombre VARCHAR(100),
telefono VARCHAR(50),
documento VARCHAR(50)
);

CREATE TABLE habitaciones(
id_habitaciones INT PRIMARY KEY,
numero INT,
precio DECIMAL(10,2),
estado VARCHAR(20),
);

CREATE TABLE reservas(
id_reserva INT PRIMARY KEY,
id_habitaciones INT,
id_cliente INT,
fecha_entrada DATE,
fecha_salida DATE,
estado VARCHAR(20),
FOREIGN KEY (id_habitaciones) REFERENCES habitaciones(id_habitaciones),
FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE pagos(
id_pago INT PRIMARY KEY,
id_reserva INT,
pago_total DECIMAL(10,2),
fecha_pago DATE,
FOREIGN KEY (id_reserva) REFERENCES reservas(id_reserva)
);

--7 HOSPITALDB
CREATE DATABASE HospitalDB;
GO
USE HospitalDB;

CREATE TABLE Paciente (
    id_paciente INT PRIMARY KEY,
    nombre VARCHAR(100),
    documento VARCHAR(20) UNIQUE
);

CREATE TABLE Medico (
    id_medico INT PRIMARY KEY,
    nombre VARCHAR(100),
    especialidad VARCHAR(50)
);

CREATE TABLE Cita (
    id_cita INT PRIMARY KEY,
    fecha DATETIME,
    id_paciente INT,
    id_medico INT,
    FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente),
    FOREIGN KEY (id_medico) REFERENCES Medico(id_medico)
);

--8 TIENDADB

CREATE DATABASE TiendaDB;
GO
USE TiendaDB;

CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY,
    nombre VARCHAR(100)
);

CREATE TABLE Producto (
    id_producto INT PRIMARY KEY,
    nombre VARCHAR(100),
    precio DECIMAL(10,2)
);

CREATE TABLE Venta (
    id_venta INT PRIMARY KEY,
    id_cliente INT,
    id_producto INT,
    cantidad INT,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

--9 UNIVERSIDAD DB

CREATE DATABASE UniversidadDB2;
GO
USE UniversidadDB2;

CREATE TABLE Facultad (
    id_facultad INT PRIMARY KEY,
    nombre VARCHAR(100)
);

CREATE TABLE Carrera (
    id_carrera INT PRIMARY KEY,
    nombre VARCHAR(100),
    id_facultad INT,
    FOREIGN KEY (id_facultad) REFERENCES Facultad(id_facultad)
);

CREATE TABLE Alumno (
    id_alumno INT PRIMARY KEY,
    nombre VARCHAR(100),
    id_carrera INT,
    FOREIGN KEY (id_carrera) REFERENCES Carrera(id_carrera)
);

CREATE TABLE Profesor (
    id_profesor INT PRIMARY KEY,
    nombre VARCHAR(100)
);

CREATE TABLE Curso (
    id_curso INT PRIMARY KEY,
    nombre VARCHAR(100),
    id_profesor INT,
    FOREIGN KEY (id_profesor) REFERENCES Profesor(id_profesor)
);

CREATE TABLE Inscripcion (
    id_inscripcion INT PRIMARY KEY,
    id_alumno INT,
    id_curso INT,
    FOREIGN KEY (id_alumno) REFERENCES Alumno(id_alumno),
    FOREIGN KEY (id_curso) REFERENCES Curso(id_curso)
);

--10 BDLOGISTICA

CREATE DATABASE LogisticaDB;
GO
USE LogisticaDB;

-- 1. Cliente
CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    documento VARCHAR(20) UNIQUE,
    correo VARCHAR(100),
    telefono VARCHAR(20)
);

-- 2. Ciudad
CREATE TABLE Ciudad (
    id_ciudad INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    departamento VARCHAR(100) NOT NULL
);

-- 3. Envio
CREATE TABLE Envio (
    id_envio INT PRIMARY KEY,
    fecha_envio DATE NOT NULL,
    fecha_entrega DATE,
    id_cliente INT NOT NULL,
    origen INT NOT NULL,
    destino INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (origen) REFERENCES Ciudad(id_ciudad),
    FOREIGN KEY (destino) REFERENCES Ciudad(id_ciudad)
);

-- 4. Paquete
CREATE TABLE Paquete (
    id_paquete INT PRIMARY KEY,
    descripcion VARCHAR(200),
    peso DECIMAL(10,2),
    volumen DECIMAL(10,2),
    id_envio INT NOT NULL,
    FOREIGN KEY (id_envio) REFERENCES Envio(id_envio)
);

-- 5. Transportista
CREATE TABLE Transportista (
    id_transportista INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    vehiculo VARCHAR(50) NOT NULL,
    telefono VARCHAR(20)
);

-- 6. Ruta
CREATE TABLE Ruta (
    id_ruta INT PRIMARY KEY,
    id_envio INT NOT NULL,
    id_transportista INT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (id_envio) REFERENCES Envio(id_envio),
    FOREIGN KEY (id_transportista) REFERENCES Transportista(id_transportista)
);

--11 VETERINARIA
CREATE DATABASE Veterinaria;
USE Veterinaria;

-- Tabla de clientes
CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY,
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    correo VARCHAR(100),
    direccion VARCHAR(150)
);

-- Tabla de mascotas
CREATE TABLE Mascota (
    id_mascota INT PRIMARY KEY,
    id_cliente INT,
    nombre VARCHAR(50),
    especie VARCHAR(50),
    raza VARCHAR(50),
    edad INT,
    sexo VARCHAR(10),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

-- Tabla de veterinarios
CREATE TABLE Veterinario (
    id_veterinario INT PRIMARY KEY,
    nombre VARCHAR(100),
    especialidad VARCHAR(100),
    telefono VARCHAR(20),
    correo VARCHAR(100)
);

-- Tabla de citas
CREATE TABLE Cita (
    id_cita INT PRIMARY KEY,
    id_mascota INT,
    id_veterinario INT,
    fecha DATE,
    hora TIME,
    motivo VARCHAR(200),
    FOREIGN KEY (id_mascota) REFERENCES Mascota(id_mascota),
    FOREIGN KEY (id_veterinario) REFERENCES Veterinario(id_veterinario)
);

-- Tabla de tratamientos
CREATE TABLE Tratamiento (
    id_tratamiento INT PRIMARY KEY,
    id_cita INT,
    descripcion VARCHAR(200),
    medicamentos VARCHAR(200),
    observaciones TEXT,
    FOREIGN KEY (id_cita) REFERENCES Cita(id_cita)
);

-- Tabla de servicios
CREATE TABLE Servicio (
    id_servicio INT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion VARCHAR(200),
    precio DECIMAL(10,2)
);

-- Tabla de facturas
CREATE TABLE Factura (
    id_factura INT PRIMARY KEY,
    id_cliente INT,
    fecha DATE,
    total DECIMAL(10,2),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

-- Tabla de detalle de factura
CREATE TABLE DetalleFactura (
    id_detalle INT PRIMARY KEY,
    id_factura INT,
    id_servicio INT,
    cantidad INT,
    subtotal DECIMAL(10,2),
    FOREIGN KEY (id_factura) REFERENCES Factura(id_factura),
    FOREIGN KEY (id_servicio) REFERENCES Servicio(id_servicio)
);

--12 CONCIERTO

CREATE DATABASE Concierto;
USE Concierto;

CREATE TABLE Artista (
    id_artista INT PRIMARY KEY,
    nombre VARCHAR(100),
    genero VARCHAR(50),
    nacionalidad VARCHAR(50)
);

CREATE TABLE Zona (
    id_zona INT PRIMARY KEY,
    nombre VARCHAR(50),
    capacidad INT,
    precio DECIMAL(10,2)
);

CREATE TABLE Persona (
    id_persona INT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100),
    edad INT
);

CREATE TABLE Entrada (
    id_entrada INT PRIMARY KEY,
    id_asistente INT,
    id_zona INT,
    fecha_compra DATE,
    FOREIGN KEY (id_asistente) REFERENCES Persona(id_persona),
    FOREIGN KEY (id_zona) REFERENCES Zona(id_zona)
);

CREATE TABLE Presentacion (
    id_presentacion INT PRIMARY KEY,
    id_artista INT,
    hora_inicio TIME,
    hora_fin TIME,
    fecha DATE,
    escenario VARCHAR(50),
    FOREIGN KEY (id_artista) REFERENCES Artista(id_artista)
);

CREATE TABLE Patrocinador (
    id_patrocinador INT PRIMARY KEY,
    nombre VARCHAR(100),
    rubro VARCHAR(100),
    contacto VARCHAR(100)
);

CREATE TABLE Staff (
    id_staff INT PRIMARY KEY,
    nombre VARCHAR(100),
    rol VARCHAR(50),
    telefono VARCHAR(20)
);

-- 13 BD BIBLIOTECA

CREATE DATABASE BibliotecaDB;
GO
USE BibliotecaDB;

CREATE TABLE Autor (
    id_autor INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Editorial (
    id_editorial INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Libro (
    id_libro INT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    anio INT,
    id_autor INT NOT NULL,
    id_editorial INT NOT NULL,
    FOREIGN KEY (id_autor) REFERENCES Autor(id_autor),
    FOREIGN KEY (id_editorial) REFERENCES Editorial(id_editorial)
);

CREATE TABLE Usuario (
    id_usuario INT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100) UNIQUE
);

CREATE TABLE Prestamo (
    id_prestamo INT PRIMARY KEY,
    fecha DATE,
    id_usuario INT,
    id_libro INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (id_libro) REFERENCES Libro(id_libro)
);

CREATE DATABASE aeropuertoPinto;
USE aeropuertoPinto;

CREATE TABLE Aeropuertos (
    idAeropuerto INT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(100) NOT NULL,
    ciudad NVARCHAR(50) NOT NULL,
    pais NVARCHAR(50) NOT NULL
);

CREATE TABLE Aerolineas (
    idAerolinea INT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Aviones (
    idAvion INT PRIMARY KEY IDENTITY(1,1),
    matricula NVARCHAR(20) NOT NULL UNIQUE,
    modelo NVARCHAR(50) NOT NULL,
    capacidad INT NOT NULL CHECK (capacidad > 0),
    idAerolinea INT NOT NULL,
    CONSTRAINT FK_Aviones_Aerolineas FOREIGN KEY (idAerolinea) REFERENCES Aerolineas(idAerolinea)
);

CREATE TABLE Pilotos (
    idPiloto INT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(50) NOT NULL,
    apellido NVARCHAR(50) NOT NULL,
    licencia NVARCHAR(30) NOT NULL UNIQUE,
    idAerolinea INT NOT NULL,
    CONSTRAINT FK_Pilotos_Aerolineas FOREIGN KEY (idAerolinea) REFERENCES Aerolineas(idAerolinea)
);

CREATE TABLE Vuelos (
    idVuelo INT PRIMARY KEY IDENTITY(1,1),
    codigo NVARCHAR(20) NOT NULL UNIQUE,
    idAerolinea INT NOT NULL,
    idAvion INT NOT NULL,
    idPiloto INT NOT NULL,
    idAeropuertoOrigen INT NOT NULL,
    idAeropuertoDestino INT NOT NULL,
    fechaSalida DATETIME NOT NULL,
    fechaLlegada DATETIME NOT NULL,
    CONSTRAINT FK_Vuelos_Aerolineas FOREIGN KEY (idAerolinea) REFERENCES Aerolineas(idAerolinea),
    CONSTRAINT FK_Vuelos_Aviones FOREIGN KEY (idAvion) REFERENCES Aviones(idAvion),
    CONSTRAINT FK_Vuelos_Pilotos FOREIGN KEY (idPiloto) REFERENCES Pilotos(idPiloto),
    CONSTRAINT FK_Vuelos_Origen FOREIGN KEY (idAeropuertoOrigen) REFERENCES Aeropuertos(idAeropuerto),
    CONSTRAINT FK_Vuelos_Destino FOREIGN KEY (idAeropuertoDestino) REFERENCES Aeropuertos(idAeropuerto),
    CONSTRAINT CK_FechasVuelo CHECK (fechaLlegada > fechaSalida)
);

CREATE TABLE Pasajeros (
    idPasajero INT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(50) NOT NULL,
    apellido NVARCHAR(50) NOT NULL,
    documento NVARCHAR(20) NOT NULL UNIQUE,
    telefono NVARCHAR(20)
);

CREATE TABLE Reservas (
    idReserva INT PRIMARY KEY IDENTITY(1,1),
    idVuelo INT NOT NULL,
    idPasajero INT NOT NULL,
    asiento NVARCHAR(5) NOT NULL,
    fechaReserva DATETIME NOT NULL DEFAULT GETDATE(),
    CONSTRAINT FK_Reservas_Vuelos FOREIGN KEY (idVuelo) REFERENCES Vuelos(idVuelo),
    CONSTRAINT FK_Reservas_Pasajeros FOREIGN KEY (idPasajero) REFERENCES Pasajeros(idPasajero),
    CONSTRAINT UQ_AsientoVuelo UNIQUE (idVuelo, asiento)
);

CREATE TABLE Equipajes (
    idEquipaje INT PRIMARY KEY IDENTITY(1,1),
    idReserva INT NOT NULL,
    peso DECIMAL(5,2) NOT NULL CHECK (peso > 0),
    descripcion NVARCHAR(100),
    CONSTRAINT FK_Equipajes_Reservas FOREIGN KEY (idReserva) REFERENCES Reservas(idReserva)
);

CREATE DATABASE matriculaPinto;
USE matriculaPinto;

CREATE TABLE Alumnos (
  codAlumno INT IDENTITY(1,1) PRIMARY KEY, 
  nombreAlumno VARCHAR(50),
  especialidad VARCHAR(50)
);


CREATE TABLE Docentes (
  codDocente INT IDENTITY(1,1) PRIMARY KEY, 
  nombreDocente VARCHAR(50),
  oficina VARCHAR(50)
);


CREATE TABLE Cursos (
  codCurso INT IDENTITY(1,1) PRIMARY KEY, 
  nombreCurso VARCHAR(50),
  seccion VARCHAR(50),
  codDocente INT,
  FOREIGN KEY (codDocente) REFERENCES Docentes (codDocente)
);


CREATE TABLE Inscripciones (
  codCurso INT,
  codAlumno INT,
  FOREIGN KEY (codCurso) REFERENCES Cursos (codCurso) ON DELETE CASCADE, 
  FOREIGN KEY (codAlumno) REFERENCES Alumnos (codAlumno) ON DELETE CASCADE 
);

CREATE DATABASE mercanciaPinto;
USE mercanciaPinto;


CREATE TABLE CIUDAD (
    COD_CIUDAD INT PRIMARY KEY,
    NOMBRE_CIUDAD VARCHAR(100) NOT NULL
);

CREATE TABLE PAQUETE (
    CODIGO INT PRIMARY KEY,
    TIPO VARCHAR(50) NOT NULL,
    NOMBRE VARCHAR(100) NOT NULL,
    DESCRIPCION VARCHAR(255)
);

CREATE TABLE EMPRESA_ORIGEN (
    ORGN_RIF VARCHAR(20) PRIMARY KEY,
    ORGN_NOM VARCHAR(100) NOT NULL,
    ORGN_ACT VARCHAR(100),
    ORGN_DIR VARCHAR(200),
    ORGN_TEL VARCHAR(20),
    ORGN_CEL VARCHAR(20),
    COD_CIUDAD INT NOT NULL,
    FOREIGN KEY (COD_CIUDAD) REFERENCES CIUDAD(COD_CIUDAD)
);

CREATE TABLE DESTINATARIO (
    DEST_ID INT PRIMARY KEY,
    DEST_NOM VARCHAR(100) NOT NULL,
    DEST_DIR VARCHAR(200),
    DEST_TEL VARCHAR(20),
    COD_CIUDAD INT NOT NULL,
    FOREIGN KEY (COD_CIUDAD) REFERENCES CIUDAD(COD_CIUDAD)
);

CREATE TABLE GUIA (
    GUIA_NO INT PRIMARY KEY,
    GUIA_FECHA DATE NOT NULL,
    GUIA_HORA TIME NOT NULL,
    ORGN_RIF VARCHAR(20) NOT NULL,
    DEST_ID INT NOT NULL,
    CODIGO INT NOT NULL,
    DEST_KM DECIMAL(10,2),
    VALR_FLETE DECIMAL(12,2),
    FOREIGN KEY (ORGN_RIF) REFERENCES EMPRESA_ORIGEN(ORGN_RIF),
    FOREIGN KEY (DEST_ID) REFERENCES DESTINATARIO(DEST_ID),
    FOREIGN KEY (CODIGO) REFERENCES PAQUETE(CODIGO)
);