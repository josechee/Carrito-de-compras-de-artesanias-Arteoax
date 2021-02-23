CREATE DATABASE  IF NOT EXISTS `bd_carrito` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_carrito`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_carrito
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `tbl_producto`
--

DROP TABLE IF EXISTS `tbl_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_producto` (
  `ID_Producto` varchar(36) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Region` varchar(45) NOT NULL,
  `Costo` double NOT NULL,
  `Existencia` int(11) NOT NULL,
  PRIMARY KEY (`ID_Producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_producto`
--

LOCK TABLES `tbl_producto` WRITE;
/*!40000 ALTER TABLE `tbl_producto` DISABLE KEYS */;
INSERT INTO `tbl_producto` VALUES ('058b0970-1f62-11e9-a506-28d244202eee','Olla de barro negro','Las piezas se hacen a mano por artesanos que utilizan técnicas tradicionales.','PAPALOAPAN',300,150),('4e2d65be-1f63-11e9-a506-28d244202eee','miniaturas de plomo','confección de miniaturas de plomo para integrar una juguetería en la que desfilan soldaditos, etc.','MIXTECA',80,30),('551aa443-1f62-11e9-a506-28d244202eee','alebrije de gran tamanio','Los alebrijes son elaborados tradicionalmente en San Antonio Arrazola y San Martín Tilcajete. ','COSTA',350,20),('5711654f-1e6d-11e9-bdc7-28d244202eee','Canasta','Es utilizado todavia en los pueblos para lavar maiz','PAPALOAPAN',150,100),('5a822b6b-2101-11e9-8124-28d244202eee','olla de barro','olla hecho de barro ','VALLES CENTRALES',150,50),('65bcabbb-2101-11e9-8124-28d244202eee','prueba','prueba','CANIADA',12,1),('7a5f1769-1fd5-11e9-a506-28d244202eee','mezcal','bebida tradicional de la  Sieera Norte De Oaxaca','SIERRA NORTE',200,80),('8c639645-1fc5-11e9-a506-28d244202eee','huipil','traje epica del grupo etnico Chinanteco','PAPALOAPAN',680,100),('94a0932c-2101-11e9-8124-28d244202eee','prueba','prueba','CANIADA',12,1),('cb80289a-1f62-11e9-a506-28d244202eee','vajilla de barro verde','Esta se caracteriza por sus diseños elaborados con la técnica de pastillaje y calado. ','VALLES CENTRALES',120,20),('eedb3927-20f7-11e9-8124-28d244202eee','molcajete','utencillo tipico para hacer salsa, tradicional de la region','COSTA',180,20);
/*!40000 ALTER TABLE `tbl_producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-25 19:35:01
