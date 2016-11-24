CREATE DATABASE  IF NOT EXISTS `ME_GUIA` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ME_GUIA`;
-- MySQL dump 10.13  Distrib 5.7.9, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: ME_GUIA
-- ------------------------------------------------------
-- Server version	5.6.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Beacon`
--

DROP TABLE IF EXISTS `Beacon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Beacon` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ativo` tinyint(1) NOT NULL,
  `Endereco_MAC` char(17) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Descricao` varchar(1000) DEFAULT NULL,
  `Mensagem` varchar(150) DEFAULT NULL,
  `Mensagem_sonora` varchar(1024) DEFAULT NULL,
  `Vibrar` tinyint(1) NOT NULL,
  `Regiao` int(11) DEFAULT NULL,
  `Criado_por` int(11) NOT NULL,
  `Criado_em` datetime NOT NULL,
  `Modificado_por` int(11) NOT NULL,
  `Modificado_em` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Beacons_1_idx` (`Regiao`),
  KEY `fk_Beacons_2_idx` (`Criado_por`),
  KEY `fk_Beacons_3_idx` (`Modificado_por`),
  CONSTRAINT `fk_Beacons_1` FOREIGN KEY (`Regiao`) REFERENCES `Regiao` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Beacons_2` FOREIGN KEY (`Criado_por`) REFERENCES `Usuario` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Beacons_3` FOREIGN KEY (`Modificado_por`) REFERENCES `Usuario` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Regiao`
--

DROP TABLE IF EXISTS `Regiao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Regiao` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ativo` tinyint(1) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Descricao` varchar(250) DEFAULT NULL,
  `Criado_por` int(11) NOT NULL,
  `Criado_em` datetime NOT NULL,
  `Modificado_por` int(11) NOT NULL,
  `Modificado_em` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Regioes_1_idx` (`Criado_por`),
  KEY `fk_Regioes_2_idx` (`Modificado_por`),
  CONSTRAINT `fk_Regioes_1` FOREIGN KEY (`Criado_por`) REFERENCES `Usuario` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Regioes_2` FOREIGN KEY (`Modificado_por`) REFERENCES `Usuario` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Tipo_Usuario`
--

DROP TABLE IF EXISTS `Tipo_Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tipo_Usuario` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `ME_GUIA`.`Tipo_Usuario` (`ID`, `Nome`) VALUES (0, 'Administrador');
INSERT INTO `ME_GUIA`.`Tipo_Usuario` (`ID`, `Nome`) VALUES (1, 'Comum');

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ativo` tinyint(1) NOT NULL,
  `Nome` varchar(150) NOT NULL,
  `Login` varchar(45) NOT NULL,
  `Senha` char(64) NOT NULL,
  `Tipo` int(11) NOT NULL,
  `Criado_por` int(11) NOT NULL,
  `Criado_em` datetime NOT NULL,
  `Modificado_por` int(11) NOT NULL,
  `Modificado_em` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Login_UNIQUE` (`Login`),
  KEY `fk_Usuarios_1_idx` (`Tipo`),
  KEY `fk_Usuarios_2_idx` (`Criado_por`),
  KEY `fk_Usuarios_3_idx` (`Modificado_por`),
  CONSTRAINT `fk_Usuario_1` FOREIGN KEY (`Tipo`) REFERENCES `Tipo_Usuario` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

INSERT INTO `ME_GUIA`.`Usuario` (`ID`, `Ativo`, `Nome`, `Login`, `Senha`, `Tipo`, `Criado_por`, `Criado_em`, `Modificado_por`, `Modificado_em`) VALUES (1, 1, 'Admin', 'admin', 'cdb996f94aa8ec758b7e107b8a5d843c251d2461d78a401a06f4b8d207817890', 0, 1, '2016-10-01 00:00:00', 1, '2016-10-01 00:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-23 20:25:47
