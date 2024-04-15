-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: worker
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_account`
--

DROP TABLE IF EXISTS `admin_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_account` (
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`account`),
  UNIQUE KEY `Admin_account_account_uindex` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_account`
--

LOCK TABLES `admin_account` WRITE;
/*!40000 ALTER TABLE `admin_account` DISABLE KEYS */;
INSERT INTO `admin_account` VALUES ('12','1'),('12151','ga215'),('12345','31151'),('512451','51121');
/*!40000 ALTER TABLE `admin_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_account`
--

DROP TABLE IF EXISTS `staff_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_account` (
  `Staff_ID` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`Staff_ID`),
  UNIQUE KEY `staff_account_account_uindex` (`Staff_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_account`
--

LOCK TABLES `staff_account` WRITE;
/*!40000 ALTER TABLE `staff_account` DISABLE KEYS */;
INSERT INTO `staff_account` VALUES ('12','123');
/*!40000 ALTER TABLE `staff_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_inf`
--

DROP TABLE IF EXISTS `staff_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_inf` (
  `Staff_ID` varchar(10) NOT NULL,
  `Staff_name` varchar(10) DEFAULT NULL,
  `Staff_sex` char(2) DEFAULT NULL,
  `Staff_age` int DEFAULT NULL,
  `Staff_academic` varchar(20) DEFAULT NULL,
  `Staff_address` varchar(20) DEFAULT NULL,
  `Staff_tel` char(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `Staff_baseSalary` int DEFAULT NULL,
  PRIMARY KEY (`Staff_ID`),
  UNIQUE KEY `staff_inf_Staff_ID_uindex` (`Staff_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_inf`
--

LOCK TABLES `staff_inf` WRITE;
/*!40000 ALTER TABLE `staff_inf` DISABLE KEYS */;
INSERT INTO `staff_inf` VALUES ('001','Eureka','男',21,'大学本科','广东','13267667329',10000),('1','1','男',2,'1','11','1',1),('112','12','男',3,'23','232','23',32),('12','2','男',200,'2','2','2',2),('123','3','男',7,'1','2','1',2);
/*!40000 ALTER TABLE `staff_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_salary`
--

DROP TABLE IF EXISTS `staff_salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_salary` (
  `Staff_ID` varchar(20) DEFAULT NULL,
  `Staff_benefit` int DEFAULT NULL COMMENT '津贴',
  `Staff_livingAllowance` int DEFAULT NULL COMMENT '生活补贴',
  `Staff_shouldPay` int DEFAULT NULL COMMENT '应发工资',
  `Staff_telBill` int DEFAULT NULL COMMENT '电话费',
  `Staff_utiBill` int DEFAULT NULL COMMENT '水电费',
  `Staff_houseRent` int DEFAULT NULL COMMENT '租房费',
  `Staff_incomeTax` int DEFAULT NULL COMMENT '所得税',
  `Staff_sanFee` int DEFAULT NULL COMMENT '卫生费',
  `Staff_accumFunds` int DEFAULT NULL COMMENT '公积金\n',
  `Staff_totalCut` int DEFAULT NULL COMMENT '合计扣款',
  `Staff_netPay` int DEFAULT NULL COMMENT '实发工资',
  `Staff_Date` date DEFAULT NULL,
  `Staff_baseSalary` int NOT NULL COMMENT '基本工资',
  KEY `staff_salary_index` (`Staff_baseSalary`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_salary`
--

LOCK TABLES `staff_salary` WRITE;
/*!40000 ALTER TABLE `staff_salary` DISABLE KEYS */;
INSERT INTO `staff_salary` VALUES ('12',1,1,1,1,1,1,1,1,1,1,1,'2024-04-17',1),('1',1,1,1,1,1,1,1,1,1,1,1,'2022-12-24',2),('12',1,1,202,1,1,1,1,1,1,6,196,'2024-04-03',200);
/*!40000 ALTER TABLE `staff_salary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-13 10:19:48
