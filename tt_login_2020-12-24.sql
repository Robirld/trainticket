# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.30)
# Database: tt_login
# Generation Time: 2020-12-24 10:35:38 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table passenger
# ------------------------------------------------------------

DROP TABLE IF EXISTS `passenger`;

CREATE TABLE `passenger` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `id_num` varchar(20) NOT NULL DEFAULT '' COMMENT '身份证号',
  `phone` varchar(20) DEFAULT NULL,
  `role` varchar(10) NOT NULL DEFAULT '成人',
  `customer_id` int(11) DEFAULT NULL,
  `relation` varchar(10) DEFAULT NULL COMMENT '关系',
  `del_flag` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;

INSERT INTO `passenger` (`id`, `name`, `id_num`, `phone`, `role`, `customer_id`, `relation`, `del_flag`)
VALUES
	(1,'张三','12345678988','12345678909','成人',2,'朋友',b'0'),
	(2,'李四','54354356456345','13344441111','学生',2,NULL,b'0'),
	(3,'李大鹏','653421345655433','15566667777','成人',2,'本人',b'0');

/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
