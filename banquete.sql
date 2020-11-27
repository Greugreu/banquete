-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 27, 2020 at 01:22 PM
-- Server version: 5.7.26
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banquete`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `idclients` int(11) NOT NULL AUTO_INCREMENT,
  `clientsName` varchar(45) NOT NULL,
  `clientsSurname` varchar(45) NOT NULL,
  `birthdate` date NOT NULL,
  `tel` int(11) NOT NULL,
  `situation` varchar(45) DEFAULT NULL,
  `kids` varchar(45) DEFAULT NULL,
  `income` varchar(45) DEFAULT NULL,
  `isContact` tinyint(4) NOT NULL,
  `job` varchar(100) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `adress` varchar(255) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `creadtedAt` datetime NOT NULL,
  `modifiedAt` datetime NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idclients`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `client_offers`
--

DROP TABLE IF EXISTS `client_offers`;
CREATE TABLE IF NOT EXISTS `client_offers` (
  `idclient_offers` int(11) NOT NULL,
  `offers_idoffers` int(11) NOT NULL,
  `clients_idclients` int(11) NOT NULL,
  `history_idhistory` int(11) NOT NULL,
  PRIMARY KEY (`idclient_offers`,`offers_idoffers`,`clients_idclients`,`history_idhistory`),
  KEY `fk_client_offers_offers_idx` (`offers_idoffers`),
  KEY `fk_client_offers_clients1_idx` (`clients_idclients`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `offers`
--

DROP TABLE IF EXISTS `offers`;
CREATE TABLE IF NOT EXISTS `offers` (
  `idoffers` int(11) NOT NULL AUTO_INCREMENT,
  `offersName` varchar(45) NOT NULL,
  `offersPrice` float NOT NULL,
  `ageMini` int(11) DEFAULT NULL,
  `ageMaxi` int(11) DEFAULT NULL,
  `details` longtext NOT NULL,
  `createdAt` datetime NOT NULL,
  `modifiedAt` datetime NOT NULL,
  `offersToken` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idoffers`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `offers`
--

INSERT INTO `offers` (`idoffers`, `offersName`, `offersPrice`, `ageMini`, `ageMaxi`, `details`, `createdAt`, `modifiedAt`, `offersToken`) VALUES
(1, 'Livret A', 0, 0, 150, 'Intérêts exonérés d\'impôt sur le revenu et de prélèvements sociaux', '2020-11-24 00:00:00', '2020-11-24 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  `usersName` varchar(45) DEFAULT NULL,
  `usersSurname` varchar(45) DEFAULT NULL,
  `pseudo` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `calls` int(11) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `modifiedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`idusers`, `role`, `usersName`, `usersSurname`, `pseudo`, `password`, `calls`, `createdAt`, `modifiedAt`) VALUES
(1, 'admin', 'Antoine', 'Ratieuville', 'aratieuville', 'aratieuville', NULL, '2020-11-24 16:03:05', '2020-11-24 16:03:05');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `client_offers`
--
ALTER TABLE `client_offers`
  ADD CONSTRAINT `fk_client_offers_clients1` FOREIGN KEY (`clients_idclients`) REFERENCES `clients` (`idclients`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_client_offers_offers` FOREIGN KEY (`offers_idoffers`) REFERENCES `offers` (`idoffers`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
