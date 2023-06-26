-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-04-2020 a las 17:44:35
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `multienvios`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envios`
--

CREATE TABLE `envios` (
  `Numero De Envio` varchar(10) NOT NULL,
  `Mercancia(s)` varchar(250) NOT NULL,
  `Origen` varchar(30) NOT NULL,
  `Destino` varchar(30) NOT NULL,
  `Tipo De Envio` varchar(15) NOT NULL,
  `Destinatario` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `envios`
--

INSERT INTO `envios` (`Numero De Envio`, `Mercancia(s)`, `Origen`, `Destino`, `Tipo De Envio`, `Destinatario`) VALUES
('268', 'Mercancia serial: 368\n Descripcion: \n Cantidad: 0\n Peso: 0.0', 'Bogota', 'Cali', 'Aereo', '\nId: 798\nNombre: pepe\nTelefono: 321654'),
('490', 'Mercancia serial: 955\n Descripcion: \n Cantidad: 0\n Peso: 0.0', 'China', 'Colombia', 'Aereo', '\nId: 7894561230\nNombre: Alexander\nTelefono: 3124567480'),
('995', 'Mercancia serial: 843\n Descripcion: \n Cantidad: 0\n Peso: 0.0', 'España', 'Colombia', 'Aereo', '\nId: 15648\nNombre: Sebastian\nTelefono: 31548');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mercancias`
--

CREATE TABLE `mercancias` (
  `Serial` varchar(10) NOT NULL,
  `Descipcion` varchar(150) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Peso` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mercancias`
--

INSERT INTO `mercancias` (`Serial`, `Descipcion`, `Cantidad`, `Peso`) VALUES
('198', 'Equipos de Sonido', 3, 45),
('773', 'Teclados', 2, 8.5),
('920', 'Zapatos', 9, 6.5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `envios`
--
ALTER TABLE `envios`
  ADD PRIMARY KEY (`Numero De Envio`);

--
-- Indices de la tabla `mercancias`
--
ALTER TABLE `mercancias`
  ADD PRIMARY KEY (`Serial`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
