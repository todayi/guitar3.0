DROP DATABASE  IF EXISTS `mission`;
CREATE DATABASE IF NOT EXISTS `mission` ;
USE `mission`;
CREATE TABLE IF NOT EXISTS `guitar` (
  `serialNumber` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `builder` varchar(50) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `topWood` varchar(50) DEFAULT NULL,
  `backwood` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

INSERT INTO `guitar` (`serialNumber`, `price`, `builder`, `model`, `topWood`, `backwood`, `type`, `id`) VALUES
	('6', 1, 'a', 'a', 'a', 'a', 'a', 1),
	('6', 2, 'b', 'a', 'a', 'a', 'a', 2),
	('5', 123, 'a', 'aa', 'b', 'a', 'a', 3),
	('6', 1, 'a', '1', 'a', 'a', 'a', 4),
	('6', 1, 'a', '1', 'a', 'a', 'a', 5),
	('6', 1, 'b', '1', 'a', 'a', 'a', 6),
	('6', 1, 'b', '1', 'a', 'a', 'a', 7);
