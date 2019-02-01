-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.3.9-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- coffee 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `coffee` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `coffee`;

-- 테이블 coffee.category 구조 내보내기
CREATE TABLE IF NOT EXISTS `category` (
  `ct_code` varchar(7) NOT NULL,
  `ct_name` varchar(12) DEFAULT NULL,
  `percentP` float DEFAULT 0.1,
  PRIMARY KEY (`ct_code`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;

-- 테이블 데이터 coffee.category:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`ct_code`, `ct_name`, `percentP`) VALUES
	('br', 'bread', 0.1),
	('cf', 'coffee', 0.1),
	('tea', 'tea', 0.1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- 테이블 coffee.client 구조 내보내기
CREATE TABLE IF NOT EXISTS `client` (
  `cId` varchar(20) NOT NULL,
  `cPhone` varchar(11) DEFAULT NULL,
  `cName` varchar(12) DEFAULT NULL,
  `cPoint` int(11) DEFAULT NULL,
  `totalPoint` int(11) DEFAULT NULL,
  PRIMARY KEY (`cId`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;

-- 테이블 데이터 coffee.client:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`cId`, `cPhone`, `cName`, `cPoint`, `totalPoint`) VALUES
	('c002', '123456', 'kys', 0, 33839),
	('customer', '123456', '비회원', 0, 32000),
	('kys', '123456', '김영성', 650, 6500);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- 테이블 coffee.employee 구조 내보내기
CREATE TABLE IF NOT EXISTS `employee` (
  `eNum` varchar(10) NOT NULL,
  `ePhone` varchar(11) DEFAULT NULL,
  `eName` varchar(12) DEFAULT NULL,
  `ePay` int(6) DEFAULT NULL,
  `rank` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`eNum`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;

-- 테이블 데이터 coffee.employee:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`eNum`, `ePhone`, `eName`, `ePay`, `rank`) VALUES
	('e001', '123456', 'kys', 2000000, '0'),
	('m001', '123456', 'm001', 123456, '1');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- 테이블 coffee.payment 구조 내보내기
CREATE TABLE IF NOT EXISTS `payment` (
  `pCode` varchar(30) NOT NULL,
  `pDate` datetime DEFAULT NULL,
  `ptUsed` int(11) DEFAULT NULL,
  `pMoney` int(11) DEFAULT NULL,
  `cId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pCode`),
  KEY `cId_fk` (`cId`),
  CONSTRAINT `cId_fk` FOREIGN KEY (`cId`) REFERENCES `client` (`cId`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=euckr;

-- 테이블 데이터 coffee.payment:~28 rows (대략적) 내보내기
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` (`pCode`, `pDate`, `ptUsed`, `pMoney`, `cId`) VALUES
	('0', '2018-11-09 15:19:59', NULL, 100000, NULL),
	('1', '2018-10-09 15:20:30', NULL, 50000, NULL),
	('2', '2018-10-09 15:20:50', NULL, 80000, 'c002'),
	('3', '2018-09-09 15:21:10', NULL, 70000, 'c002'),
	('c1602', '2018-12-09 16:26:20', 0, 15000, NULL),
	('c1808', '2018-12-11 16:19:55', 81, 14919, 'c002'),
	('c2740', '2018-12-10 15:24:37', 0, 3000, 'c002'),
	('c2996', '2018-12-09 13:01:22', 0, 15000, NULL),
	('c3167', '2018-12-09 13:06:44', 3000, 21000, NULL),
	('c38', '2018-12-11 16:21:21', 0, 13500, 'customer'),
	('c4100', '2018-12-10 16:06:01', 0, 3000, 'customer'),
	('c44', '2018-12-11 12:25:38', 0, 1000, 'customer'),
	('c4503', '2018-12-10 16:19:50', 1363, 4137, NULL),
	('c5041', '2018-12-09 15:13:17', 1455, 13545, NULL),
	('c506', '2018-12-10 16:00:26', 200, 7800, 'c002'),
	('c5138', '2018-12-09 13:02:32', 0, 15000, NULL),
	('c5199', '2018-12-09 16:31:31', 0, 21000, NULL),
	('c5218', '2018-12-09 13:57:15', 200, 14800, NULL),
	('c5753', '2018-12-09 21:39:05', 2000, 13000, NULL),
	('c5978', '2018-12-09 13:58:12', 200, 26800, NULL),
	('c6016', '2018-12-10 16:41:11', 0, 1000, 'customer'),
	('c6751', '2018-12-09 12:57:00', 50, 24000, NULL),
	('c8539', '2018-12-12 01:11:16', 0, 6500, 'kys'),
	('c8575', '2018-12-09 22:43:07', 1300, 13700, NULL),
	('c8957', '2018-12-11 16:20:51', 0, 13500, 'customer'),
	('c9100', '2018-12-12 01:02:16', 0, 9000, NULL),
	('c9155', '2018-12-11 16:17:24', 880, 8120, 'c002'),
	('c9473', '2018-12-09 15:12:28', 450, 14550, NULL),
	('c9770', '2018-12-09 19:15:26', 1000, 9000, NULL),
	('c9875', '2018-12-09 22:44:43', 1370, 13630, NULL);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

-- 테이블 coffee.pointlist 구조 내보내기
CREATE TABLE IF NOT EXISTS `pointlist` (
  `pCode` varchar(30) DEFAULT NULL,
  `cId` varchar(20) DEFAULT NULL,
  `pointMoney` int(6) DEFAULT NULL,
  KEY `FK_pointlist_client` (`cId`),
  KEY `FK_pointlist_payment` (`pCode`),
  CONSTRAINT `FK_pointlist_client` FOREIGN KEY (`cId`) REFERENCES `client` (`cId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_pointlist_payment` FOREIGN KEY (`pCode`) REFERENCES `payment` (`pCode`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=euckr;

-- 테이블 데이터 coffee.pointlist:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `pointlist` DISABLE KEYS */;
INSERT INTO `pointlist` (`pCode`, `cId`, `pointMoney`) VALUES
	('c8539', 'kys', 650);
/*!40000 ALTER TABLE `pointlist` ENABLE KEYS */;

-- 테이블 coffee.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `pCode` int(11) NOT NULL AUTO_INCREMENT,
  `pName` varchar(24) DEFAULT NULL,
  `pPath` varchar(20) DEFAULT NULL,
  `pPrice` varchar(20) DEFAULT NULL,
  `ct_code` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`pCode`),
  KEY `ct_code_fk` (`ct_code`),
  CONSTRAINT `ct_code_fk` FOREIGN KEY (`ct_code`) REFERENCES `category` (`ct_code`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=euckr;

-- 테이블 데이터 coffee.product:~25 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`pCode`, `pName`, `pPath`, `pPrice`, `ct_code`) VALUES
	(12, '아메리카노', '아메리카노.jpg', '1000', 'cf'),
	(13, '오리지널라떼', '오리지널라때.jpg', '2000', 'cf'),
	(14, '초코라떼', '초코라때.jpg', '2500', 'cf'),
	(15, '홍차', '굳차.jpg', '2000', 'tea'),
	(17, '옥수수 빵', '옥수수 빵.jpg', '3500', 'br'),
	(19, '버터 바게트빵', '버터 바게트빵.jpg', '3500', 'br'),
	(21, 'Hot ICE 연유라떼', 'Hot ICE 연유라떼.jpg', '3000', 'cf'),
	(22, '갈릭 버터 브레드', '갈릭 버터 브레드.png', '4000', 'br'),
	(23, '까망베르 치즈케이크', '까망베르 치즈케이크.png', '4500', 'br'),
	(24, '꿀레몬티', '꿀레몬티.png', '2500', 'tea'),
	(25, '꿀유자티', '꿀유자티.png', '2500', 'tea'),
	(26, '꿀자몽티', '꿀자몽티.png', '2600', 'tea'),
	(27, '베이글', '베이글.png', '2700', 'br'),
	(28, '블루베리 아몬드', '블루베리 아몬드 허니 브레드.jpg', '3000', 'br'),
	(29, '아이스 허브티 페퍼먼트', '아이스 허브티 페퍼민트.png', '3000', 'tea'),
	(30, '인절미 허니 브레드', '인절미 허니 브레드.png', '4000', 'br'),
	(31, '초코 페스츄리', '초코 페스츄리.png', '6000', 'br'),
	(32, '치즈 케이크', '치즈 케이크.png', '4000', 'br'),
	(33, '카라멜 시나몬 허니브레드', '카라멜 시나몬 허니브레드.jpg', '4500', 'br'),
	(34, '카라멜마끼아또', '카라멜마끼야또.png', '3000', 'cf'),
	(35, '카페모카', '카페모카.png', '3000', 'cf'),
	(36, '크린베리 베이글', '크랜베리 베이글.png', '3500', 'br'),
	(37, '플레인 베이글', '플레인 베이글.png', '3000', 'br'),
	(38, '핫 홍차 블랙퍼스트', '핫 홍차 블랙퍼스트.png', '2800', 'tea'),
	(39, '헤이즐넛 라떼', '헤이즐넛 라떼.png', '3000', 'cf');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
