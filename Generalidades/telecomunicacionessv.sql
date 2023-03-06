-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-03-2023 a las 22:37:27
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `telecomunicacionessv`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `areas`
--

CREATE TABLE `areas` (
  `Id_Area` varchar(3) NOT NULL,
  `Area` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `areas`
--

INSERT INTO `areas` (`Id_Area`, `Area`) VALUES
('FNZ', 'Finanzas'),
('FTF', 'Facturación Fija'),
('FTM', 'Facturación Móvil'),
('GNL', 'General'),
('VNT', 'Ventas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacoras`
--

CREATE TABLE `bitacoras` (
  `Id_Bitacora` int(11) NOT NULL,
  `Caso` varchar(15) NOT NULL,
  `Descripcion` varchar(255) NOT NULL,
  `Avance` int(11) NOT NULL,
  `Fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bitacoras`
--

INSERT INTO `bitacoras` (`Id_Bitacora`, `Caso`, `Descripcion`, `Avance`, `Fecha`) VALUES
(1, 'FNZ23123', 'Prueba de bitacora', 15, '2023-03-07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `casos`
--

CREATE TABLE `casos` (
  `Id_Caso` varchar(15) NOT NULL,
  `Encargado` int(11) NOT NULL,
  `DescripcionA` varchar(255) NOT NULL,
  `Fecha` date NOT NULL,
  `DescripcionB` varchar(255) NOT NULL,
  `Finalizacion` date NOT NULL,
  `Programador` int(11) NOT NULL,
  `PorcentajeAvance` int(11) NOT NULL,
  `Estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `casos`
--

INSERT INTO `casos` (`Id_Caso`, `Encargado`, `DescripcionA`, `Fecha`, `DescripcionB`, `Finalizacion`, `Programador`, `PorcentajeAvance`, `Estado`) VALUES
('FNZ23123', 3, 'Prueba Prueba Prueba Prueba', '2023-03-06', 'Comentario del Jefe de Desarrollo para el Programador', '2023-03-31', 5, 0, 'EN ESPERA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `Id_Empleado` int(11) NOT NULL,
  `Nombres` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Rol` int(11) NOT NULL,
  `Area` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`Id_Empleado`, `Nombres`, `Apellidos`, `Rol`, `Area`) VALUES
(1, 'Diego', 'Chevez', 1, 'GNL'),
(2, 'Cesar', 'Rodas', 3, 'FNZ'),
(3, 'Erick', 'Fuentes', 2, 'FNZ'),
(4, 'Angie', 'Valencia', 4, 'FNZ'),
(5, 'Bryan', 'Cornejo', 5, 'FNZ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `Id_Rol` int(11) NOT NULL,
  `Rol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`Id_Rol`, `Rol`) VALUES
(1, 'Administrador'),
(2, 'Jefe'),
(3, 'Jefe de Desarrollo'),
(4, 'Empleado'),
(5, 'Programadores');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Id_Usuario` int(11) NOT NULL,
  `Empleado` int(11) NOT NULL,
  `Usuario` varchar(50) NOT NULL,
  `Contrasena` varchar(50) NOT NULL,
  `Estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Id_Usuario`, `Empleado`, `Usuario`, `Contrasena`, `Estado`) VALUES
(1, 1, 'DiegoChevez', 'passwd123', 'Activo'),
(2, 2, 'CesarRodas', 'passwd123', 'Activo'),
(3, 3, 'ErickFuentes', 'passwd123', 'Activo'),
(4, 4, 'AngieValencia', 'passwd123', 'Activo'),
(5, 5, 'BryanCornejo', 'passwd123', 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `areas`
--
ALTER TABLE `areas`
  ADD PRIMARY KEY (`Id_Area`);

--
-- Indices de la tabla `bitacoras`
--
ALTER TABLE `bitacoras`
  ADD PRIMARY KEY (`Id_Bitacora`),
  ADD KEY `Caso` (`Caso`);

--
-- Indices de la tabla `casos`
--
ALTER TABLE `casos`
  ADD PRIMARY KEY (`Id_Caso`),
  ADD UNIQUE KEY `Encargado` (`Encargado`),
  ADD UNIQUE KEY `Programador` (`Programador`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`Id_Empleado`),
  ADD KEY `Area` (`Area`),
  ADD KEY `Rol` (`Rol`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`Id_Rol`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Id_Usuario`),
  ADD KEY `Empleado` (`Empleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bitacoras`
--
ALTER TABLE `bitacoras`
  MODIFY `Id_Bitacora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `Id_Empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `Id_Rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Id_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bitacoras`
--
ALTER TABLE `bitacoras`
  ADD CONSTRAINT `bitacoras_ibfk_1` FOREIGN KEY (`Caso`) REFERENCES `casos` (`Id_Caso`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `casos`
--
ALTER TABLE `casos`
  ADD CONSTRAINT `casos_ibfk_1` FOREIGN KEY (`Encargado`) REFERENCES `empleados` (`Id_Empleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `casos_ibfk_2` FOREIGN KEY (`Programador`) REFERENCES `empleados` (`Id_Empleado`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`Rol`) REFERENCES `roles` (`Id_Rol`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `empleados_ibfk_2` FOREIGN KEY (`Area`) REFERENCES `areas` (`Id_Area`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`Empleado`) REFERENCES `empleados` (`Id_Empleado`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
