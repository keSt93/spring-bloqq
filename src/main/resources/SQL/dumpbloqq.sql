-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server Version:               10.1.16-MariaDB - mariadb.org binary distribution
-- Server Betriebssystem:        Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Exportiere Struktur von Tabelle bloqq.bloqq_post
CREATE TABLE IF NOT EXISTS `bloqq_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titel` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `content` mediumtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `BloqqPost_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Exportiere Daten aus Tabelle bloqq.bloqq_post: ~2 rows (ungefähr)
/*!40000 ALTER TABLE `bloqq_post` DISABLE KEYS */;
INSERT INTO `bloqq_post` (`id`, `titel`, `create_date`, `updated`, `content`) VALUES
	(1, 'Bespiel', '2018-02-19 09:01:25', '2018-02-21 09:01:35', 'BOIBOIBOBIBOIBOIBOBIBI'),
	(2, 'Noch ein Bsp', '2018-03-14 11:27:04', '2018-03-14 11:27:08', 'BEISPIELCONTENT');
/*!40000 ALTER TABLE `bloqq_post` ENABLE KEYS */;


-- Exportiere Struktur von Tabelle bloqq.kommentar
CREATE TABLE IF NOT EXISTS `kommentar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kommentar` mediumtext,
  `userId` int(11) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `bloqq_postId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `kommentar_user_id_fk` (`userId`),
  KEY `kommentar_bloqq_post_id_fk` (`bloqq_postId`),
  CONSTRAINT `kommentar_bloqq_post_id_fk` FOREIGN KEY (`bloqq_postId`) REFERENCES `bloqq_post` (`id`),
  CONSTRAINT `kommentar_user_id_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportiere Daten aus Tabelle bloqq.kommentar: ~0 rows (ungefähr)
/*!40000 ALTER TABLE `kommentar` DISABLE KEYS */;
/*!40000 ALTER TABLE `kommentar` ENABLE KEYS */;


-- Exportiere Struktur von Tabelle bloqq.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `creation_date` datetime DEFAULT NULL,
  `picture` blob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `table_name_userName_uindex` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- Exportiere Daten aus Tabelle bloqq.user: ~4 rows (ungefähr)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `user_name`, `password`, `creation_date`, `picture`) VALUES
	(22, 'beispiel', '0a386edc641e05a6232eb4eedbfd8da764cdb43349c03bdd9c9949e4fb2efe3968dea46b3bcc2309bc14a22c3859ab030de00b7eb6a8674b38154a912a86d08a', '2018-03-19 16:54:22', NULL),
	(23, 'test', '25aaab7b63dfdb34e899ca0d7c7dbe249686143b798e7d416027226c14d140931a4003a54e0ec8fbbc3a75ccf689ad22ad82af2331bbdef7dda39e80b2089326', '2018-03-21 08:48:17', NULL),
	(24, 'uhhh', '06d54a0a1a6e56ec3c7df2ede148cf88cc12a81f545f8a41827d82c0791af020f240adc642ee1b58011fed261c2def3fe2ebe646e9e6e5e676c475a3c8f92a7d', '2018-03-21 10:19:15', NULL),
	(25, 'dikkeman69', '83e3debf72b3df401f3f460aff8b648eb56ba8c1d38b1975d9c3d1ef15d27d303caa55f9dd30eeedceedd4803e197f9de3bd732be417f0d67aa381d3963a2e24', '2018-03-21 10:39:58', NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
