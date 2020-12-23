# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.30)
# Database: tt_main
# Generation Time: 2020-12-23 12:39:03 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table active_train
# ------------------------------------------------------------

DROP TABLE IF EXISTS `active_train`;

CREATE TABLE `active_train` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `train_id` int(11) NOT NULL,
  `leave_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `active_train` WRITE;
/*!40000 ALTER TABLE `active_train` DISABLE KEYS */;

INSERT INTO `active_train` (`id`, `train_id`, `leave_time`)
VALUES
	(1,1,'2020-12-30 12:00:00'),
	(2,2,'2020-12-30 11:00:00'),
	(3,3,'2020-12-30 13:00:00'),
	(4,4,'2020-12-30 10:00:00'),
	(5,5,'2020-12-30 14:00:00'),
	(6,6,'2020-12-30 15:00:00');

/*!40000 ALTER TABLE `active_train` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table station
# ------------------------------------------------------------

DROP TABLE IF EXISTS `station`;

CREATE TABLE `station` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `city` varchar(50) NOT NULL DEFAULT '',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '1:已删除',
  PRIMARY KEY (`id`),
  KEY `city` (`city`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;

INSERT INTO `station` (`id`, `name`, `city`, `del_flag`)
VALUES
	(1,'西安南','西安',b'0'),
	(2,'西安','西安',b'0'),
	(3,'西安北','西安',b'0'),
	(4,'洛阳南','洛阳',b'0'),
	(5,'洛阳','洛阳',b'0'),
	(6,'北京西','北京',b'0'),
	(7,'北京东','北京',b'0'),
	(8,'北京','北京',b'0'),
	(9,'渭南','渭南',b'0'),
	(10,'渭南北','渭南',b'0');

/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table timetable
# ------------------------------------------------------------

DROP TABLE IF EXISTS `timetable`;

CREATE TABLE `timetable` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `train_number` varchar(20) NOT NULL DEFAULT '' COMMENT '车次',
  `train_date` datetime NOT NULL,
  `station_id` int(11) NOT NULL COMMENT '车站ID',
  `leave_time` datetime DEFAULT NULL COMMENT '离站时间',
  `arrive_time` datetime DEFAULT NULL COMMENT '到达时间',
  `wait_time` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '等待时间',
  `current_tickit_num` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '当前站到下一站的余票',
  PRIMARY KEY (`id`),
  KEY `number_date` (`train_number`,`train_date`),
  KEY `station_id` (`station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;

INSERT INTO `timetable` (`id`, `train_number`, `train_date`, `station_id`, `leave_time`, `arrive_time`, `wait_time`, `current_tickit_num`)
VALUES
	(1,'A01','2020-12-30 12:00:00',2,'2020-12-30 12:00:00',NULL,0,1000),
	(2,'A01','2020-12-30 12:00:00',9,'2020-12-30 13:00:00','2020-12-30 12:50:00',600,1000),
	(3,'A01','2020-12-30 12:00:00',5,'2020-12-30 15:00:00','2020-12-30 14:50:00',600,1000),
	(4,'A01','2020-12-30 12:00:00',8,NULL,'2020-12-30 19:00:00',0,0),
	(5,'A02','2020-12-30 13:00:00',3,'2020-12-30 13:00:00',NULL,0,1000),
	(6,'A02','2020-12-30 13:00:00',10,'2020-12-30 13:25:00','2020-12-30 13:21:00',240,1000),
	(7,'A02','2020-12-30 13:00:00',5,'2020-12-30 14:10:00','2020-12-30 14:00:00',600,1000),
	(8,'A02','2020-12-30 13:00:00',6,NULL,'2020-12-30 16:30:00',0,0),
	(9,'A07','2020-12-30 11:00:00',8,'2020-12-30 11:00:00',NULL,0,1000),
	(10,'A07','2020-12-30 11:00:00',5,'2020-12-30 13:10:00','2020-12-30 13:00:00',600,0),
	(11,'A07','2020-12-30 11:00:00',9,'2020-12-30 15:06:00','2020-12-30 15:00:00',360,0),
	(12,'A07','2020-12-30 11:00:00',2,NULL,'2020-12-30 15:50:00',0,0);

/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table train
# ------------------------------------------------------------

DROP TABLE IF EXISTS `train`;

CREATE TABLE `train` (
  `number` varchar(20) NOT NULL DEFAULT '' COMMENT '车次',
  `path` varchar(255) NOT NULL DEFAULT '' COMMENT '路线',
  `init_ticket_num` int(11) unsigned NOT NULL,
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '1:已删除',
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;

INSERT INTO `train` (`number`, `path`, `init_ticket_num`, `del_flag`)
VALUES
	('A01','西安-渭南-洛阳-北京',1000,b'0'),
	('A02','西安北-渭南北-洛阳-北京西',1000,b'0'),
	('A03','西安-渭南-洛阳-北京西',1000,b'0'),
	('A04','西安北-渭南北-洛阳-北京',1000,b'0'),
	('A05','西安-渭南北-洛阳南-北京',1000,b'0'),
	('A06','西安北-渭南北-洛阳南-北京西',1000,b'0'),
	('A07','北京-洛阳-渭南-西安',1000,b'0');

/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
