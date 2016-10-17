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
  `Endereco_MAC` char(12) NOT NULL,
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
  CONSTRAINT `fk_Beacons_2` FOREIGN KEY (`Criado_por`) REFERENCES `Cadastradores` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Beacons_3` FOREIGN KEY (`Modificado_por`) REFERENCES `Cadastradores` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Beacon`
--

LOCK TABLES `Beacon` WRITE;
/*!40000 ALTER TABLE `Beacon` DISABLE KEYS */;
/*!40000 ALTER TABLE `Beacon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Beacon_Tag`
--

DROP TABLE IF EXISTS `Beacon_Tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Beacon_Tag` (
  `Beacon_id` int(11) NOT NULL,
  `Tag_id` int(11) NOT NULL,
  PRIMARY KEY (`Beacon_id`,`Tag_id`),
  KEY `fk_Beacon_Tag_2_idx` (`Tag_id`),
  CONSTRAINT `fk_Beacon_Tag_1` FOREIGN KEY (`Beacon_id`) REFERENCES `Beacon` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Beacon_Tag_2` FOREIGN KEY (`Tag_id`) REFERENCES `Tag` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Beacon_Tag`
--

LOCK TABLES `Beacon_Tag` WRITE;
/*!40000 ALTER TABLE `Beacon_Tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `Beacon_Tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estatistica_SUM_Dia`
--

DROP TABLE IF EXISTS `Estatistica_SUM_Dia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estatistica_SUM_Dia` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Beacon_id` int(11) NOT NULL,
  `Dia` int(11) NOT NULL,
  `Mes` int(11) NOT NULL,
  `Ano` int(11) NOT NULL,
  `Total_Registros` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Estatisticas_SUM_Dia_1_idx` (`Beacon_id`),
  CONSTRAINT `fk_Estatisticas_SUM_Dia_1` FOREIGN KEY (`Beacon_id`) REFERENCES `Beacon` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estatistica_SUM_Dia`
--

LOCK TABLES `Estatistica_SUM_Dia` WRITE;
/*!40000 ALTER TABLE `Estatistica_SUM_Dia` DISABLE KEYS */;
/*!40000 ALTER TABLE `Estatistica_SUM_Dia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estatistica_SUM_Hora`
--

DROP TABLE IF EXISTS `Estatistica_SUM_Hora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estatistica_SUM_Hora` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Beacon_id` int(11) NOT NULL,
  `Dia` int(11) NOT NULL,
  `Mes` int(11) NOT NULL,
  `Ano` int(11) NOT NULL,
  `Hora` int(11) NOT NULL,
  `Total_Registros` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Estatisticas_SUM_Hora_1_idx` (`Beacon_id`),
  CONSTRAINT `fk_Estatisticas_SUM_Hora_1` FOREIGN KEY (`Beacon_id`) REFERENCES `Beacon` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estatistica_SUM_Hora`
--

LOCK TABLES `Estatistica_SUM_Hora` WRITE;
/*!40000 ALTER TABLE `Estatistica_SUM_Hora` DISABLE KEYS */;
/*!40000 ALTER TABLE `Estatistica_SUM_Hora` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `fk_Regioes_1` FOREIGN KEY (`Criado_por`) REFERENCES `Cadastradores` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Regioes_2` FOREIGN KEY (`Modificado_por`) REFERENCES `Cadastradores` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Regiao`
--

LOCK TABLES `Regiao` WRITE;
/*!40000 ALTER TABLE `Regiao` DISABLE KEYS */;
/*!40000 ALTER TABLE `Regiao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Registro_Identificacao`
--

DROP TABLE IF EXISTS `Registro_Identificacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Registro_Identificacao` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Beacon` int(11) NOT NULL,
  `Timestamp_Millis` bigint(20) NOT NULL,
  `ID_Estatisticas_SUM_Dia` int(11) DEFAULT NULL,
  `ID_Estatisticas_SUM_Hora` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_new_table_1_idx` (`ID_Beacon`),
  KEY `fk_Registro_Identificacao_2_idx` (`ID_Estatisticas_SUM_Dia`),
  KEY `fk_Registro_Identificacao_3_idx` (`ID_Estatisticas_SUM_Hora`),
  CONSTRAINT `fk_Registro_Identificacao_1` FOREIGN KEY (`ID_Beacon`) REFERENCES `Beacon` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Registro_Identificacao_2` FOREIGN KEY (`ID_Estatisticas_SUM_Dia`) REFERENCES `Estatistica_SUM_Dia` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Registro_Identificacao_3` FOREIGN KEY (`ID_Estatisticas_SUM_Hora`) REFERENCES `Estatistica_SUM_Hora` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Registro_Identificacao`
--

LOCK TABLES `Registro_Identificacao` WRITE;
/*!40000 ALTER TABLE `Registro_Identificacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `Registro_Identificacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tag`
--

DROP TABLE IF EXISTS `Tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tag` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ativo` tinyint(1) NOT NULL,
  `Nome` varchar(25) NOT NULL,
  `Criado_por` int(11) NOT NULL,
  `Criado_em` datetime NOT NULL,
  `Modificado_por` int(11) NOT NULL,
  `Modificado_em` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Tags_1_idx` (`Criado_por`),
  KEY `fk_Tags_2_idx` (`Modificado_por`),
  CONSTRAINT `fk_Tags_1` FOREIGN KEY (`Criado_por`) REFERENCES `Cadastradores` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tags_2` FOREIGN KEY (`Modificado_por`) REFERENCES `Cadastradores` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tag`
--

LOCK TABLES `Tag` WRITE;
/*!40000 ALTER TABLE `Tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tag` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Dumping data for table `Tipo_Usuario`
--

LOCK TABLES `Tipo_Usuario` WRITE;
/*!40000 ALTER TABLE `Tipo_Usuario` DISABLE KEYS */;
INSERT INTO `Tipo_Usuario` VALUES (0,'Administrador'),(1,'Comum');
/*!40000 ALTER TABLE `Tipo_Usuario` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `fk_Usuarios_3_idx` (`Modificado_por`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,1,'Admin','admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918',0,1,'0000-00-00 00:00:00',1,'0000-00-00 00:00:00');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-17 19:28:18
