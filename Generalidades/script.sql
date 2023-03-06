Use master

Create Database TelecomunicacionesSV

GO

Use TelecomunicacionesSV

Create Table roles(
Id_Rol int not null IDENTITY(1,1),
Rol varchar(50) not null,
)

Create Table areas(
Id_Area varchar(3) not null,
Area varchar (50) not null
)

Create Table empleados(
Id_Empleado int not null IDENTITY(1,1),
Nombres varchar(100) not null,
Apellidos varchar(100) not null,
Rol int not null,
Area varchar(3) not null
)

Create Table usuarios(
Id_Usuario int not null IDENTITY(1,1),
Empleado int not null,
Usuario varchar(50) not null,
Contrasena varchar(50) not null,
Estado varchar(50) not null,
)

Create Table casos(
Id_Caso varchar(15) not null,
Encargado int not null,
DescripcionA varchar(255) not null,
Fecha date not null,
DescripcionB varchar(255),
Finalizacion date,
Programador int,
PorcentajeAvance int,
Estado varchar(50) not null
)

Create Table bitacoras(
Id_Bitacora int not null IDENTITY(1,1),
Caso varchar(15) not null,
Descripcion varchar(255) not null,
Avance int not null,
Fecha date not null,
)

GO

Use TelecomunicacionesSV

Alter Table roles
Add Constraint PK_Roles
Primary Key (Id_rol)
GO

Alter Table empleados
Add Constraint PK_Empleados
Primary Key (Id_Empleado)
Go

Alter Table bitacoras
Add Constraint PK_Bitacoras
Primary Key (Id_Bitacora)
GO

Alter Table areas
Add Constraint PK_Areas
Primary Key (Id_Area)
GO

Alter Table usuarios
Add Constraint PK_Usuarios
Primary Key (Id_Usuario)
GO

Alter Table casos
Add Constraint PK_Casos
Primary Key (Id_Caso)
GO

Alter Table usuarios
ADD Constraint FK_UsuarioEmpleado
Foreign Key (Empleado)
References empleados(Id_Empleado)
GO

Alter Table usuarios
ADD Constraint FK_UsuarioEmpleado
Foreign Key (Empleado)
References empleados(Id_Empleado)
GO

Alter Table bitacoras
Add Constraint FK_BitacoraCaso
Foreign Key (Caso)
References casos(Id_Caso)
GO

Alter Table casos
Add Constraint FK_CasoEmpleadoEncargado
Foreign Key (Encargado)
References empleados(Id_Empleado)
GO

Alter Table casos
Add Constraint FK_CasoEmpleadoProgramador
Foreign Key (Programador)
References empleados(Id_Empleado)
GO

Alter Table empleados
Add Constraint FK_EmpleadoArea
Foreign Key (Area)
References areas(Id_Area)
GO

Alter Table empleados
Add Constraint FK_EmpleadoRol
Foreign Key (Rol)
References roles(Id_Rol)
GO