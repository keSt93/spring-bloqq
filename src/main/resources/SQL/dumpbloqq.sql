-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: bloqq
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.17.10.1

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
-- Table structure for table `bloqq_post`
--

DROP TABLE IF EXISTS `bloqq_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bloqq_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titel` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `content` mediumtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `BloqqPost_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloqq_post`
--

LOCK TABLES `bloqq_post` WRITE;
/*!40000 ALTER TABLE `bloqq_post` DISABLE KEYS */;
INSERT INTO `bloqq_post` VALUES (1,'Bespiel','2018-02-19 09:01:25','2018-02-21 09:01:35','BOIBOIBOBIBOIBOIBOBIBI'),(2,'Noch ein Bsp','2018-03-14 11:27:04','2018-03-14 11:27:08','BEISPIELCONTENT');
/*!40000 ALTER TABLE `bloqq_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kommentar`
--

DROP TABLE IF EXISTS `kommentar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kommentar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kommentar` mediumtext,
  `userId` int(11) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `bloqq_postId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `kommentar_user_id_fk` (`userId`),
  KEY `kommentar_bloqq_post_id_fk` (`bloqq_postId`),
  CONSTRAINT `kommentar_bloqq_post_id_fk` FOREIGN KEY (`bloqq_postId`) REFERENCES `bloqq_post` (`id`),
  CONSTRAINT `kommentar_user_id_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kommentar`
--

LOCK TABLES `kommentar` WRITE;
/*!40000 ALTER TABLE `kommentar` DISABLE KEYS */;
/*!40000 ALTER TABLE `kommentar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `creation_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `table_name_userName_uindex` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (22,'beispiel','0a386edc641e05a6232eb4eedbfd8da764cdb43349c03bdd9c9949e4fb2efe3968dea46b3bcc2309bc14a22c3859ab030de00b7eb6a8674b38154a912a86d08a','2018-03-19 16:54:22'),(23,'ass','25aaab7b63dfdb34e899ca0d7c7dbe249686143b798e7d416027226c14d140931a4003a54e0ec8fbbc3a75ccf689ad22ad82af2331bbdef7dda39e80b2089326','2018-03-21 08:48:17');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-21  8:52:24
