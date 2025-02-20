-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 20-02-2025 a las 18:44:13
-- Versión del servidor: 5.7.24
-- Versión de PHP: 8.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `equipo_colegio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `nif` varchar(10) NOT NULL,
  `apenom` varchar(30) DEFAULT NULL,
  `direc` varchar(30) DEFAULT NULL,
  `pobla` varchar(15) DEFAULT NULL,
  `telef` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`nif`, `apenom`, `direc`, `pobla`, `telef`) VALUES
('12344345', 'Alcalde García, Elena', 'C/Las Matas, 24', 'Madrid', '917766545'),
('4448242', 'Cerrato Vela, Luis', 'C/Mina 28 - 3A', 'Madrid', '916566545'),
('56882942', 'Díaz Fernández, María', 'C/Luis Vives 25', 'Móstoles', '915577545');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaturas`
--

CREATE TABLE `asignaturas` (
  `cod` tinyint(3) UNSIGNED NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `nif_profesor` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `asignaturas`
--

INSERT INTO `asignaturas` (`cod`, `nombre`, `nif_profesor`) VALUES
(1, 'Prog. Leng. Estr.', '12344346'),
(2, 'Sist. Informáticos', '12344346'),
(3, 'Análisis', '12344346'),
(4, 'FOL', '4448243'),
(5, 'RET', '4448243'),
(6, 'Entornos Gráficos', '4448243'),
(7, 'Aplic. Entornos 4ªGen', '56882941'),
(8, 'Idioma', '56882941');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `nif` varchar(10) NOT NULL,
  `cod_asignatura` tinyint(3) UNSIGNED NOT NULL,
  `nota` float(3,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `notas`
--

INSERT INTO `notas` (`nif`, `cod_asignatura`, `nota`) VALUES
('12344345', 1, 6.0),
('12344345', 2, 5.0),
('12344345', 3, 6.0),
('4448242', 4, 6.0),
('4448242', 5, 8.0),
('4448242', 6, 4.0),
('4448242', 7, 5.0),
('56882942', 4, 8.0),
('56882942', 5, 7.0),
('56882942', 6, 8.0),
('56882942', 7, 9.0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `nif` varchar(10) NOT NULL,
  `apenom` varchar(30) DEFAULT NULL,
  `direc` varchar(30) DEFAULT NULL,
  `pobla` varchar(15) DEFAULT NULL,
  `telef` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`nif`, `apenom`, `direc`, `pobla`, `telef`) VALUES
('12344346', 'Alcalde Pérez, Monica', 'C/Las Matas, 20', 'Madrid', '917747385'),
('4448243', 'Cerrato Vela, José', 'C/Mina 28 - 3B', 'Madrid', '916566543'),
('56882941', 'Díaz Fernández, Vanesa', 'C/Luis Vives 22', 'Móstoles', '915577542');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`nif`);

--
-- Indices de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD PRIMARY KEY (`cod`),
  ADD KEY `fk_profesor` (`nif_profesor`);

--
-- Indices de la tabla `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`nif`,`cod_asignatura`),
  ADD KEY `cod_asignatura` (`cod_asignatura`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`nif`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD CONSTRAINT `fk_profesor` FOREIGN KEY (`nif_profesor`) REFERENCES `profesores` (`nif`);

--
-- Filtros para la tabla `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`nif`) REFERENCES `alumnos` (`nif`),
  ADD CONSTRAINT `notas_ibfk_2` FOREIGN KEY (`cod_asignatura`) REFERENCES `asignaturas` (`cod`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
