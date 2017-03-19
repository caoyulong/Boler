DROP DATABASE IF EXISTS `boler`;
CREATE DATABASE `boler` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `boler`;
-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: boler
-- ------------------------------------------------------
-- Server version	5.7.17-0ubuntu0.16.04.1

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
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employ` int(11) NOT NULL,
  `employee` int(11) NOT NULL,
  `state` tinyint(4) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_APP_EMPLOYEE_idx` (`employee`),
  KEY `FK_APP_EMPLOY_idx` (`employ`),
  KEY `index4` (`state`),
  CONSTRAINT `FK_APP_EMPLOY` FOREIGN KEY (`employ`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_APP_EMPLOYEE` FOREIGN KEY (`employee`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_exp`
--

DROP TABLE IF EXISTS `education_exp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education_exp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `school` varchar(64) NOT NULL,
  `degree` tinyint(4) NOT NULL DEFAULT '0',
  `major` varchar(32) NOT NULL,
  `course` varchar(64) DEFAULT NULL,
  `resume` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_EE_RESUME_idx` (`resume`),
  KEY `IDX_MAJOR` (`major`),
  KEY `IDX_DEGREE` (`degree`),
  CONSTRAINT `FK_EE_RESUME` FOREIGN KEY (`resume`) REFERENCES `online_resume` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_exp`
--

LOCK TABLES `education_exp` WRITE;
/*!40000 ALTER TABLE `education_exp` DISABLE KEYS */;
/*!40000 ALTER TABLE `education_exp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `from` varchar(64) NOT NULL,
  `to` varchar(64) NOT NULL,
  `subject` varchar(64) NOT NULL,
  `text` varchar(2048) NOT NULL,
  `send_time` datetime NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_EMAIL_FROM_idx` (`from`),
  KEY `IDX_EMAIL_USER` (`user`),
  CONSTRAINT `FK_EMAIL_EMAILADDRESS` FOREIGN KEY (`from`) REFERENCES `user` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_EMAIL_USERID` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_type`
--

DROP TABLE IF EXISTS `job_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_type` (
  `id` int(11) NOT NULL,
  `type` varchar(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_type`
--

LOCK TABLES `job_type` WRITE;
/*!40000 ALTER TABLE `job_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `online_resume`
--

DROP TABLE IF EXISTS `online_resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `online_resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `person_info` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_OR_PERSONINFO_idx` (`person_info`),
  KEY `FK_OR_USER_idx` (`user`),
  CONSTRAINT `FK_OR_PERSONINFO` FOREIGN KEY (`person_info`) REFERENCES `person_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_OR_USER` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `online_resume`
--

LOCK TABLES `online_resume` WRITE;
/*!40000 ALTER TABLE `online_resume` DISABLE KEYS */;
/*!40000 ALTER TABLE `online_resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_info`
--

DROP TABLE IF EXISTS `person_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `realname` varchar(8) NOT NULL,
  `sex` enum('M','F') NOT NULL,
  `birthday` date NOT NULL,
  `cellphone` varchar(11) NOT NULL,
  `profile` varchar(128) DEFAULT NULL,
  `avatar` varchar(64) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `iIDX_PERINFO_PHONE` (`cellphone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_info`
--

LOCK TABLES `person_info` WRITE;
/*!40000 ALTER TABLE `person_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_exp`
--

DROP TABLE IF EXISTS `project_exp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_exp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `team_scale` varchar(16) DEFAULT NULL,
  `role` varchar(8) NOT NULL,
  `project_introduction` varchar(64) NOT NULL,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `detail` varchar(256) NOT NULL,
  `resume` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_PE_RESUME_idx` (`resume`),
  CONSTRAINT `FK_PE_RESUME` FOREIGN KEY (`resume`) REFERENCES `online_resume` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_exp`
--

LOCK TABLES `project_exp` WRITE;
/*!40000 ALTER TABLE `project_exp` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_exp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruitment`
--

DROP TABLE IF EXISTS `recruitment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruitment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `corporation` varchar(32) NOT NULL,
  `job_name` varchar(16) NOT NULL,
  `job_type` int(11) NOT NULL,
  `low_salary` int(11) NOT NULL,
  `high_salary` int(11) NOT NULL,
  `address` varchar(32) NOT NULL,
  `industry` varchar(32) NOT NULL,
  `job_detail` varchar(128) NOT NULL,
  `requirement` varchar(128) NOT NULL,
  `user` int(11) NOT NULL,
  `state` tinyint(4) NOT NULL DEFAULT '0',
  `expire_date` date NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_REQ_USER_idx` (`user`),
  KEY `IDX_REQ_JOBNAME` (`job_name`),
  KEY `IDX_REQ_JOBTYPE` (`job_type`),
  KEY `IDX_REQ_STATE` (`state`),
  CONSTRAINT `FK_REQ_JOBTYPE` FOREIGN KEY (`job_type`) REFERENCES `job_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_REQ_USER` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruitment`
--

LOCK TABLES `recruitment` WRITE;
/*!40000 ALTER TABLE `recruitment` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruitment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume_skill`
--

DROP TABLE IF EXISTS `resume_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resume_skill` (
  `resume` int(11) NOT NULL,
  `skill` int(11) NOT NULL,
  PRIMARY KEY (`resume`,`skill`),
  KEY `FK_RS_SKILL_idx` (`skill`),
  CONSTRAINT `FK_RS_RESUME` FOREIGN KEY (`resume`) REFERENCES `online_resume` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_RS_SKILL` FOREIGN KEY (`skill`) REFERENCES `skill` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume_skill`
--

LOCK TABLES `resume_skill` WRITE;
/*!40000 ALTER TABLE `resume_skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `resume_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'employ'),(2,'employee');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(64) NOT NULL,
  `password` char(32) NOT NULL,
  `role` int(11) NOT NULL,
  `person_info` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `FK_USER_PERSON_INFO_idx` (`person_info`),
  KEY `FK_USER_ROLE_idx` (`role`),
  CONSTRAINT `FK_USER_PERSON_INFO` FOREIGN KEY (`person_info`) REFERENCES `person_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USER_ROLE` FOREIGN KEY (`role`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_log`
--

DROP TABLE IF EXISTS `user_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `ip_address` varchar(15) NOT NULL,
  `record_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `IDX_UL_USER` (`user`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_log`
--

LOCK TABLES `user_log` WRITE;
/*!40000 ALTER TABLE `user_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_exp`
--

DROP TABLE IF EXISTS `work_exp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_exp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `corporation` varchar(64) NOT NULL,
  `scale` varchar(16) DEFAULT NULL,
  `department` varchar(16) NOT NULL,
  `job` varchar(16) NOT NULL,
  `detail` varchar(256) NOT NULL,
  `resume` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_WE_RESUME_idx` (`resume`),
  CONSTRAINT `FK_WE_RESUME` FOREIGN KEY (`resume`) REFERENCES `online_resume` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_exp`
--

LOCK TABLES `work_exp` WRITE;
/*!40000 ALTER TABLE `work_exp` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_exp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-15  0:30:16
