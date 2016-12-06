-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: knowledgebasedsystem
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `namebook` varchar(45) NOT NULL,
  `typeofbook` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `timeneed` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `levelbook_idx` (`level`),
  CONSTRAINT `levelbook` FOREIGN KEY (`level`) REFERENCES `level` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Ngữ pháp tiếng anh 1',1,1,80),(2,'Ngữ pháp tiếng anh 1',1,2,80),(3,'Ngữ pháp tiếng anh 1',1,3,150),(4,'Ngữ pháp tiếng anh 1',1,4,150),(5,'Ngữ pháp tiếng anh 1',1,5,150),(6,'Ngữ pháp tiếng anh 6',1,1,150),(7,'Từ vựng tiếng anh 1',2,2,80),(8,'Từ vựng tiếng anh 2',2,3,80),(9,'Từ vựng tiếng anh 3',2,4,150),(10,'Từ vựng tiếng anh 4',2,5,150),(11,'Từ vựng tiếng anh 5',2,1,150),(12,'Từ vựng tiếng anh 6',2,2,100),(13,'Economy 1',3,3,170),(14,'Economy 2',3,4,170),(15,'Economy 3',3,5,170),(16,'Economy 4',3,1,180),(17,'Economy 5',3,2,220),(18,'Economy 6',3,3,220),(19,'Jim toeic 1',4,4,80),(20,'Jim toeic 2',4,5,80),(21,'Jim toeic 3',4,5,150),(22,'Jim toeic 4',4,5,170),(23,'Jim toeic 5',4,5,170),(24,'Jim toeic 6',4,5,170);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level`
--

DROP TABLE IF EXISTS `level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `namelevel` varchar(45) NOT NULL,
  `scorediscription` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level`
--

LOCK TABLES `level` WRITE;
/*!40000 ALTER TABLE `level` DISABLE KEYS */;
INSERT INTO `level` VALUES (1,'level 0','0'),(2,'level 1','350+-20'),(3,'level 2','450+-20'),(4,'level 3','600+-20'),(5,'level 4','700+-20'),(6,'level 5','800+-20'),(7,'level 6','900+-20'),(8,'level reading 0','beginner'),(9,'level reading 1','175'),(10,'level reading 2','225'),(11,'level reading 3','300'),(12,'level reading 4','350'),(13,'level reading 5','400'),(14,'level reading 6','450'),(15,'level listening 0','beginer'),(16,'level listening 1','175'),(17,'level listening 2','225'),(18,'level listening 3','300'),(19,'level listening 4','350'),(20,'level listening 5','400'),(21,'level listening 6','450');
/*!40000 ALTER TABLE `level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rule` (
  `idrule` int(11) NOT NULL AUTO_INCREMENT,
  `current_level` int(11) DEFAULT NULL,
  `goal_level` int(11) DEFAULT NULL,
  `book_need` int(11) DEFAULT NULL,
  PRIMARY KEY (`idrule`),
  KEY `fr_currentlevel_idx` (`current_level`),
  KEY `fr_goallevel_idx` (`goal_level`),
  KEY `fr_bookneed_idx` (`book_need`),
  CONSTRAINT `fr_bookneed` FOREIGN KEY (`book_need`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fr_currentlevel` FOREIGN KEY (`current_level`) REFERENCES `level` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fr_goallevel` FOREIGN KEY (`goal_level`) REFERENCES `level` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (1,8,9,1),(2,8,9,7),(3,9,10,2),(4,9,10,8),(5,10,11,3),(6,10,11,9),(7,11,12,4),(8,11,12,10),(9,12,13,5),(10,12,13,11),(11,13,14,6),(12,13,14,12),(13,14,NULL,NULL),(14,15,16,19),(15,16,17,20),(16,17,18,21),(17,18,19,22),(18,19,20,23),(19,20,21,24),(20,21,NULL,NULL),(21,1,2,13),(22,2,3,14),(23,3,4,15),(24,4,5,16),(25,5,6,17),(26,6,7,18),(27,7,NULL,NULL);
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule_create_level`
--

DROP TABLE IF EXISTS `rule_create_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rule_create_level` (
  `idrule` int(11) NOT NULL AUTO_INCREMENT,
  `min_score` int(11) DEFAULT NULL,
  `max_score` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `explain` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrule`),
  KEY `fr_level_rule_idx` (`level`),
  CONSTRAINT `fr_level_rule` FOREIGN KEY (`level`) REFERENCES `level` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule_create_level`
--

LOCK TABLES `rule_create_level` WRITE;
/*!40000 ALTER TABLE `rule_create_level` DISABLE KEYS */;
INSERT INTO `rule_create_level` VALUES (1,0,330,1,'level dành cho tổng điểm'),(2,330,430,2,'level dành cho tổng điểm'),(3,430,580,3,'level dành cho tổng điểm'),(4,580,680,4,'level dành cho tổng điểm'),(5,680,780,5,'level dành cho tổng điểm'),(6,780,880,6,'level dành cho tổng điểm'),(7,880,900,7,'level dành cho tổng điểm'),(8,0,175,8,'level dành cho reading'),(9,175,225,9,'level dành cho reading'),(10,225,300,10,'level dành cho reading'),(11,300,350,11,'level dành cho reading'),(12,350,400,12,'level dành cho reading'),(13,400,450,13,'level dành cho reading'),(14,450,495,14,'level dành cho reading'),(15,0,175,15,'level dành cho listening'),(16,175,225,16,'level dành cho listening'),(17,225,300,17,'level dành cho listening'),(18,300,350,18,'level dành cho listening'),(19,350,400,19,'level dành cho listening'),(20,400,450,20,'level dành cho listening'),(21,450,495,21,'level dành cho listening');
/*!40000 ALTER TABLE `rule_create_level` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-06 14:23:50
