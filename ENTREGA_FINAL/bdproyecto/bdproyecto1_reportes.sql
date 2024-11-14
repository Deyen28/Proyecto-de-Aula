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
-- Table structure for table `reportes`
--

DROP TABLE IF EXISTS `reportes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reportes` (
  `id_reportes` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `barrio_id` bigint DEFAULT NULL,
  `contaminante_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `evidencia` varchar(255) DEFAULT NULL,
  `fecha_reporte` date DEFAULT NULL,
  PRIMARY KEY (`id_reportes`),
  KEY `FK4lu17mmrdskenh7lnvmjjnefr` (`barrio_id`),
  KEY `FKip149frgr8dqft4pdu9cdcpkp` (`contaminante_id`),
  KEY `FKrmdft9pm9q0vp1gs14jmdjsre` (`user_id`),
  CONSTRAINT `FK4lu17mmrdskenh7lnvmjjnefr` FOREIGN KEY (`barrio_id`) REFERENCES `barrios` (`id_barrio`),
  CONSTRAINT `FKip149frgr8dqft4pdu9cdcpkp` FOREIGN KEY (`contaminante_id`) REFERENCES `contaminante` (`id_contaminante`),
  CONSTRAINT `FKrmdft9pm9q0vp1gs14jmdjsre` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportes`
--

LOCK TABLES `reportes` WRITE;
/*!40000 ALTER TABLE `reportes` DISABLE KEYS */;
INSERT INTO `reportes` VALUES (3,'Un edificio no deja ver bien el centro historico.','centro carrera 10 calle 2',4,9,1,'fd5cf651-2fed-4bd6-9903-8be7f470e779_evidencia1.jpg','2024-11-10'),(4,'pepe was here','tu casa',7,7,9,'c857ab16-03be-4d77-a274-fb91bd87e1e0_evidencia1.jpg','2024-11-10'),(6,'grandes cantidades de basura en la esquina de la tienda ElMejor','centro carrera 3 calle 11',4,2,10,'7450c448-05ca-43ef-aa84-130709e5424e_evidencia4.jpg','2024-11-10'),(7,'residuos liquidos serca de la torre del reloj estan probocando malos olores','centro carrera 10 calle 4',4,3,10,'d7eb8a76-bea9-402e-b720-90083dbb3a4f_evidencia5.jpg','2024-11-10'),(9,'mucha basura','una callebonita',7,2,1,'293b6d24-a0cf-4c2a-a820-620cb52b5018_evidencia2.jpeg','2024-11-10'),(15,'La basura esta probocando mal olor','carrera 1 ',26,2,1,'evidencia3.jpg','2024-11-09');
/*!40000 ALTER TABLE `reportes` ENABLE KEYS */;
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
