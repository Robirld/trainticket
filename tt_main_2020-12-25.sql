# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.30)
# Database: tt_main
# Generation Time: 2020-12-25 11:44:51 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table tt_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tt_order`;

CREATE TABLE `tt_order` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) unsigned NOT NULL,
  `passenger_id` int(11) unsigned NOT NULL,
  `train_number` varchar(20) NOT NULL DEFAULT '',
  `leave_station_id` int(11) unsigned NOT NULL,
  `arrive_station_id` int(10) unsigned NOT NULL,
  `leave_time` datetime NOT NULL,
  `arrive_time` datetime NOT NULL,
  `price` double unsigned NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pay_time` datetime DEFAULT NULL,
  `del_flag` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `passenger_id` (`passenger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tt_order` WRITE;
/*!40000 ALTER TABLE `tt_order` DISABLE KEYS */;

INSERT INTO `tt_order` (`id`, `customer_id`, `passenger_id`, `train_number`, `leave_station_id`, `arrive_station_id`, `leave_time`, `arrive_time`, `price`, `create_time`, `pay_time`, `del_flag`)
VALUES
	(00000000001,2,3,'A01',2,8,'2020-12-30 04:00:00','2020-12-30 11:00:00',100,'2020-12-25 18:00:25',NULL,b'0'),
	(00000000004,2,2,'A01',2,8,'2020-12-30 04:00:00','2020-12-30 11:00:00',100,'2020-12-25 19:31:14',NULL,b'0');

/*!40000 ALTER TABLE `tt_order` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
