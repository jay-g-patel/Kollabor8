CREATE DATABASE  IF NOT EXISTS `pateljg_fyp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pateljg_fyp`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: pateljg_fyp
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `boardID` int(11) NOT NULL AUTO_INCREMENT,
  `boardName` varchar(45) DEFAULT NULL,
  `boardcol` varchar(45) DEFAULT '0',
  PRIMARY KEY (`boardID`),
  UNIQUE KEY `boardID_UNIQUE` (`boardID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (6,'testboard 1','2');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boardcolumn`
--

DROP TABLE IF EXISTS `boardcolumn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boardcolumn` (
  `columnID` int(11) NOT NULL AUTO_INCREMENT,
  `boardID` int(11) NOT NULL DEFAULT '0',
  `name` varchar(45) DEFAULT NULL,
  `position` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`columnID`),
  UNIQUE KEY `columnID_UNIQUE` (`columnID`),
  KEY `fk_column_board_idx` (`boardID`),
  CONSTRAINT `fk_boardColumn_boardID` FOREIGN KEY (`boardID`) REFERENCES `board` (`boardID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boardcolumn`
--

LOCK TABLES `boardcolumn` WRITE;
/*!40000 ALTER TABLE `boardcolumn` DISABLE KEYS */;
INSERT INTO `boardcolumn` VALUES (75,6,'jayscolumn',1),(76,6,'fred',2);
/*!40000 ALTER TABLE `boardcolumn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story`
--

DROP TABLE IF EXISTS `story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `story` (
  `storyID` int(11) NOT NULL AUTO_INCREMENT,
  `columnid` int(11) DEFAULT '0',
  `storyType` int(11) DEFAULT '1',
  `user` int(11) DEFAULT '0',
  `description` varchar(45) DEFAULT NULL,
  `dependencies` varchar(45) DEFAULT NULL,
  `storystatusid` int(11) DEFAULT '0',
  `boardID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`storyID`),
  UNIQUE KEY `storyID_UNIQUE` (`storyID`),
  KEY `fk_story_column_idx` (`columnid`),
  KEY `fk_story_user_idx` (`user`),
  KEY `fk_story_storyType_idx` (`storyType`),
  KEY `fk_story_groupID_idx` (`boardID`),
  KEY `fk_story_storyStatus_idx` (`storystatusid`),
  CONSTRAINT `fk_story_storyTypeID` FOREIGN KEY (`storyType`) REFERENCES `storytype` (`storyTypeID`) ON UPDATE CASCADE,
  CONSTRAINT `fk_story_boardID` FOREIGN KEY (`boardID`) REFERENCES `board` (`boardID`) ON UPDATE CASCADE,
  CONSTRAINT `fk_story_columnID` FOREIGN KEY (`columnid`) REFERENCES `boardcolumn` (`columnID`) ON UPDATE CASCADE,
  CONSTRAINT `fk_story_storyStatus` FOREIGN KEY (`storystatusid`) REFERENCES `storystatus` (`storyStatusID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_story_userID` FOREIGN KEY (`user`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story`
--

LOCK TABLES `story` WRITE;
/*!40000 ALTER TABLE `story` DISABLE KEYS */;
INSERT INTO `story` VALUES (34,76,NULL,NULL,'testStory',NULL,NULL,6),(35,76,NULL,NULL,'test story',NULL,NULL,6);
/*!40000 ALTER TABLE `story` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storystatus`
--

DROP TABLE IF EXISTS `storystatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storystatus` (
  `storyStatusID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`storyStatusID`),
  UNIQUE KEY `storyTypeID_UNIQUE` (`storyStatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storystatus`
--

LOCK TABLES `storystatus` WRITE;
/*!40000 ALTER TABLE `storystatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `storystatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storytype`
--

DROP TABLE IF EXISTS `storytype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storytype` (
  `storyTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`storyTypeID`),
  UNIQUE KEY `storyTypeID_UNIQUE` (`storyTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storytype`
--

LOCK TABLES `storytype` WRITE;
/*!40000 ALTER TABLE `storytype` DISABLE KEYS */;
INSERT INTO `storytype` VALUES (1,'boardStory');
/*!40000 ALTER TABLE `storytype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentgroup`
--

DROP TABLE IF EXISTS `studentgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentgroup` (
  `groupID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `board` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`groupID`),
  UNIQUE KEY `groupID_UNIQUE` (`groupID`),
  KEY `fk_board_idx` (`board`),
  CONSTRAINT `fk_studentGroup_boardID` FOREIGN KEY (`board`) REFERENCES `board` (`boardID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentgroup`
--

LOCK TABLES `studentgroup` WRITE;
/*!40000 ALTER TABLE `studentgroup` DISABLE KEYS */;
INSERT INTO `studentgroup` VALUES (5,'test group 1',6);
/*!40000 ALTER TABLE `studentgroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `taskID` int(11) NOT NULL AUTO_INCREMENT,
  `story` int(11) NOT NULL DEFAULT '0',
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`taskID`),
  UNIQUE KEY `taskID_UNIQUE` (`taskID`),
  KEY `fk_task_story_idx` (`story`),
  CONSTRAINT `fk_task_storyID` FOREIGN KEY (`story`) REFERENCES `story` (`storyID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userType` int(11) DEFAULT NULL,
  `groupID` int(11) DEFAULT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  KEY `fk_user_userType_idx` (`userType`),
  KEY `fk_user_groupID_idx` (`groupID`),
  CONSTRAINT `fk_user_groupID` FOREIGN KEY (`groupID`) REFERENCES `studentgroup` (`groupID`) ON UPDATE CASCADE,
  CONSTRAINT `fk_user_userTypeID` FOREIGN KEY (`userType`) REFERENCES `usertype` (`userTypeID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10,2,5,'jay','jay');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertype` (
  `userTypeID` int(11) NOT NULL AUTO_INCREMENT COMMENT '1 = admin',
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userTypeID`),
  UNIQUE KEY `userTypeID_UNIQUE` (`userTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (1,'admin'),(2,'user');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pateljg_fyp'
--

--
-- Dumping routines for database 'pateljg_fyp'
--
/*!50003 DROP PROCEDURE IF EXISTS `boardColumnCount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `boardColumnCount`(IN bID INT)
BEGIN

SET @colCount = (SELECT COUNT(*) 
FROM `pateljg_fyp`.`boardcolumn`
WHERE `boardID` = bID);

UPDATE `pateljg_fyp`.`board`
SET
`boardcol` = @colCount
WHERE `boardID` = bID;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CreateNewBoardColumn` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateNewBoardColumn`(IN colName VARCHAR(255),
										IN bID INT,
OUT cID INT,OUT cPos INT)
BEGIN

SELECT IF(MAX(position) IS NULL, 1, MAX(position)+1) INTO cPos
FROM `pateljg_fyp`.`boardcolumn`
WHERE boardcolumn.boardID = bID;

INSERT INTO `pateljg_fyp`.`boardcolumn`
(`boardID`,
`name`,
`position`)
VALUES
(bID,
colName,
cPos);

SET cID = LAST_INSERT_ID();

CALL `pateljg_fyp`.`boardColumnCount`(bID);


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CreateNewColumnStory` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateNewColumnStory`(IN colID INT, IN sDesc VARCHAR(255), OUT sID INT)
BEGIN
SET @bID = (
SELECT boardcolumn.boardID
    FROM boardcolumn
    WHERE boardcolumn.columnID = colID);
INSERT INTO `pateljg_fyp`.`story`
(
`storyType`,
`user`,
`columnid`,
`description`,
`dependencies`,
`storystatusid`,
`boardID`)
VALUES
(null,
null,
colID,
sDesc,
NULL,
NULL,
@bID);

SET sID = LAST_INSERT_ID();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-29 17:52:06
