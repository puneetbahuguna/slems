CREATE DATABASE  IF NOT EXISTS `slems` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `slems`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: slems
-- ------------------------------------------------------
-- Server version	5.6.48-log

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `DEPARTMENT_ID` bigint(10) NOT NULL AUTO_INCREMENT,
  `DEPARTMENT_NM` varchar(25) NOT NULL,
  PRIMARY KEY (`DEPARTMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Admin');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `EMPID` bigint(10) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(45) DEFAULT NULL,
  `LASTNAME` varchar(45) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `DEPARTMENT_ID` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`EMPID`),
  KEY `DEPARTMENT_ID_idx` (`DEPARTMENT_ID`),
  CONSTRAINT `DEPARTMENT_ID` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `department` (`DEPARTMENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1000,'Admin','User','1991-07-26','puneetbahuguna@gmail.com',1);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `login_master`
--

DROP TABLE IF EXISTS `login_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_master` (
  `USERID` int(11) NOT NULL,
  `PASSWORD` varchar(30) NOT NULL,
  `ROLE` varchar(20) NOT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_master`
--

LOCK TABLES `login_master` WRITE;
/*!40000 ALTER TABLE `login_master` DISABLE KEYS */;
INSERT INTO `login_master` VALUES (1000,'YWRtaW4=','admin');
/*!40000 ALTER TABLE `login_master` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `compliance`
--

DROP TABLE IF EXISTS `compliance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compliance` (
  `COMPLIANCEID` bigint(10) NOT NULL AUTO_INCREMENT,
  `RLTYPE` varchar(15) DEFAULT NULL,
  `DETAILS` varchar(250) DEFAULT NULL,
  `CREATEDDATE` date DEFAULT NULL,
  `DEPARTMENT_ID` bigint(10) NOT NULL,
  `STATUS` varchar(15) NOT NULL,
  PRIMARY KEY (`COMPLIANCEID`),
  KEY `DEPARTMENT_ID_idx` (`DEPARTMENT_ID`),
  CONSTRAINT `DEPARTMENT_IDF` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `department` (`DEPARTMENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;




--
-- Table structure for table `statusreport`
--

DROP TABLE IF EXISTS `statusreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statusreport` (
  `COMPLIANCEID` bigint(10) NOT NULL,
  `STATUSRPTID` bigint(10) NOT NULL AUTO_INCREMENT,
  `EMPID` bigint(10) DEFAULT NULL,
  `COMMENTS` varchar(15) DEFAULT NULL,
  `CREATEDDATE` date DEFAULT NULL,
  `DEPARTMENT_ID` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`STATUSRPTID`),
  KEY `COMPLIANCEID_idx` (`COMPLIANCEID`),
  KEY `EMPID_idx` (`EMPID`),
  KEY `DEPARTMENT_IDF2_idx` (`DEPARTMENT_ID`),
  CONSTRAINT `COMPLIANCEID` FOREIGN KEY (`COMPLIANCEID`) REFERENCES `compliance` (`COMPLIANCEID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DEPARTMENT_IDF2` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `department` (`DEPARTMENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `EMPID` FOREIGN KEY (`EMPID`) REFERENCES `employees` (`EMPID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


-- Dump completed on 2020-12-11 12:17:31
