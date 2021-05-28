-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.24 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for price_engine
CREATE DATABASE IF NOT EXISTS `price_engine` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `price_engine`;

-- Dumping structure for table price_engine.tbl_product
CREATE TABLE IF NOT EXISTS `tbl_product` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) NOT NULL DEFAULT '',
  `REMARKS` varchar(200) DEFAULT '',
  `PRICE_PER_CARTON` double NOT NULL DEFAULT '0',
  `UNIT_PER_CARTON` int NOT NULL DEFAULT '0',
  `CARTON_WISE_DISCOUNT` double NOT NULL,
  `SINGLE_UNIT_COMPENSATE_VALUE` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table price_engine.tbl_product: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
INSERT INTO `tbl_product` (`ID`, `NAME`, `REMARKS`, `PRICE_PER_CARTON`, `UNIT_PER_CARTON`, `CARTON_WISE_DISCOUNT`, `SINGLE_UNIT_COMPENSATE_VALUE`) VALUES
	(1, 'Test', 'rare', 185, 20, 10, 30);
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;

-- Dumping structure for table price_engine.tbl_stock
CREATE TABLE IF NOT EXISTS `tbl_stock` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` bigint NOT NULL DEFAULT '0',
  `CARTON_QTY` bigint DEFAULT '0',
  `UNIT_QTY` bigint DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FKo8mybc2mw82rhti4t1n9i1d0e` (`PRODUCT_ID`),
  CONSTRAINT `FKo8mybc2mw82rhti4t1n9i1d0e` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `tbl_product` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table price_engine.tbl_stock: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_stock` DISABLE KEYS */;
INSERT INTO `tbl_stock` (`ID`, `PRODUCT_ID`, `CARTON_QTY`, `UNIT_QTY`) VALUES
	(1, 1, 20, 400);
/*!40000 ALTER TABLE `tbl_stock` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
