/*
 * //DBMS : mariaDB   디비이름 : coffee   비밀번호 : 123456
 * 
 */


category
CREATE TABLE `category` (
	`ct_code` VARCHAR(7) NOT NULL,
	`ct_name` VARCHAR(12) NULL DEFAULT NULL,
	PRIMARY KEY (`ct_code`)
)

client
CREATE TABLE `client` (
	`cId` VARCHAR(20) NOT NULL,
	`cPhone` VARCHAR(11) NULL DEFAULT NULL,
	`cName` VARCHAR(12) NULL DEFAULT NULL,
	`cPoint` INT(6) NULL DEFAULT NULL,
	`totalPoint` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`cId`)
)

employee
CREATE TABLE `employee` (
	`eNum` VARCHAR(10) NOT NULL,
	`ePhone` VARCHAR(11) NULL DEFAULT NULL,
	`eName` VARCHAR(12) NULL DEFAULT NULL,
	`ePay` INT(6) NULL DEFAULT NULL,
	`rank` VARCHAR(1) NULL DEFAULT NULL,
	PRIMARY KEY (`eNum`)
)

payment
CREATE TABLE `payment` (
	`pCode` VARCHAR(7) NOT NULL COLLATE 'utf8_general_ci',
	`pDate` DATE NULL DEFAULT NULL,
	`ptUsed` INT(11) NULL DEFAULT NULL,
	`pMoney` INT(8) NULL DEFAULT NULL,
	`pBonus` INT(8) NULL DEFAULT NULL,
	`cId` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`eNum` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`pCode`),
	INDEX `payment` (`cId`),
	INDEX `payment1` (`eNum`),
	CONSTRAINT `payment` FOREIGN KEY (`cId`) REFERENCES `client` (`cId`),
	CONSTRAINT `payment1` FOREIGN KEY (`eNum`) REFERENCES `employee` (`eNum`)
)
COLLATE='euckr_korean_ci'
ENGINE=InnoDB
;


point_list
CREATE TABLE `point_list` (
	`pay_Code` VARCHAR(7) NULL DEFAULT NULL,
	`cId` VARCHAR(20) NULL DEFAULT NULL,
	`iPoint` INT(6) NULL DEFAULT NULL,
	INDEX `point_list` (`pay_Code`),
	INDEX `point_list1` (`cId`),
	CONSTRAINT `point_list` FOREIGN KEY (`pay_Code`) REFERENCES `payment` (`pay_Code`),
	CONSTRAINT `point_list1` FOREIGN KEY (`cId`) REFERENCES `client` (`cId`)
)

product
CREATE TABLE `product` (
	`pCode` INT(11) NOT NULL AUTO_INCREMENT,
	`pName` VARCHAR(24) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`pPath` VARCHAR(500) NULL DEFAULT NULL,
	`pPrice` VARCHAR(5) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`ct_code` VARCHAR(7) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`pCode`),
	INDEX `product` (`ct_code`),
	CONSTRAINT `product` FOREIGN KEY (`ct_code`) REFERENCES `category` (`ct_code`)
)
COLLATE='euckr_korean_ci'
ENGINE=InnoDB
AUTO_INCREMENT=12
;


purchase_item
CREATE TABLE `purchase_item` (
	`pi_Id` VARCHAR(20) NOT NULL,
	`pay_Code` VARCHAR(7) NULL DEFAULT NULL,
	`pCode` VARCHAR(7) NULL DEFAULT NULL,
	PRIMARY KEY (`pi_Id`),
	INDEX `purchase_item` (`pay_Code`),
	INDEX `purchase_item1` (`pCode`),
	CONSTRAINT `purchase_item` FOREIGN KEY (`pay_Code`) REFERENCES `payment` (`pay_Code`),
	CONSTRAINT `purchase_item1` FOREIGN KEY (`pCode`) REFERENCES `product` (`pCode`)
)