-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 06-06-2012 a las 23:55:17
-- Versión del servidor: 5.5.16
-- Versión de PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `acme_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidence`
--

CREATE TABLE IF NOT EXISTS `incidence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cemail` varchar(255) DEFAULT NULL,
  `cname` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `replayDate` datetime DEFAULT NULL,
  `replayDescription` varchar(255) DEFAULT NULL,
  `replayMark` int(11) DEFAULT NULL,
  `incidence_id` int(11) DEFAULT NULL,
  `procedure_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `technical_dni` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK182B73A45D4C07AC` (`procedure_id`),
  KEY `FK182B73A4BE192AD8` (`incidence_id`),
  KEY `FK182B73A4F4EBC91` (`technical_dni`),
  KEY `FK182B73A4268E3EA3` (`product_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `incidence`
--

INSERT INTO `incidence` (`id`, `cemail`, `cname`, `date`, `des`, `replayDate`, `replayDescription`, `replayMark`, `incidence_id`, `procedure_id`, `product_id`, `technical_dni`) VALUES
(1, NULL, 'simo', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, NULL, 'simo', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `PERS_TYPE` varchar(31) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sur_name` varchar(255) DEFAULT NULL,
  `credentials` varchar(255) DEFAULT NULL,
  `logged` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `boss_dni` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `FK8E488775381ACE63` (`boss_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `person`
--

INSERT INTO `person` (`PERS_TYPE`, `dni`, `address`, `birthday`, `email`, `first_name`, `phone`, `sur_name`, `credentials`, `logged`, `password`, `user`, `boss_dni`) VALUES
('TECHNICAL', '32321', NULL, NULL, NULL, 'Simo', NULL, 'Gharbi', NULL, '0', '545fsbvvcb', 'simo163', '54453'),
('TECHNICAL', '42423', NULL, NULL, 'gogo@hotmail.com', 'mohammed', '432424', 'Gharbi', NULL, '0', '0000', 'gogo', NULL),
('TECHNICAL', '43223', NULL, NULL, 'gdfd', 'fds', '8798', 'gfd', NULL, '0', 'bc', 'gwt', NULL),
('BOSS', '54453', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('TECHNICAL', 'dsada', NULL, NULL, 'dsadsa', 'adil', 'fdsfsd', 'boukro', NULL, '0', '321', 'adil', NULL),
('TECHNICAL', 'hola', NULL, NULL, 'anas@gmail.com', NULL, NULL, NULL, NULL, '0', '1111', 'anass', NULL),
('TECHNICAL', 'qwerty', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '0000', 'ale', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person_proceduree`
--

CREATE TABLE IF NOT EXISTS `person_proceduree` (
  `technicals_dni` varchar(255) NOT NULL,
  `procedures_id` int(11) NOT NULL,
  PRIMARY KEY (`technicals_dni`,`procedures_id`),
  KEY `FK3725B71CD205075F` (`procedures_id`),
  KEY `FK3725B71C55ABD56A` (`technicals_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proceduree`
--

CREATE TABLE IF NOT EXISTS `proceduree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `proceduree`
--

INSERT INTO `proceduree` (`id`, `description`, `name`) VALUES
(1, 'fdsfd', 'buton problem'),
(2, 'fdsfd', 'buton problem'),
(3, NULL, 'voz');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proceduree_product`
--

CREATE TABLE IF NOT EXISTS `proceduree_product` (
  `procedures_id` int(11) NOT NULL,
  `products_id` int(11) NOT NULL,
  PRIMARY KEY (`procedures_id`,`products_id`),
  KEY `FKBE5B8DA2D205075F` (`procedures_id`),
  KEY `FKBE5B8DA26536EA0E` (`products_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `des` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id`, `des`, `name`) VALUES
(1, NULL, 'raton'),
(2, 'auriculares', 'auriculares'),
(3, 'raton', 'raton'),
(4, 'auriculares', 'auriculares'),
(5, 'raton', 'raton'),
(6, NULL, 'raton'),
(7, 'auriculares', 'auriculares');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `incidence`
--
ALTER TABLE `incidence`
  ADD CONSTRAINT `FK182B73A4268E3EA3` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FK182B73A45D4C07AC` FOREIGN KEY (`procedure_id`) REFERENCES `proceduree` (`id`),
  ADD CONSTRAINT `FK182B73A4BE192AD8` FOREIGN KEY (`incidence_id`) REFERENCES `incidence` (`id`),
  ADD CONSTRAINT `FK182B73A4F4EBC91` FOREIGN KEY (`technical_dni`) REFERENCES `person` (`dni`);

--
-- Filtros para la tabla `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `FK8E488775381ACE63` FOREIGN KEY (`boss_dni`) REFERENCES `person` (`dni`);

--
-- Filtros para la tabla `person_proceduree`
--
ALTER TABLE `person_proceduree`
  ADD CONSTRAINT `FK3725B71C55ABD56A` FOREIGN KEY (`technicals_dni`) REFERENCES `person` (`dni`),
  ADD CONSTRAINT `FK3725B71CD205075F` FOREIGN KEY (`procedures_id`) REFERENCES `proceduree` (`id`);

--
-- Filtros para la tabla `proceduree_product`
--
ALTER TABLE `proceduree_product`
  ADD CONSTRAINT `FKBE5B8DA26536EA0E` FOREIGN KEY (`products_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKBE5B8DA2D205075F` FOREIGN KEY (`procedures_id`) REFERENCES `proceduree` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
