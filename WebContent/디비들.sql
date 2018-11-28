/*
 * //DBMS : mariaDB   디비이름 : coffee   비밀번호 : 123456
 * 
 */


//사원 테이블
create table coffee.employee(
	eNum varchar(12) primary key,
	ePhone varchar(12) ,
	eName varchar(12),
	ePqy int(7),
	ePart varchar(4)
	);
	
// 고객 테이블
CREATE TABLE `client` (
	`cId` VARCHAR(12) NULL DEFAULT NULL,
	`cPhone` VARCHAR(8) NULL DEFAULT NULL,
	`cName` VARCHAR(27) NULL DEFAULT NULL,
	`cPoint` INT(7) NULL DEFAULT NULL
)