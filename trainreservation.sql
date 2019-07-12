-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: trainreservation
-- ------------------------------------------------------
-- Server version	5.6.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classinformation`
--

DROP TABLE IF EXISTS `classinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classinformation` (
  `classname` varchar(45) NOT NULL,
  `availability` int(11) DEFAULT NULL,
  `totalseats` int(11) DEFAULT NULL,
  PRIMARY KEY (`classname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classinformation`
--

LOCK TABLES `classinformation` WRITE;
/*!40000 ALTER TABLE `classinformation` DISABLE KEYS */;
INSERT INTO `classinformation` VALUES ('general',10,10),('secondtier',5,5),('sleeper',10,10),('thirdtier',10,10);
/*!40000 ALTER TABLE `classinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `login` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (11,'hasheth','2GTIpN+jTfIDbikgwHeqz7eAJaCiu2bl','harshitsheth298@gmail.com','9903106446','harshit'),(12,'hasheth1','87IjWgvLOLiaS9rLF1pz9j4YzjlAyNau','sbc@abc.xe','9111111111','hfdfsue');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentinfo`
--

DROP TABLE IF EXISTS `paymentinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `paymentinfo` (
  `paymentid` int(11) NOT NULL AUTO_INCREMENT,
  `cardholdername` varchar(45) DEFAULT NULL,
  `paymentamount` int(11) DEFAULT NULL,
  PRIMARY KEY (`paymentid`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentinfo`
--

LOCK TABLES `paymentinfo` WRITE;
/*!40000 ALTER TABLE `paymentinfo` DISABLE KEYS */;
INSERT INTO `paymentinfo` VALUES (39,'asdfghjkl',0),(40,'asdfg',100),(41,'asdfghj',1000),(42,'sdfghj',1000),(43,'gfhj',1000),(44,'sdfghj',1000),(45,'dfgh',100),(46,'sgd',100),(47,'wefg',500),(48,'fgh',500),(49,'jsdjh',1000),(50,'Harshit',1000),(51,'dtrf',1000);
/*!40000 ALTER TABLE `paymentinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservationdetails`
--

DROP TABLE IF EXISTS `reservationdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reservationdetails` (
  `pnr` varchar(45) NOT NULL,
  `seatnumber` varchar(45) DEFAULT NULL,
  `passengername` varchar(45) DEFAULT NULL,
  `passengerage` varchar(45) DEFAULT NULL,
  `classname` varchar(45) DEFAULT NULL,
  `coach` varchar(45) DEFAULT NULL,
  `fare` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pnr`),
  KEY `Class` (`classname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservationdetails`
--

LOCK TABLES `reservationdetails` WRITE;
/*!40000 ALTER TABLE `reservationdetails` DISABLE KEYS */;
INSERT INTO `reservationdetails` VALUES ('1','1',NULL,NULL,'secondtier','a1','2000'),('10','5',NULL,NULL,'thirdtier','b1','1000'),('11','1',NULL,NULL,'thirdtier','b2','1000'),('12','2',NULL,NULL,'thirdtier','b2','1000'),('13','3',NULL,NULL,'thirdtier','b2','1000'),('14','4',NULL,NULL,'thirdtier','b2','1000'),('15','5',NULL,NULL,'thirdtier','b2','1000'),('16','1',NULL,NULL,'general','g1','100'),('17','2',NULL,NULL,'general','g1','100'),('18','3',NULL,NULL,'general','g1','100'),('19','4',NULL,NULL,'general','g1','100'),('2','2',NULL,NULL,'secondtier','a1','2000'),('20','5',NULL,NULL,'general','g1','100'),('21','1',NULL,NULL,'general','g2','100'),('22','2',NULL,NULL,'general','g2','100'),('23','3',NULL,NULL,'general','g2','100'),('24','4',NULL,NULL,'general','g2','100'),('25','5',NULL,NULL,'general','g2','100'),('26','1',NULL,NULL,'sleeper','s1','500'),('27','2',NULL,NULL,'sleeper','s1','500'),('28','3',NULL,NULL,'sleeper','s1','500'),('29','4',NULL,NULL,'sleeper','s1','500'),('3','3',NULL,NULL,'secondtier','a1','500'),('30','5',NULL,NULL,'sleeper','s1','500'),('31','1',NULL,NULL,'sleeper','s2','500'),('32','2',NULL,NULL,'sleeper','s2','500'),('33','3',NULL,NULL,'sleeper','s2','500'),('34','4',NULL,NULL,'sleeper','s2','500'),('35','5',NULL,NULL,'sleeper','s2','500'),('4','4',NULL,NULL,'secondtier','a1','2000'),('5','5',NULL,NULL,'secondtier','a1','2000'),('6','6',NULL,NULL,'thirdtier','b1','1000'),('7','2',NULL,NULL,'thirdtier','b1','1000'),('8','3',NULL,NULL,'thirdtier','b1','1000'),('9','4',NULL,NULL,'thirdtier','b1','1000');
/*!40000 ALTER TABLE `reservationdetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-03 17:42:29
