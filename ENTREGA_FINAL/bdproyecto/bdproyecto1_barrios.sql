-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdproyecto1
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `barrios`
--

DROP TABLE IF EXISTS `barrios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barrios` (
  `id_barrio` bigint NOT NULL AUTO_INCREMENT,
  `nombre_barrio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_barrio`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barrios`
--

LOCK TABLES `barrios` WRITE;
/*!40000 ALTER TABLE `barrios` DISABLE KEYS */;
INSERT INTO `barrios` VALUES (1,'Getsemaní'),(2,'San Diego'),(3,'La Matuna'),(4,'Centro'),(5,'Crespo'),(6,'Marbella'),(7,'La Boquilla'),(8,'Cielo Mar'),(9,'El Bosque'),(10,'Ternera'),(11,'Nuevo Bosque'),(12,'San Fernando'),(13,'Los Alpes'),(14,'La Castellana'),(15,'Olaya Herrera\n'),(16,'13 de Junio'),(17,'Fredonia'),(18,'El Socorro'),(19,'Mamonal'),(20,'Pasacaballos'),(21,'Barrio Bosque'),(22,'Albornoz'),(23,'Policarpa'),(24,'Zaragocilla'),(25,'El Campestre'),(26,'El Pozón'),(27,'La María'),(28,'Los Caracoles'),(29,'El Carmelo'),(30,'San José de los Campanos'),(31,'Manzanillo del Mar'),(32,'Barcelona de Indias'),(33,'Serena del Mar'),(34,'La Carolina'),(35,'Villa Estrella'),(36,'La Esperanza'),(37,'Villa Rosita'),(38,'Isla de Barú'),(39,'Bocagrande'),(40,'Castillogrande'),(41,'El Laguito'),(42,'Olaya Herrera'),(43,'San Francisco'),(44,'La Esperanza'),(45,'Chiquinquirá'),(46,'El Prado'),(47,'El Campestre'),(48,'Villa Estrella'),(49,'Loma Fresca'),(50,'Blas de Lezo'),(51,'Nelson Mandela'),(52,'Ciudadela 2000'),(53,'Villa Hermosa'),(54,'Colombiatón'),(55,'Los Jardines'),(56,'Bicentenario'),(57,'Villas de Aranjuez'),(58,'Santa Lucíaz');
/*!40000 ALTER TABLE `barrios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-13 21:39:51
