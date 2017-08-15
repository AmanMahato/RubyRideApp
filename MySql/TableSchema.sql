CREATE DATABASE  IF NOT EXISTS `RubyRide`;
USE `RubyRide`;

--
-- Table structure for table `PresidentInfo`
--

DROP TABLE IF EXISTS `PresidentInfo`;

CREATE TABLE `PresidentInfo` (
  `birth_order` int(11) NOT NULL,
  `name` varchar(145) NOT NULL,
  PRIMARY KEY (`birth_order`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;